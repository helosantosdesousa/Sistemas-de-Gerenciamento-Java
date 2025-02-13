package dao;

import java.sql.Connection;
import java.sql.SQLException;

import beans.Cliente;
import beans.Pedido;
import beans.Produto;
import control.ConnectionFactory;

public class PedidoDAO extends DAO {
	
	public PedidoDAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
		}
	
	Cliente cliente = new Cliente();
	Produto produto = new Produto();
	
	public void inserir(Pedido pedido) {
		System.out.println("chamou inserir pedido");
		 
		try {	
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO cp_pedido values (?,?,?,?)";
			ps = connection.prepareStatement(sql);
			
			System.out.println("id pedido: " + pedido.getId());
			System.out.println("cliente: " + pedido.getCliente().getNome());
			System.out.println("produto id: " + pedido.getProduto().getId());
			
			
			ps.setInt(1, pedido.getId());
			ps.setInt(2, pedido.getProduto().getId());
			ps.setInt(3, pedido.getCliente().getId());
			ps.setString(4, pedido.getDate());
			
			ps.execute();
			connection.commit();
			
		} catch (SQLException e) {
            e.printStackTrace();
            /*try {
                // Rollback em caso de erro
                connection.rollback();
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }*/
		}
            
	}
	
	public int selecionaID() {
		int id=0;
		
		try {
			sql = "SELECT MAX(id) AS maior_id FROM cp_pedido";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("maior_id");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
				
		if(id>=1000) {
			id++;
		} else {
			id=1000;
		}

		return id;	
	}
	
	public Cliente buscaCliente(int idCliente) {
		Cliente cliente = new Cliente();
		try {
			sql = "SELECT * FROM cp_cliente where id =? ";
			ps = connection.prepareStatement(sql);
			
			
			ps.setInt(1, idCliente);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				cliente.setNome(rs.getNString("nome"));
				cliente.setFone(rs.getString("fone"));
				cliente.setEmail(rs.getString("email"));
				cliente.setId(rs.getInt("id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	public Produto buscaProduto(int idProduto) {
		Produto produto = new Produto();
		
		try {
			sql = "SELECT * FROM cp_produto where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, idProduto);
			
			System.out.println("chamou id produto");
			
			rs = ps.executeQuery();
			while(rs.next()) {
				produto.setDescricao(rs.getString("descricao"));
				produto.setValor(rs.getDouble("valor"));
				produto.setId(rs.getInt("id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}
	
}
