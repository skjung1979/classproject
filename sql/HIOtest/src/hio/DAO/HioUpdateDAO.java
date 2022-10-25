package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hio.domain.HioMember;

public class HioUpdateDAO implements UpdateDAO {

	public int memberUpdate(Connection conn, HioMember hioMember) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE MEMBER SET RESERVNO=? AND HALLNO=? AND RESERVTIME=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMember.getReservNo());
			pstmt.setInt(2, hioMember.getHallNo());
			pstmt.setString(3, hioMember.getReservTime());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) pstmt.close();
		}

		return result;
	}
}
