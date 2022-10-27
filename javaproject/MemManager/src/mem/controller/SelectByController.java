package mem.controller;

import java.util.List;
import mem.MemMain;
import mem.dao.OracleDao;
import mem.domain.Mem;
import mem.service.SelectByService;

//project MemManager
public class SelectByController implements Controller {

	SelectByService service = new SelectByService(new OracleDao());
	
	@Override
	public void process() {

		System.out.println("검색할 회원 이름을 입력해주세요. >> ");
		String searchName = MemMain.sc.nextLine();
		
		List<Mem> searchlist = service.selectBy(searchName);
		
		if (searchlist != null && !searchlist.isEmpty()) {
			
			for (Mem m : searchlist) {
				System.out.println(m);
			}
			
		} else {
			System.out.println("검색하신 이름의 회원은 존재하지 않습니다.");
		}
		
	}
}
