package DAO;

import java.sql.SQLException;


public class TurnoDAO extends DAO {
	
	public int procuraTurno(String turno) {
		int id=0;
		
		try {
			sql = "SELECT id FROM cp_turno where nome = ?";
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, turno);
			
			rs = ps.executeQuery();

			while(rs.next()) {
				id = rs.getInt("id");
				System.out.println("id do turno: " + id);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
	        try {
	            if (ps != null) ps.close();
	            if (rs != null) rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
		return id;
	}

}
