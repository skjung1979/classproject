package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class InsertService {

	Dao dao = new OracleDao();
	
	public int insert(Dept dept) {
		
		int result = 0;
		Connection conn = null; // 예외 처리 때문에 여기에 빼서 선언한다.
		
		try {
			conn = ConnectionProvider.getConnection();
			
			result = dao.insert(conn, dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
