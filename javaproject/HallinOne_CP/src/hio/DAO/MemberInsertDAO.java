package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import hio.domain.HioMember;

public interface MemberInsertDAO {

	public int memberInsert(Connection conn, HioMember hioMember) throws SQLException;
	public int selectMemberName(Connection conn, String memberId) throws SQLException;
	
}
