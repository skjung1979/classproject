package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hio.domain.HioMember;

public class HioMemberInsertDAO implements MemberInsertDAO {

	public int memberInsert(Connection conn, HioMember hioMember) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		// 입력 처리
		String sql = "INSERT INTO MEMBER VALUES(MEMBERNO_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hioMember.getMemberName());
			pstmt.setString(2, hioMember.getMemberAddress());
			pstmt.setString(3, hioMember.getMemberPhone());
			pstmt.setString(4, hioMember.getMemberId());
			pstmt.setString(5, hioMember.getMemberPwd());
			pstmt.setInt(6, 1);
//			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	public int selectMemberName(Connection conn, String memberId) throws SQLException {
		
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// 입력 처리
		String sql = "SELECT memberid FROM MEMBER WHERE memberid=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
//			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
}
