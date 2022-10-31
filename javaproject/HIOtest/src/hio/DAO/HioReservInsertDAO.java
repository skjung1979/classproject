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
public class HioReservInsertDAO implements ReservInsertDAO {
	
	@Override
	public int insertReserv(Connection conn, HioMember hioMember) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;
		// 시퀀스명.nextval => 해당시퀀스의 다음 값을 말한다.
		String sql = "insert into reservation values(reservno_seq.nextval,?,?,sysdate,?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			// 예약번호는 시퀀스에 의해 자동 생성된다.
			// pstmt.setInt(1, hioMember.getReservNo());
			pstmt.setInt(1, hioMember.getMemberNo());
			pstmt.setInt(2, hioMember.getHallNo());
			// 예약날짜는 시스템읠 현재 날짜로 입력한다.
			//pstmt.setString(4, hioMember.getReservDate());
			pstmt.setInt(3, hioMember.getReservTime());
			
			result = pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		
		return result;
	}

	public List<HioMember> possReservListMem(Connection conn) throws SQLException {

		List<HioMember> possReservListMem = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			
			HioMember hioMem = new HioMember();
			
			hioMem.setMemberNo(rs.getInt("MEMBERNO"));
			hioMem.setMemberName(rs.getString("MEMBERNAME"));
			hioMem.setMemberAddress(rs.getString("MEMBERADDRES"));
			hioMem.setMemberPhone(rs.getString("MEMBERPHONE"));
			hioMem.setMemberId(rs.getString("MEMBERID"));
			hioMem.setMemberPwd(rs.getString("MEMBERPWD"));
			hioMem.setMemberGrade(rs.getInt("MEMBERGRADE"));
			
			possReservListMem.add(hioMem);
			
		}
	
		return possReservListMem;
	}

	public HioMember selectHallTime(Connection conn, HioMember hioMember, int hallNo) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select hallstime, halletime from hall where hallno=?";
		
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hallNo);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			hioMember.setHallsTime(rs.getInt("hallstime"));
			hioMember.setHalleTime(rs.getInt("halletime"));
		}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		
		return hioMember;
	}

	public List<HioMember> selectResvTimeList(Connection conn, int hallNo) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation where hallno=?";
		
		try {
	
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				hioMem.setHallNo(rs.getInt("hallno"));
				hioMem.setReservTime(rs.getInt("reservtime"));
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

	public List<HioMember> selectResNo(Connection conn, HioMember hioMember) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation where memberno=?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMember.getMemberNo());
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				hioMem.setReservNo(rs.getInt("reservno"));
				
				list.add(hioMem);
				
			}
			
			
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
		
		
		return list;
	}

	public List<HioMember> selectPossHall(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		ResultSet rs = null;
		Statement stmt = null;
		
		String sql = "select * from hall where HALLRESVYN='Y'";
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				hioMem.setHallNo(rs.getInt("hallno"));
				
				list.add(hioMem);

			}
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		return list;
	}
}










