package dept.service;

import java.sql.Connection;
import java.sql.SQLException;

import dept.dao.Dao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

//project DEPTManagerSK
public class InsertService {
	
	Dao dao;
	
	public InsertService(Dao dao) {
		this.dao = dao;
	}
	
	public int insert(Dept dept) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			result = dao.insert(conn, dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
