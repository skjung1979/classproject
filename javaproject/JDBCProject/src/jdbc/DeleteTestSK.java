package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTestSK {

	public static void main(String[] args) {

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "delete from dept where deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 40);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("Delete 성공!!!");
			}
			
			pstmt.close();
			conn.close();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
	}
}
