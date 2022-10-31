package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hio.DAO.HioResvUpdateDAO;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioResvUpdateService {
	
	HioResvUpdateDAO dao = new HioResvUpdateDAO();

	public List<HioMember> reservList() {

		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.reservList(conn);
			
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
		
		return list;
	}

	public List<HioMember> hallList(int hallNo) {
		
		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.hallList(conn, hallNo);
			
			
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
		
		
		
		return list;
	}

	public List<HioMember> curResvList(int hallNo, int reTime) {

		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.curResvList(conn, hallNo, reTime);	
			
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

		
		return list;
	}

	public int updateResevtime(int upReservNo, int upReservTime) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.updateReserv(conn, upReservNo, upReservTime);
			
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

























