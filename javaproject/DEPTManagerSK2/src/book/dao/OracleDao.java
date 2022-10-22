package book.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import book.domain.Book;

//project DEPTManagerSK2
public class OracleDao implements Dao {

	@Override
	public List<Book> select(Connection conn) throws SQLException {
		
		List<Book> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		
		
		try {
			
			String sql = "select * from book";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				list.add(new Book(rs.getInt("bookid"), rs.getString("bookname"), rs.getString("publisher"), rs.getInt("price")));
				
			}
			
		} finally{
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}		
		return list;
	}

	@Override
	public List<Book> selectByBookname(Connection conn, String searchBookname) throws SQLException {
		
		List<Book> searchlist = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		try {
			
			String sql = "select * from book where bookname like '%?%'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchBookname);
	
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				
				searchlist.add(new Book(rs.getInt("bookid"), rs.getString("bookname"), rs.getString("publisher"), rs.getInt("price")));
				
			}
	
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
		}
		
		return searchlist;
	}

	@Override
	public int insert(Connection conn, Book book) {
		int result = 0;
		
		
		
		return result;
	}

	@Override
	public int update(Connection conn, Book book) {
		int result = 0;
		
		
		
		return result;
	}

	@Override
	public int delete(Connection conn, int bookid) {
		int result = 0;
		
		
		
		return result;
	}

}



























