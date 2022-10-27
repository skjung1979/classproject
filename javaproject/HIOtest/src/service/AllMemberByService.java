package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.AllMemberDao;
import hio.DAO.HioAllMemberDao;
import hio.domain.HioMember;
import util.HioConnection;

public class AllMemberByService {

	AllMemberDao allmemberdao = new HioAllMemberDao();
	
	public HioMember selectBymemberNo(int memberNo) {
		
		HioMember hiomember = null;
		Connection conn = null;
		
		try {
			conn = HioConnection.getConnection();
			hiomember = allmemberdao.selectBymemberNo(conn, memberNo);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return hiomember;
		
	}

}

