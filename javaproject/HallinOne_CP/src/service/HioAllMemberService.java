package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.DAO.HioAllMemberDao;
import hio.domain.HioMember;
import util.HioConnection;

public class HioAllMemberService {

	HioAllMemberDao dao = new HioAllMemberDao();

	public List<HioMember> memberList() {

		List<HioMember> list = null;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			list = dao.memberList(conn);

		} catch (SQLException e) {
			// e.printStackTrace();
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
