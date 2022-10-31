package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import hio.HioMain;
import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioResvUpdateDAO {

	public List<HioMember> reservList(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation where memberno=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, HioMain.hioMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				hioMem.setReservNo(rs.getInt("RESERVNO"));
				hioMem.setReservTime(rs.getInt("RESERVTIME"));
				hioMem.setHallNo(rs.getInt("HALLNO"));
				
				list.add(hioMem);

			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		return list;
	}

	public List<HioMember> hallList(Connection conn, int hallNo) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select hallno, hallstime, halletime from hall where hallno=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallNo);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				hioMem.setHallNo(rs.getInt("hallno"));
				hioMem.setHallsTime(rs.getInt("hallstime"));
				hioMem.setHalleTime(rs.getInt("halletime"));
				
				list.add(hioMem);
				
			}
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}	
		
		return list;
	}

	public List<HioMember> curResvList(Connection conn, int hallNo, int reTime) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select RESERVTIME from reservation where hallno=? and RESERVTIME<>? order by RESERVTIME";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallNo);
			pstmt.setInt(2, reTime);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				hioMem.setReservTime(rs.getInt("RESERVTIME"));
				
				list.add(hioMem);	
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		return list;
	}

	public int updateReserv(Connection conn, int upReservNo, int upReservTime) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "update reservation set RESERVTIME=? where RESERVNO=?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, upReservTime);
		pstmt.setInt(2, upReservNo);
		
		result = pstmt.executeUpdate();
		
		return result;
	}

}











