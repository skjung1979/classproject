package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hio.DAO.HioHallAdminDao;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioHallAdminService {

	HioHallAdminDao dao = new HioHallAdminDao();
	
	public List<HioMember> allHallList() {

		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.allHallList(conn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return list;
	}

}
