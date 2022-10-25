package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hio.domain.HioMember;

public class HioMemberLoginDAO implements MemberLoginDAO{
	public int memberLogin(Connection conn, HioMember hioMember) throws SQLException {
		
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 입력 처리
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBERPWD=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hioMember.getMemberId());
			pstmt.setString(2, hioMember.getMemberPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("membergrade");
				hioMember.setMemberNo(rs.getInt("memberno"));
				hioMember.setMemberGrade(rs.getInt("membergrade"));
				
			}
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}
}
