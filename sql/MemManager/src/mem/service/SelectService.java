package mem.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mem.dao.Dao;
import mem.domain.Mem;
import mem.util.ConnectionProvider;

//project MemManager
public class SelectService {
	
	Dao dao;
	
	public SelectService(Dao dao) {
		this.dao = dao;
	}
	
	public List<Mem> select(){
		
		List<Mem> list = null;
		Connection conn = null;
		
		try {
			
			conn = ConnectionProvider.getConnection();
			list = dao.select(conn);
			
		} catch (SQLException e) {
			//e.printStackTrace();
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
