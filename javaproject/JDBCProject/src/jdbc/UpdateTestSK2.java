package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTestSK2 {

	public static void main(String[] args) {

		// 1. 드라이버로드 생략가능
		// 2. Connection 객체 생성
		// 3. Statement or PreparedStatement 객체 생성: 쿼리문 ? 유무에 따라
		// 4. ResultSet(select문 / exexcuteQuery()) 
		// or Result(select문이 아닌 경우 / executeUpdate())
		
		try {
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "update book set price=price*? where publisher=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setFloat(1, 1.2f);
			pstmt.setString(2, "이상미디어");
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println("Update 완료!");
			}
			
			pstmt.close();
			conn.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
