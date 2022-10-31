package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.DAO.HioPossResvCheckDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioPossResvCheckService {
	
	HioPossResvCheckDAO dao = new HioPossResvCheckDAO();

	public List<HioMember> possResvCheck() {
		
		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.possResvCheck(conn);
			
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

	public HioMember hallListByHallNo(int hallNo) {
		
		HioMember list = new HioMember();
		Connection conn =null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.hallListByHallNo(conn, hallNo);
			
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

	public List<HioMember> resvList(int hallNo) {
		
		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			
			conn = HioConnection.getConnection();
			list = dao.resvList(conn, hallNo);
			
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

}
