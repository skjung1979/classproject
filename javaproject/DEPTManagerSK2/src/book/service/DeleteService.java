package book.service;

import java.sql.Connection;
import java.sql.SQLException;

import book.dao.Dao;
import book.util.ConnectionProvider;

public class DeleteService {
	
	Dao dao;

	public DeleteService(Dao dao) {
		this.dao = dao;
	}
	
	public int delete(int bookid) {
		int result = 0;
		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();
			result = dao.delete(conn, bookid);

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
