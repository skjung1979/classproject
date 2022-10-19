package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTestSK {

	public static void main(String[] args) {

		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "insert into dept values(?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 50);
			pstmt.setString(2, "개발");
			pstmt.setString(3, "서울");
			
			int result = pstmt.executeUpdate(); // int값 반환
			
			if (result>0) {
				System.out.println("insert 완료!!!");
			}
			
			pstmt.close();
			conn.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
