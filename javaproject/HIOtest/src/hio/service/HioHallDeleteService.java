package hio.service;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hio.HioMain;
import hio.DAO.HioHallDeleteDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioHallDeleteService {

	HioHallDeleteDAO dao = new HioHallDeleteDAO();
	
	
	public List<HioMember> getReservationList() {
		List<HioMember> list = new ArrayList<>();
		
		Connection conn = null;
		
		try {
			conn = HioConnection.getConnection();
			
			list=dao.selectReservno(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public HioMember hallSelectToDelete(int reservNo) {
		
		Connection conn = null;
		HioMember hioMember = null;

		//
		try {
			conn = HioConnection.getConnection();
			hioMember = dao.selectByReservno(conn, reservNo);

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
		return hioMember;
	}

	public int hallDelete(int reservNo) {

		int result =0;
		Connection conn;

		try {
			conn = HioConnection.getConnection();
			 result = dao.hallDelete(conn, reservNo);

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
