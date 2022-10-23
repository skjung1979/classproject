package book.service;

import java.sql.Connection;
import java.sql.SQLException;

import book.dao.Dao;
import book.domain.Book;
import book.util.ConnectionProvider;

public class UpdateService {
	
	Dao dao;
	
	public UpdateService(Dao dao) {
		this.dao = dao;
	}
	
	public int update(Book book) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			result = dao.update(conn, book);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}
}
