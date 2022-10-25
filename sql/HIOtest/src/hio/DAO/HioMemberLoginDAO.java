package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import hio.domain.HioMember;

public class HioMemberLoginDAO implements MemberLoginDAO{
	public int memberLogin(Connection conn, HioMember hioMember) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		// 입력 처리
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID=? AND MEMBERPWD=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hioMember.getMemberId());
			pstmt.setString(2, hioMember.getMemberPwd());
			
			result = pstmt.executeUpdate();
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
}
