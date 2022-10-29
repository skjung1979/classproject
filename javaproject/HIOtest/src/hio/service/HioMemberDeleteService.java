package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.DAO.HioMemberDeleteDAO;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioMemberDeleteService {
	
	HioMemberDeleteDAO dao = new HioMemberDeleteDAO();

	public List<HioMember> memberList() {
		
		List<HioMember> allList = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			allList = dao.memberList(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
		return allList;
	}

	public int memberDelete(String delMem) {

		int result = 0;
		Connection conn = null;
		
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.memberDelete(conn, delMem);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
		return result;
	}
	
}



















