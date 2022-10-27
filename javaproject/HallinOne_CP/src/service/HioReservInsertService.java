package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.DAO.HioReservInsertDAO;
import hio.domain.HioMember;
import util.HioConnection;


public class HioReservInsertService {
	HioReservInsertDAO dao = new HioReservInsertDAO();
	
	public int reservInsert(HioMember hioMember) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.reservInsert(conn, hioMember);
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
	
	public List<HioMember> selectHallList(){

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectHallList(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public HioMember selectHallTime(HioMember hioMember, int hallno){

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			hioMember = dao.selectHallTime(conn, hioMember, hallno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return hioMember;
	}
	
	public List<HioMember> selectResvTimeList(int hallno){

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectResvTimeList(conn, hallno);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	public List<HioMember> selectResvNo(HioMember hioMember){

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectResvNo(conn, hioMember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
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
