package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectPreparedStatementTestSK {

	public static void main(String[] args) {
	
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "select * from dept where deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.printf("%d \t %s \t %s \n", deptno, dname, loc);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}
