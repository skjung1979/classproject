package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest {

	public static void main(String[] args) {

		// 기본 순서
		// 1. 드라이버 로드 (생략 가능)
		try {
			// Driver 로드 생략 가능!
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; // -> 오라클 dburl
			//String dburl = "jdbc:mysql://localhost:3307/project";  // -> MySQL dburl
		
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			// 여기는 생략 가능!!!
			if (conn != null) {
				System.out.println("데이터베이스 연결!!!");
				// conn.close(); // 테스트용이라 바로 닫았었음
			}
			
			// 3. Statement(select, execute) or PreparedStatement
			// update => 자동 커밋
			String sql = "update dept set dname=?, loc=? where deptno=?";
			
			// 쿼리문에 ?가 있는 경우는 PreparedStament로 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "기획"); // 첫번째 ?의 값을 "기획"으로 넣겠다.
			pstmt.setString(2, "제주"); // 두번째 ?의 값은 "제주"로 넣겠다.
			pstmt.setInt(3, 50); // 세번째 ?의 값은 50으로 넣겠다.
			
			int result = pstmt.executeUpdate(); // int로 반환 된다.
			
			if (result>0) {
				System.out.println("Update 완료!!!");
			}
						
			pstmt.close();
			conn.close();
						
			// 4. ResultSet insert에서는 필요없다!!!

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
