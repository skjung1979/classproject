package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioMemberDeleteDAO {

	public List<HioMember> memberList(Connection conn) throws SQLException {

		List<HioMember> allList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				HioMember hioMem = new HioMember();

				hioMem.setMemberNo(rs.getInt("memberno"));
				hioMem.setMemberName(rs.getString("membername"));
				hioMem.setMemberAddress(rs.getString("memberaddres"));
				hioMem.setMemberPhone(rs.getString("memberphone"));
				hioMem.setMemberId(rs.getString("memberid"));

				allList.add(hioMem);
			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return allList;
	}

	public int memberDelete(Connection conn, String delMem) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "delete from member where memberid=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delMem);
			
			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}



}













