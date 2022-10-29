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
public class HioHallAdminDao {



	public List<HioMember> allHallList(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from hall";

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// 여기에서 생성해야 리스트에 같은 값이 들어가지 않는다.
				HioMember hioMember = new HioMember();

				hioMember.setHallNo(rs.getInt("hallNo"));
				hioMember.setHallResvYN(rs.getString("hallresvyn"));
				hioMember.setHalleTime(rs.getInt("halletime"));
				hioMember.setHallsTime(rs.getInt("hallstime"));

				list.add(hioMember);

			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}

	public int insertHall(Connection conn, HioMember hioMem) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "insert into hall values(?,?,?,?)";

		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMem.getHallNo());
			pstmt.setString(2, hioMem.getHallResvYN());
			pstmt.setInt(3, hioMem.getHallsTime());
			pstmt.setInt(4,  hioMem.getHalleTime());

			result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) pstmt.close();
		}	

		return result;
	}

	public int updateRervYN(Connection conn, HioMember hioMem) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update hall set hallresvYn=? where hallno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hioMem.getHallResvYN());
			pstmt.setInt(2, hioMem.getHallNo());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	public int updateHallsTime(Connection conn, HioMember hioMem) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update hall set HALLSTIME=? where hallno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMem.getHallsTime());
			pstmt.setInt(2, hioMem.getHallNo());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}

	public int updateHalleTime(Connection conn, HioMember hioMem) throws SQLException {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = "update hall set HALLETIME=? where hallno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMem.getHalleTime());
			pstmt.setInt(2, hioMem.getHallNo());

			result = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}

	public List<HioMember> reservNoList(Connection conn, HioMember hioMem) throws SQLException {

		List<HioMember> reservNoList = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		String sql = "select a.* from reservation a, hall b where a.hallno=b.hallno and a.hallno=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hioMem.getHallNo());

			rs = pstmt.executeQuery();
					
			while (rs.next()) {

				HioMember hioMem2 = new HioMember();
				
				hioMem2.setReservNo(rs.getInt("reservno"));

				reservNoList.add(hioMem2);

			}			
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return reservNoList;
	}

	public int delHallNo(Connection conn, HioMember hioMem) throws SQLException {

		int result =  0;
		PreparedStatement pstmt = null;

		String sql = "delete from hall where hallno=?";

		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  hioMem.getHallNo());

			result = pstmt.executeUpdate();
			
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}

		return result;
	}
}




















