package DAO;

import java.sql.SQLException;

import beans.Atendimento;

public class AtendimentoDAO extends DAO {
	
	public void inserir(Atendimento atendimento) {
		try {
			System.out.println("chamou inserir atendimento");
			//connection.setAutoCommit(false);
			
			sql = "INSERT INTO cp_atendimento (id, id_medico, id_turno, valor) values(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			System.out.println("inserindo....");
			
			ps.setInt(1, atendimento.getId());
			ps.setInt(2, atendimento.getIdMedico());
			ps.setInt(3, atendimento.getIdTurno());
			ps.setDouble(4,atendimento.getValor());
			System.out.println("sets....");

			
			
			ps.execute();
			System.out.println("executou");
			//connection.commit();
			//System.out.println("comitou");

			System.out.println("cadastrei\n" + "medico: " + atendimento.getIdMedico() + " id: " + atendimento.getId());
		}catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				System.out.println("erro ao cadastrar o atendimento\n" + e1);
			}
			e.printStackTrace();
		} finally {
	        try {
	            if (ps != null) ps.close();
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}
	
	public int gerarID() {
		int id =0;
		try {
			sql = "SELECT MAX(id) AS maior_id FROM cp_atendimento";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getInt("maior_id") < 1000) {
					id = 1000;
				} else {
					id = rs.getInt("maior_id")+1;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            // Fechar os recursos, mas não a conexão
	            if (ps != null) ps.close();
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

		return id;
	}
	
}
