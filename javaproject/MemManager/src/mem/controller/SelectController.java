package mem.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import mem.dao.OracleDao;
import mem.domain.Mem;
import mem.service.SelectService;

//project MemManager
public class SelectController implements Controller {
	
	SelectService service = new SelectService(new OracleDao());

	@Override
	public void process() {

		List<Mem> list = service.select();
		
		if (list != null && !list.isEmpty()) {
			
			for (Mem m : list) {
				System.out.println(m);
			}
			
		} else {
			System.out.println("검색 자료가 없습니다.");
		}
			
	}
}
