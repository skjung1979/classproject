package book.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import book.dao.Dao;
import book.domain.Book;
import book.util.ConnectionProvider;

//project DEPTManagerSK2
public class SelectService {
	
	Dao dao;
	
	public SelectService(Dao dao) {
		this.dao = dao;
	}
	
	public List<Book> select(){
		
		List<Book> list = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			list = dao.select(conn);
			
		} catch (SQLException e) {
			//e.printStackTrace(); 널로 넘어올수도 있으니 주석
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}

}
