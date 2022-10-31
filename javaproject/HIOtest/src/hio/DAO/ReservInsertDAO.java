package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface ReservInsertDAO {

	public int insertReserv(Connection conn, HioMember hioMember) throws SQLException;

}
