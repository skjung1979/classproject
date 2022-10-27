package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.HioMemberInsertDAO;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioMemberInsertService {

	HioMemberInsertDAO dao = new HioMemberInsertDAO();
	
	public int memberInsert(HioMember hioMember) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.memberInsert(conn, hioMember);
			
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
	
	public int checkId(String memberId) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.checkId(conn, memberId);
			
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

	public int checkPhone(String memberPhone) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.checkPhone(conn, memberPhone);
			
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











