package dept.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dept.dao.Dao;
import dept.domain.Dept;
import dept.util.ConnectionProvider;

public class SelectService {

	// Service: 핵심 로직을 처리하는 영역
	// controller에서 요청한 내용의 결과를 생성하고 반환
	// 필요한 DB작은은 dao를 통해서 작업
	
	// 의존성을 줄이기 위에 dao 객체는 생성자에 넣어 선언/생성한다.
	
	Dao dao;
	
	public SelectService(Dao dao) {
		this.dao = dao;
	}
	
	public List<Dept> select(){
		
		List<Dept> list = null;
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();		
			list = dao.select(conn);
			
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

		return list;
	}
			
}
