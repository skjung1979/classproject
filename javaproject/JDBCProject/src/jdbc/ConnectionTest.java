package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {

		// 기본 순서
		// 1. 드라이버 로드 (생략 가능)
		try {
			// 생략 가능!!!
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; // -> 오라클 dburl
			//String dburl = "jdbc:mysql://localhost:3307/project";  // -> MySQL dburl
		
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			if (conn != null) {
				System.out.println("데이터베이스 연결!!!");
				conn.close(); // 테스트용이라 바로 닫았음
			}
			
			// 3. Statement(select, excute) or PreparedStatement
			// 4. ResultSet

		} catch (SQLException e) {
			e.printStackTrace();
		}

		

	}

}
