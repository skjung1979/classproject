package mem.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import mem.dao.Dao;
import mem.domain.Mem;

//project MemManager
public class SelectByService {
	
	Dao dao;
	
	public SelectByService(Dao dao) {
		this.dao = dao;
	}
	
	public List<Mem> selectBy(String searchName){
		
		List<Mem> searchlist = new ArrayList<>();
		Connection conn = null;
	
		
		
		
		return searchlist;
	}
	

}
