package hio.controller;

import java.util.List;

import hio.HioMain;
import hio.DAO.MySqlDao;
import hio.domain.HioMember;
import service.HioAllMemberService;

public class HioAllMemberController implements HioAllMemberInterface{
	
	HioAllMemberService service = new HioAllMemberService(new MySqlDao());
	
	public void allmember() {
						
		List<HioMember> list = service.memberList();
		
		if(list != null && !list.isEmpty()) { 
			
			for(HioMember d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("검색 결과 없음!");
		}
		
}
}


	

	


