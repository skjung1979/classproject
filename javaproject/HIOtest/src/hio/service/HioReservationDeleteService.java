package hio.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.DAO.HioReservationDeleteDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioReservationDeleteService {
	
	HioReservationDeleteDAO dao = new HioReservationDeleteDAO();

	public List<HioMember> selectReservation(HioMember hioMem) {
		
		List<HioMember> list = new ArrayList<>();
		Connection conn = null;
		
		try {
			conn = HioConnection.getConnection();
			list = dao.selectReservation(conn, hioMem);
			
		} catch (SQLException e) {
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

	public int deleteReservation(HioMember hioMember, int delResv) {
		// TODO Auto-generated method stub
		return 0;
	}

}
