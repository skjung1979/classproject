package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import hio.domain.HioMember;

public interface UpdateDAO {
	
	public int memberUpdate(Connection conn, HioMember hioMember) throws SQLException;
}
