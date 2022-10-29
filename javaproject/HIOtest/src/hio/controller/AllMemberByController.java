package hio.controller;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.AllMemberByService;

public class AllMemberByController implements HioAllMemberInterface{
	
	AllMemberByService service = new AllMemberByService();
	
	public void allMemberList() {
		
		System.out.println("검색할 회원 번호를 입력해주세요 >> ");
		int memberNo = Integer.parseInt(HioMain.sc.nextLine());
		
		HioMember hiomember = service.selectBymemberNo(memberNo);
		
		System.out.println("=============== 검색 결과 ===============");
		if(hiomember != null) {
			System.out.println(hiomember);
		} else {
			System.out.println("검색한 회원의 정보가 없습니다.");
		}
		
		
		
	}


}