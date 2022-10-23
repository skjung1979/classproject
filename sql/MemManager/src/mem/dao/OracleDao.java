package mem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mem.domain.Mem;

//project MemManager
public class OracleDao implements Dao {

	@Override
	public List<Mem> select(Connection conn) throws SQLException {
		
		List<Mem> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		
		try {

			String sql = "select * from mem";

			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				list.add(new Mem(rs.getString("MEMBERCD"), rs.getString("NAME"), 
						rs.getString("PHONENUMBER"), rs.getString("ADDRESS"), 
						rs.getString("MALLID"), rs.getString("PASS")));		
				
			}
		} finally {
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
		}
		
		return list;
	}

	@Override
	public List<Mem> selectBy(Connection conn, Mem mem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Connection conn, Mem mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Mem mem) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int membercd) {
		// TODO Auto-generated method stub
		return 0;
	}

}
