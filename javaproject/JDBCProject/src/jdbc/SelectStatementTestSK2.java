package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectStatementTestSK2 {

	public static void main(String[] args) {

		// 1. 드라이버로드 생략가능
		
		try {
			
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
			
			// 2. Connection 객체 생성
			Connection conn = DriverManager.getConnection(dburl, "scott", "tiger");
			
			String sql = "select * from book";
			String sqlCond = "select * from book where price>=?";
			
			// 3. Statement or PreparedStatement 객체 생성: 쿼리문 ? 유무에 따라
			Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sqlCond);
			pstmt.setInt(1, 10000);
			
			// 4. ResultSet(select문 / exexcuteQuery()) or Result(select문이 아닌 경우 / executeUpdate())
			ResultSet rs = stmt.executeQuery(sql);
			ResultSet rsCond = pstmt.executeQuery();
		
			while (rsCond.next()) {
				int bookid = rsCond.getInt("bookid");
				String bookname = rsCond.getString("bookname");
				String publisher = rsCond.getString("publisher");
				int price = rsCond.getInt("price");
				
				System.out.printf("%d \t %s\t %s \t %d \n", bookid, bookname, publisher, price);
			}
			
			rs.close();
			rsCond.close();
			stmt.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
