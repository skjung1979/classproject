package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectPreparedStatementTest {

	public static void main(String[] args) {

		// 기본 순서
		// 1. 드라이버 로드 (생략 가능)
		try {
			// Driver 로드 생략 가능!
			//Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 객체 생성
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe"; // -> 오라클
			//String dburl = "jdbc:mysql://localhost:3307/project";  // -> MySQL
		
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			// 여기는 생략 가능!!!
			if (conn != null) {
				System.out.println("데이터베이스 연결!!!");
			}
			
			// 3. Statement(select, execute) or PreparedStatement
			String sql = "select * from dept where deptno=?";
			
			// 쿼리문에 ?가 있는 경우는 PreparedStament로 생성
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 10); // 첫번째 ?의 값을 10으로 넣겠다.
			
			// 4. ResultSet: select의 결과를 담고 있는 객체
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				// db의 컬럼명을 명시할 경우 (or 컴럼 위치 순번으로도 가능)
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
						
				System.out.printf("%d \t %s \t %s\n", deptno, dname, loc);	
			}				
			rs.close();
			pstmt.close();
			conn.close();							
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
