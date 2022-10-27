package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioMemberInsertDAO implements MemberInsertDAO {

	@Override
	public int memberInsert(Connection conn, HioMember hioMember) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(memberno_seq.nextval, ?, ?, ?, ?, ?, 1)";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hioMember.getMemberName());
		pstmt.setString(2, hioMember.getMemberAddress());
		pstmt.setString(3, hioMember.getMemberPhone());
		pstmt.setString(4, hioMember.getMemberId());
		pstmt.setString(5, hioMember.getMemberPwd());

		result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	@Override
	public int checkId(Connection conn, String memberId) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member where memberid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);

			result = pstmt.executeUpdate();

			if (result > 0 ) {
				result = 1;
			}
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}

	public int checkPhone(Connection conn, String memberPhone) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "select * from member where memberPhone like ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + memberPhone + "%");

			result = pstmt.executeUpdate();

			if (result > 0) {
				result = 1;
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
}












