package hio.controller;

import java.util.List;
import hio.domain.HioMember;
import service.HioAllMemberService;

public class HioAllMemberController implements HioAllMemberInterface{
	
	HioAllMemberService service = new HioAllMemberService();
	
	public void allmember() {
						
		List<HioMember> list = service.memberList();
		
		if(list != null && !list.isEmpty()) { 
			System.out.println("------------------------ 회원 리스트 -----------------------");
			System.out.println("|\t회원번호 \t이름 \t전화번호 \t주소 \t아이디 \t패스워드\t|");
			for(HioMember d : list) {
				System.out.println("|\t"+d.getMemberNo()+ 
						"\t"+ d.getMemberName()+ 
						"\t"+  d.getMemberPhone()+
						"\t"+d.getMemberAddress()+
						"\t"+ d.getMemberId()+
						"\t"+d.getMemberPwd()+
						"\t|");
				
			}
			System.out.println("---------------------------------------------------------");
		} else {
			System.out.println("검색 결과 없음!");
		}
		
}
}


	

	


