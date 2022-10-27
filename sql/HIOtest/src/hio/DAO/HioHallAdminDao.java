package hio.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import hio.HioMain;
import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioHallAdminDao {



	public List<HioMember> allHallList(Connection conn) throws SQLException {

		List<HioMember> list = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from hall";

		try {

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				// 여기에서 생성해야 리스트에 같은 값이 들어가지 않는다.
				HioMember hioMember = new HioMember();

				hioMember.setHallNo(rs.getInt("hallNo"));
				hioMember.setHallResvYN(rs.getString("hallresvyn"));
				hioMember.setHalleTime(rs.getInt("halletime"));
				hioMember.setHallsTime(rs.getInt("hallstime"));

				list.add(hioMember);

			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}

		return list;
	}
}
