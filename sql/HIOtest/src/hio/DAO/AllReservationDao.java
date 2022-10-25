package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface AllReservationDao {

	List<HioMember> selectList(Connection conn) throws SQLException;

	HioMember selectByreservNo(Connection conn, int reservNo) throws SQLException;
}
