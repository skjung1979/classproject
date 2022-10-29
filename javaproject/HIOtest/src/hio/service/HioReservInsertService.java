package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.DAO.HioReservInsertDAO;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioReservInsertService {
	
	HioReservInsertDAO dao = new HioReservInsertDAO();

	public List<HioMember> insertReserv(String reservDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<HioMember> possReservListHall() {
		
		List<HioMember> possReservList = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			possReservList = dao.possReservListHall(conn);
			
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
		
		return possReservList;
	}

	public List<HioMember> possReservListReserv() {

		List<HioMember> possReservListReserv = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			possReservListReserv = dao.possReservListReserv(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return possReservListReserv;
	}

	public List<HioMember> possReservListMem() {
		
		List<HioMember> possReservListMem = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			possReservListMem = dao.possReservListMem(conn);
			
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
		

		
		return possReservListMem;
	}
	
}
















