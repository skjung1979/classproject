package book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//project DEPTManagerSK2
public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
		
		return conn;
		
	}
}
