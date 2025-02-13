package DAO;

import java.sql.SQLException;

import beans.Medico;
import io.basc.framework.sql.SqlException;

public class MedicoDAO extends DAO {
	
	public void inserir(Medico medico) {		
		sql = "INSERT INTO cp_medico values(?,?)";
		try {
			connection.setAutoCommit(false);
		ps = connection.prepareStatement(sql);
		
		ps.setInt(1, medico.getId());
		ps.setString(2, medico.getNome());
		
		System.out.println("inseriu médico em cp_medico\n" + medico.getId() + medico.getNome());

		ps.execute();
		connection.commit();
		
		} catch(SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				System.out.println("erro ao cadastrar o usuário\n" + e1);
			}
			e.printStackTrace();
		} finally {
	        try {
	            // Não fechar a conexão aqui
	            if (ps != null) ps.close();
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public int geraId() {
		int id=0;
		try {
			sql = "SELECT MAX(id) AS maior_id FROM cp_medico";
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
				while(rs.next()) {
					if(rs.getInt("maior_id") < 500) {
						id = 500;
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

	public int procuraMedico(String nome) {
		int idMedico = 0;
		sql = "SELECT id FROM cp_medico where nome = ?";
		
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, nome);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				idMedico = rs.getInt("id");
				System.out.println("id do médico: " + rs.getInt("id"));

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
		
		
		return idMedico;
	}
	
	public int calculaQuantidadeAtendimentos(int id) {
		int qtd =0;
		
		try {
			sql = "SELECT * FROM cp_atendimento where id_medico = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				qtd++;
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
		return qtd;
	}
}
