package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.HioMemberInsertDAO;
import hio.domain.HioMember;
import util.HioConnection;


public class HioMemberInsertService {
	HioMemberInsertDAO dao = new HioMemberInsertDAO();
	
	public int memberInsert(HioMember hioMember) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.memberInsert(conn, hioMember);
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
	
	public int selectMemberName(String memberId) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.selectMemberName(conn, memberId);
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
