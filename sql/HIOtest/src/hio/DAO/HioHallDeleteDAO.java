package hio.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioHallDeleteDAO {

	public List<HioMember> selectReservno(Connection conn) throws SQLException {
		

		List<HioMember> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new HioMember(rs.getInt("reservNo"), rs.getString("reservDate"),	rs.getInt("reservTime"), rs.getInt("hallNo")));
				
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return list;
	}
	
	
	public HioMember selectByReservno(Connection conn, int reservNo) throws SQLException {
		

		HioMember hm = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation where reservNo=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				hm =  new HioMember(rs.getInt("reservNo"), rs.getString("reservDate"),	rs.getInt("reservTime"), rs.getInt("hallNo"));
			}
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return hm;
	}

	public int hallDelete(Connection conn, int reservNo) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from hall where hallno=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reservNo);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) pstmt.close();
		}

		return result;
	}
}
