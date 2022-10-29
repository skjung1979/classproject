package hio.DAO;

import java.sql.Connection;
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
		
		return result;
	}

	public List<HioMember> possReservListHall(Connection conn) throws SQLException {

		List<HioMember> possReservListHall = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM HALL WHERE hallresvyn = 'Y' ORDER BY hallno";

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				HioMember hioMem = new HioMember();

				hioMem.setHallNo(rs.getInt("hallno"));
				hioMem.setHallResvYN(rs.getString("HALLRESVYN"));
				hioMem.setHallsTime(rs.getInt("HALLSTIME"));
				hioMem.setHalleTime(rs.getInt("HALLETIME"));

				possReservListHall.add(hioMem); 

			}
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		return possReservListHall;
	}


	public List<HioMember> possReservListReserv(Connection conn) throws SQLException {

		List<HioMember> possReservListReserv = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from reservation";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				HioMember hioMem = new HioMember();
				
				possReservListReserv.add(hioMem);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		
		return possReservListReserv;
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

	


	

	

}
