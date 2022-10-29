package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface ReservInsertDAO {

	public int insertReserv(Connection conn, HioMember hioMember) throws SQLException;
	public List<HioMember> possReservListHall(Connection conn) throws SQLException;
	public List<HioMember> possReservListReserv(Connection conn) throws SQLException;
	
}
