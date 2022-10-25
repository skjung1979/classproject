package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

public class HioMemberDeleteDAO {
	
	public int memberDelete(Connection conn, String delName) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "delete from member where membername=?";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, delName);

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) pstmt.close();
		}

		return result;
	}
	
	public List<HioMember> selectToDelete(Connection conn) throws SQLException{

		List<HioMember> allList = new ArrayList<>();
		ResultSet rs = null;
		Statement stmt = null;

		try {
			String sql = "select * from member";

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				allList.add(new HioMember(rs.getInt("memberno"), rs.getString("membername"), 
						rs.getString("memberaddres"), rs.getString("memberphone"), 
						rs.getString("memberid"), rs.getString("memberpwd"), 
						rs.getInt("membergrade")));
			}	
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return allList;
	}
	
	public List<HioMember> selectToDeleteRes(Connection conn) throws SQLException{

		List<HioMember> resultList = new ArrayList<>();
		ResultSet rs2 = null;
		Statement stmt2 = null;

		try {
			String sql = "select * from member";

			stmt2 = conn.createStatement();
			rs2 = stmt2.executeQuery(sql);

			while (rs2.next()) {

				resultList.add(new HioMember(rs2.getInt("memberno"), rs2.getString("membername"), 
						rs2.getString("memberaddres"), rs2.getString("memberphone"), 
						rs2.getString("memberid"), rs2.getString("memberpwd"), 
						rs2.getInt("membergrade")));
			}	
		} finally {
			if (rs2 != null) {
				rs2.close();
			}
			if (stmt2 != null) {
				stmt2.close();
			}
		}

		return resultList;
	}
}













