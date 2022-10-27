package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioReservInsertDAO implements ReservInsertDAO {

	public int reservInsert(Connection conn, HioMember hioMember) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		// 입력 처리
		String sql = "INSERT INTO RESERVATION VALUES(RESERVNO_SEQ.nextval, ?, ?, SYSDATE, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMember.getMemberNo());
			pstmt.setInt(2, hioMember.getHallNo());
			pstmt.setInt(3, hioMember.getReservTime());
//			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	public List<HioMember> selectHallList(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		
		List<HioMember> list = new ArrayList<>();
		
		String sql = "SELECT * FROM HALL WHERE hallresvyn = 'Y' ORDER BY hallno";
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				HioMember hioMember = new HioMember();
				hioMember.setHallNo(rs.getInt("hallno"));
				list.add(hioMember);
			}
		}finally {
			if(rs != null){
				rs.close();
			}
			if(stmt != null){
				stmt.close();
			}
		}
		
		return list;
	}

	public HioMember selectHallTime(Connection conn, HioMember hioMember, int hallno) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT hallstime, halletime FROM HALL WHERE hallno=?";
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallno);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				hioMember.setHallsTime(rs.getInt("hallstime"));
				hioMember.setHalleTime(rs.getInt("halletime"));
			}
		}finally {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		return hioMember;
	}
	
	public List<HioMember> selectResvTimeList(Connection conn, int hallno) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<HioMember> list = new ArrayList<>();
		
		String sql = "SELECT * FROM RESERVATION WHERE hallno = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallno);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				HioMember hioMember = new HioMember();
				hioMember.setHallNo(rs.getInt("hallno"));
				hioMember.setReservTime(rs.getInt("reservtime"));
				list.add(hioMember);
			}
		}finally {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		return list;
	}
	
	public List<HioMember> selectResvNo(Connection conn, HioMember hioMember) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<HioMember> list = new ArrayList<>();
		
		String sql = "SELECT * FROM RESERVATION WHERE memberno = ? ORDER BY reservno";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMember.getMemberNo());
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				hioMember = new HioMember();
				hioMember.setReservNo(rs.getInt("reservno"));
				
				list.add(hioMember);
			}
		}finally {
			if(rs != null){
				rs.close();
			}
			if(pstmt != null){
				pstmt.close();
			}
		}
		
		return list;
	}

}
