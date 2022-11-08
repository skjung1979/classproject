package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.DAO.AllMemberDao;
import hio.DAO.HioAllMemberDao;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioAllMemberService {

	HioAllMemberDao dao = new HioAllMemberDao();

	public List<HioMember> allMemberList() {

		List<HioMember> allMemberList = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			allMemberList = dao.memberList(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return allMemberList;
	}



}
