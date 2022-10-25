package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;


public class HioAllMemberDao implements AllMemberDao{
	
	@Override
	public List<HioMember> memberList(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql = "select * from member";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				list.add(rowToHioMember(rs));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}

	@Override
	public HioMember selectBymemberNo(Connection conn, int memberNo) throws SQLException {

		HioMember hiomember = null;

		String sql = "select * from member where memberNo=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				hiomember = rowToHioMember(rs);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return hiomember;
	}

	private HioMember rowToHioMember(ResultSet rs) throws SQLException {
		return new HioMember
				(rs.getInt("memberNo"), rs.getString("memberName"), rs.getString("memberAddress"),
				rs.getString("memberPhone"),rs.getString("memberId"),rs.getString("memberPwd"),
				rs.getInt("memberGrade"));
	}

	
}