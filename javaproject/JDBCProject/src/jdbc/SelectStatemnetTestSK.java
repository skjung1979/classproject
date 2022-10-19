package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatemnetTestSK {

	public static void main(String[] args) {

		try {
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			if (conn != null) {
				System.out.println("데이터베이스 연결 성공!");
			}
			
			Statement stmt = conn.createStatement();
			
			String sql = "select * from dept";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				
				System.out.printf("%d \t %s \t %s \n", deptno, dname, loc);
			}
			
			rs.close();
			stmt.close();
			conn.close();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	

	}

}
