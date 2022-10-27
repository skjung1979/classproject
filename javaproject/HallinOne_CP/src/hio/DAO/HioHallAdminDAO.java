package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioHallAdminDAO implements HallAdminDAO {

	public List<HioMember> hallAdmin(Connection conn) throws SQLException {

		Statement stmt = null;
		ResultSet rs = null;
		
		List<HioMember> list = new ArrayList<>();
		
		String sql = "SELECT * FROM HALL ORDER BY hallno";
		try {
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				HioMember hioMember = new HioMember();
				hioMember.setHallNo(rs.getInt("hallno"));
				hioMember.setHallResvYN(rs.getString("hallresvyn"));
				hioMember.setHallsTime(rs.getInt("hallstime"));
				hioMember.setHalleTime(rs.getInt("halletime"));
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
	
	public int hallInsert(Connection conn, String YN, int sTime, int eTime) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO HALL VALUES((SELECT NVL(MAX(hallno), 0)+1 FROM hall), ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, YN);
			pstmt.setInt(2, eTime);
			pstmt.setInt(3, sTime);
//			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	public int hallYNUpdate(Connection conn, int hallNo, String YN) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE HALL SET hallresvyn=? WHERE hallno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, YN);
			pstmt.setInt(2, hallNo);
			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	public int hallTimeUpdate(Connection conn, int hallNo, int sTime, int eTime) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE HALL SET hallstime=?, halletime=? WHERE hallno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sTime);
			pstmt.setInt(2, eTime);
			pstmt.setInt(3, hallNo);
			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
	
	public int hallDelete(Connection conn, int hallNo) throws SQLException {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM HALL WHERE hallno=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hallNo);
			
			result = pstmt.executeUpdate();
		}finally {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		
		return result;
	}
}
