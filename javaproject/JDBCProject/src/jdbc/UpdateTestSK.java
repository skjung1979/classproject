package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTestSK {

	public static void main(String[] args) {

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			if (conn != null) {
				System.out.println("데이터베이스 연결 성공!!!");
			}
			
			String sql = "update dept set dname=?, loc=? where deptno=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "기획");
			pstmt.setString(2, "제주");
			pstmt.setInt(3, 40);
			
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("update 성공!!!");
		
			}
			
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
