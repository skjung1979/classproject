package hio.controller;

import java.util.ArrayList;
import java.util.List;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioMemberDeleteService;

//HIOtest 프로젝트
public class HioMemberDeleteController implements HioMemberDeleteInterface {

	HioMemberDeleteService service = new HioMemberDeleteService();
	
	@Override
	public int memberDelete() {
		
		int result = 0;
		
		List<HioMember> allList = new ArrayList<>();
		
		System.out.println("============== 현재 회원 리스트 ============");
		System.out.println("회원번호\t|\t회원명\t|\t전화번호\t|\t회원ID");
		System.out.println("-------------------------------------------");
		
		allList = service.memberList();
		
		if (allList != null && !allList.isEmpty()) {
			
			for(HioMember h : allList) {
				//System.out.println(h);
				
				System.out.println(h.getMemberNo() + "\t|\t" + h.getMemberName() + "\t|\t" + h.getMemberPhone() + "\t|\t" + h.getMemberId());
				
			}
		} else {
			System.out.println("등록된 회원이 없습니다.");
		}
		
		while (true) {
			
			int bk = 0;
			
			System.out.println("리스트에서 삭제할 회원ID를 입력해주세요. >> ");
			String delMem = HioMain.sc.nextLine().trim();

			for (int i=0; i<allList.size(); i++) {
				
				if (delMem.equals(allList.get(i).getMemberId())) {
					// 삭제 진행
					result = service.memberDelete(delMem);
					
					System.out.println("삭제 완료!");
					bk = 1;
					break;
					
				} else {
					bk = 2;
				}		
			}
			if (bk == 1) {
				break;
			} else if (bk == 2) {
				System.out.println("현재 회원 리스트의 ID 중에 선택해주세요.");
				continue;
			}
		}

		return result;
	}
	
}






