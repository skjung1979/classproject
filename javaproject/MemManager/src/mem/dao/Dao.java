package mem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import mem.domain.Mem;

//project MemManager
public interface Dao {
	
	List<Mem> select(Connection conn) throws SQLException;
	List<Mem> selectBy(Connection conn, Mem mem);
	
	int insert(Connection conn, Mem mem);
	int update(Connection conn, Mem mem);
	int delete(Connection conn, int membercd);
	

}
