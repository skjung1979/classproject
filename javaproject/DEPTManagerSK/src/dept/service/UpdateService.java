package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import dept.dao.Dao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

// project DEPTManagerSK
public class UpdateService {
	
	Dao dao;
	
	public UpdateService(Dao dao) {
		this.dao = dao;
	}
	
	public int update(Dept dept) {
		
		int result = 0;
		Connection conn;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			result = dao.update(conn, dept);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
