package hio.service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.AllReservationDao;
import hio.DAO.HioAllReservationDao;
import hio.domain.HioMember;
import util.HioConnection;

public class AllReservationByService {

	AllReservationDao allreservationdao = new HioAllReservationDao();

	public HioMember selectByreservNo(int reservNo) {

		HioMember hiomember = null;
		Connection conn = null;

		try {
			conn = HioConnection.getConnection();
			hiomember = allreservationdao.selectByreservNo(conn, reservNo);

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

		return hiomember;

	}

}
