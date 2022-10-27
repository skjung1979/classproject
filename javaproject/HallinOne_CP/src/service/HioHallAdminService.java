package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.DAO.HioHallAdminDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioHallAdminService {
	
	HioHallAdminDAO dao = new HioHallAdminDAO();

	public List<HioMember> hallAdmin(){

		List<HioMember> list = null;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.hallAdmin(conn);
			
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
	
	public int hallInsert(String YN, int sTime, int eTime) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.hallInsert(conn, YN, sTime, eTime);
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
	
	public int hallYNUpdate(int hallNo, String YN) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.hallYNUpdate(conn, hallNo, YN);
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
	
	public int hallTimeUpdate(int hallNo, int sTime, int eTime) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.hallTimeUpdate(conn, hallNo, sTime, eTime);
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
	
	public int hallDelete(int hallNo) {
		
		int result = 0;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			result = dao.hallDelete(conn, hallNo);
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
