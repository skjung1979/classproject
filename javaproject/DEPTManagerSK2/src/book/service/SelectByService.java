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
	

	public List<Book> selectByBookname(String searchBookname) {
		
		List<Book> searchlist = null;
		Connection conn = null;
		String bookname = searchBookname;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			
			searchlist = dao.selectByBookname(conn, bookname);
			
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		return searchlist;
	}
	
}














