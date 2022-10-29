package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hio.DAO.HioHallAdminDao;
import hio.domain.HioMember;
import util.HioConnection;

//HIOtest 프로젝트
public class HioHallAdminService {

	HioHallAdminDao dao = new HioHallAdminDao();
	
	public List<HioMember> allHallList() {

		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.allHallList(conn);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		return list;
	}

	public int insertHall(HioMember hioMem) {
		
		int result = 0;
		Connection conn = null;

			try {
				
				conn = HioConnection.getConnection();
				result = dao.insertHall(conn, hioMem);
				
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

	public int updateRervYN(HioMember hioMem) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.updateRervYN(conn, hioMem);
			
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

	public int updateHallsTime(HioMember hioMem) {

		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.updateHallsTime(conn, hioMem);
			
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

	public int updateHalleTime(HioMember hioMem) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.updateHalleTime(conn, hioMem);
			
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

	public List<HioMember> reservNoList(HioMember hioMem) {

		List<HioMember> reservNoList = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			reservNoList = dao.reservNoList(conn, hioMem);
			
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
		
		return reservNoList;
	}

	public int delHallNo(HioMember hioMem) {
		
		int result = 0;
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			result = dao.delHallNo(conn, hioMem);
			
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
















