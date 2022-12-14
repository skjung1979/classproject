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

	public HioMember selectHallTime(HioMember hioMember, int hallNo) {

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			hioMember = dao.selectHallTime(conn, hioMember, hallNo);
			
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
		
		
		return hioMember;
	}

	public List<HioMember> selectResvTimeList(int hallNo) {

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectResvTimeList(conn, hallNo);
			
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

	public int insertReserv(HioMember hioMember) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.insertReserv(conn, hioMember);
			
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

	public List<HioMember> selectResNo(HioMember hioMember) {
		
		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectResNo(conn, hioMember);
			
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





	public List<HioMember> selectPossHall() {

		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.selectPossHall(conn);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
















