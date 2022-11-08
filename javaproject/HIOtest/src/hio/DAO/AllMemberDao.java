package hio.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import hio.domain.HioMember;

public interface AllMemberDao {

	List<HioMember> memberList(Connection conn) throws SQLException;

	HioMember selectBymemberNo(Connection conn, int memberNo) throws SQLException;

}
