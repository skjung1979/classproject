package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.DAO.HioMemberDeleteDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioMemberDeleteService {
	
	HioMemberDeleteDAO dao = new HioMemberDeleteDAO();
	
	public int memberDelete(String delName) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.memberDelete(conn, delName);
			
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
	
	public List<HioMember> memberSelectToDelete(){
		
		List<HioMember> allList = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			allList = dao.selectToDelete(conn);
			
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
		
		return allList;
	}
	
public List<HioMember> memberSelectToDeleteRes(){
		
		List<HioMember> resultList = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			resultList = dao.selectToDeleteRes(conn);
			
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
		
		return resultList;
	}
	
}



















