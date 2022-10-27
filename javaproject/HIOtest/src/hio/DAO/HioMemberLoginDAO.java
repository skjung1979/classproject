package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioMemberLoginDAO implements MemberLoginDAO{

	public int memberLogin(Connection conn, HioMember hioMember) throws SQLException {
		
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where memberid=? and memberpwd=?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hioMember.getMemberId());
		pstmt.setString(2,  hioMember.getMemberPwd());
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			
			result = rs.getInt("memberGrade");
			hioMember.setMemberNo(rs.getInt("memberNo"));
			hioMember.setMemberGrade(rs.getInt("memberGrade"));
			hioMember.setMemberName(rs.getString("memberName"));
			
		}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}	
		
		return result;
	}
}
