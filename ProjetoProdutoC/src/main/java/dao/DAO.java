package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import control.ConnectionFactory;

public class DAO {
	protected Connection connection;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	public DAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	public void close() {
		/*try {		
			ps.close();
			rs.close();
			
		} catch(SQLException e) {
			
		}*/
	}
	
}