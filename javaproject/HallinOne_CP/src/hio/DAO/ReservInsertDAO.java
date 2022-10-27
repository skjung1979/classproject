package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface ReservInsertDAO {

	public int reservInsert(Connection conn, HioMember hioMember) throws SQLException;
	public List<HioMember> selectHallList(Connection conn) throws SQLException;
	public HioMember selectHallTime(Connection conn, HioMember hioMember, int hallno) throws SQLException;
	public List<HioMember> selectResvNo(Connection conn, HioMember hioMember) throws SQLException;
	
}
