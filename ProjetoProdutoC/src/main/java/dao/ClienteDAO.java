package dao;
import java.sql.Connection;
import java.sql.SQLException;

import beans.Cliente;
import control.ConnectionFactory;

public class ClienteDAO extends DAO {

	public ClienteDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public void cadastrarCliente(Cliente cliente) {
		
		try {
            connection.setAutoCommit(false);

			sql = "INSERT INTO cp_cliente values(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getFone());
			ps.setString(4, cliente.getEmail());
			
			ps.execute();
            connection.commit();
		} catch(SQLException e) {
			e.printStackTrace();
            
            try {
                connection.rollback(); // Reverte a transação em caso de erro
             } catch (SQLException rollbackEx) {
             rollbackEx.printStackTrace();
             } 		
		}
		
	}
	
	/*public void deletar() {
		try {
			sql = "DELETE FROM cp_cliente where id > 500";
			
			ps = connection.prepareStatement(sql);
			ps.execute();
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		close();

	}*/
		public int selecionaID() {
			int id=0;
			
			
			
			try {
				sql = "SELECT MAX(id) AS maior_id FROM cp_cliente";
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					id = rs.getInt("maior_id");
					//System.out.println("resultado id query " + id);
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			//System.out.println(id);
			//System.out.println(id);
			
			/*mudei a regra para 600 por causa do bug no sql developer rss..)*/
			
			if(id>=600) {
				id++;
			} else {
				id=600;
			}
			//id = 500;
			close();

			return id;
		}
		
	
	}
