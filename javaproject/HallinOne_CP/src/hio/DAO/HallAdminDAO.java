package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface HallAdminDAO {

	public List<HioMember> hallAdmin(Connection conn) throws SQLException;
	public int hallInsert(Connection conn, String YN, int sTime, int eTime) throws SQLException;
	public int hallYNUpdate(Connection conn, int hallNo, String YN) throws SQLException;
	public int hallTimeUpdate(Connection conn, int hallNo, int sTime, int eTime) throws SQLException;
	public int hallDelete(Connection conn, int hallNo) throws SQLException;
	
}
