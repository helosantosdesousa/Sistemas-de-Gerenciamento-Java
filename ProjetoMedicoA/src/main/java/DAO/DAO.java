package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.ConnectionFactory;
import io.basc.framework.util.ResultSet;

public class DAO {
	protected String sql;
	protected PreparedStatement ps;
	protected java.sql.ResultSet rs;
	protected Connection connection;
	
	public DAO() {
		this.connection = ConnectionFactory.getInstance().getConnection();
	}
	
	
}
