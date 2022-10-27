package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.HioMemberLoginDAO;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioMemberLoginService {
	
	HioMemberLoginDAO dao = new HioMemberLoginDAO();
	
	public int memberLogin(HioMember hioMember) {
		
		int result = -1;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.memberLogin(conn, hioMember);
			
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
