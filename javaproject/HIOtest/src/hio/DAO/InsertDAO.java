package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import hio.domain.HioMember;

public interface InsertDAO {

	public int memberInsert(Connection conn, HioMember hioMember) throws SQLException;
}
