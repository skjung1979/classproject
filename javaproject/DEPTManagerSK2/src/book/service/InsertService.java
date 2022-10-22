package book.service;

import java.sql.Connection;
import java.sql.SQLException;
import book.dao.Dao;
import book.domain.Book;
import book.util.ConnectionProvider;

public class InsertService {
	
	Dao dao;
	
	public InsertService(Dao dao) {
		this.dao = dao;
	}

	public int insert(Book book) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			result = dao.insert(conn, book);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
}
