package service;

import java.sql.Connection;
import java.sql.SQLException;

import hio.DAO.HioUpdateDAO;
import hio.DAO.UpdateDAO;
import hio.domain.HioMember;
import util.HioConnection;

public class HioUpdateService {

	HioUpdateDAO hioupdatedao  = new HioUpdateDAO();
	
	public int memberUpdate(HioMember hiomember) {
		
		int result = 0;
		Connection hioconn = null;
		
		try {
			hioconn = HioConnection.getConnection();
			
			result = hioupdatedao.memberUpdate(hioconn, hiomember);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
