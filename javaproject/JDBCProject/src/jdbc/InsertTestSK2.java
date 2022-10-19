package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertTestSK2 {

	public static void main(String[] args) {

		// 1. 드라이버로드 생략가능
		// 2. Connection 객체 생성
		// 3. Statement or PreparedStatement 객체 생성: 쿼리문 ? 유무에 따라
		// 4. ResultSet(select문 / exexcuteQuery()) 
		// or Result(select문이 아닌 경우 / executeUpdate())
		
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		
		try {
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "insert into book values (?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 12);
			pstmt.setString(2, "그대사랑합니다.");
			pstmt.setString(3, "LOVE");
			pstmt.setInt(4, 19000);
			
			int result = pstmt.executeUpdate();
			
			if (result>0) {
				System.out.println("Insert 완료!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
