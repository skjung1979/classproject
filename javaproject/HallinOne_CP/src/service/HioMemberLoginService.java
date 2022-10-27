package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.HioMemberLoginDAO;
import hio.DAO.HioSelectDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioMemberLoginService {
	
	HioMemberLoginDAO dao = new HioMemberLoginDAO();
		
	public int memberLogin(HioMember hioMember) {
		
		int result = -1;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.memberLogin(conn, hioMember);
//			hioMember = dao.memberLogin(conn, hioMember);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return result;
	}
}
