package book.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import book.dao.Dao;
import book.domain.Book;
import book.util.ConnectionProvider;

//project DEPTManagerSK2
public class SelectByService {
	
	Dao dao;
	
	public SelectByService(Dao dao) {
		this.dao = dao;
	}
	

	public List<Book> selectByBookname(Book book, int endPrice) {
		
		List<Book> searchlist = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			searchlist = dao.selectByBookname(conn, book, endPrice);
			
		} catch (SQLException e) {
			//
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return searchlist;
	}
}














