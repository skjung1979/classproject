package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioUpdateDAO implements UpdateDAO {

	public int memberUpdate(Connection conn, HioMember hioMember) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "UPDATE RESERVATION SET RESERVTIME=? WHERE RESERVNO=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMember.getReservTime());
			pstmt.setInt(2, hioMember.getReservNo());

			result = pstmt.executeUpdate();

		} finally {
			
			if (pstmt != null) pstmt.close();
		}

		return result;
	}

}
