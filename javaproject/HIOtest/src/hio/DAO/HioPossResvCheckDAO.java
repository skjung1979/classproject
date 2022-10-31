package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioPossResvCheckDAO {

	public List<HioMember> possResvCheck(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from hall where HALLRESVYN='Y' order by hallno";
		
		try {
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				HioMember hioMem = new HioMember();
				hioMem.setHallNo(rs.getInt("hallNo"));
				
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

	public HioMember hallListByHallNo(Connection conn, int hallNo) throws SQLException {
	
		HioMember hallListByHallNo = new HioMember();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from hall where hallno=? and HALLRESVYN='Y'";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, hallNo);
		
		rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			hallListByHallNo.setHallNo(rs.getInt("hallno"));
			hallListByHallNo.setHallsTime(rs.getInt("hallstime"));
			hallListByHallNo.setHalleTime(rs.getInt("halletime"));
			
		}
		
		return hallListByHallNo;
	}

	public List<HioMember> resvList(Connection conn, int hallNo) throws SQLException {
		List<HioMember> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation where hallno=? order by hallno, RESERVTIME";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				hioMem.setReservNo(rs.getInt("RESERVNO"));
				hioMem.setReservNo(rs.getInt("HALLNO"));
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
}








