package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioReservationDeleteDAO {

	public List<HioMember> selectReservation(Connection conn, HioMember hioMem) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from reservation where memberno=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMem.getMemberNo());		
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				HioMember hioMem2 = new HioMember();
				hioMem2.setReservNo(rs.getInt("RESERVNO"));
				hioMem2.setMemberNo(rs.getInt("memberno"));
				hioMem2.setHallNo(rs.getInt("hallno"));
				hioMem2.setReservDate(rs.getString("reservdate"));
				hioMem2.setReservTime(rs.getInt("reservtime"));

				list.add(hioMem2);

			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return list;
	}

}
