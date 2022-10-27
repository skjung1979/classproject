package hio.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hio.domain.HioMember;

//HIOtest 프로젝트
public class HioAllMemberDao implements AllMemberDao{
	
	@Override
	public List<HioMember> allMemberList(Connection conn) throws SQLException {
		
		List<HioMember> allMemberList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
				
		String sql = "select * from member";
		
		try {
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				allMemberList.add(new HioMember(rs.getInt("memberNo"), rs.getString("memberName"), rs.getString("memberAddres"),
						rs.getString("memberPhone"), rs.getString("memberId"), rs.getString("memberPwd"), rs.getInt("memberGrade")));
			} 
						
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}

		return allMemberList;
	}
}