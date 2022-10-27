package hio.controller;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioMemberInsertService;

//HIOtest 프로젝트
public class HioMemberInsertController implements HioMemberInsertInterface {

	HioMember hioMember = HioMain.hioMember;
	
	@Override
	public void memberInsert() {

		System.out.println("--------------- 회원 가입 ----------------");
		
		while (true) {

			System.out.println("회원 아이디 입력: >> ");
			String memberId = HioMain.sc.nextLine();
			
			int checkId = new HioMemberInsertService().checkId(memberId);
			
			if (checkId != 1) {
				hioMember.setMemberId(memberId);
				break;
			} else {
				System.out.println("중복ID가 존재합니다. 다른 ID를 입력해주세요.");
			}
		}
		
		System.out.println("회원 비밀번호 입력: >> ");
		String memberPwd = HioMain.sc.nextLine();
		
		System.out.println("회원 이름 입력: >> ");
		String memberName = HioMain.sc.nextLine();
		
		System.out.println("회원 주소 입력: >> ");
		String memberAddress = HioMain.sc.nextLine();
		
		System.out.println("회원 전화번호 입력: >> ");
		String memberPhone = HioMain.sc.nextLine();
		
		
		hioMember.setMemberPwd(memberPwd);
		hioMember.setMemberName(memberName);
		hioMember.setMemberAddress(memberAddress);
		hioMember.setMemberPhone(memberPhone);
		
		int result = new HioMemberInsertService().memberInsert(hioMember);
		
		if (result > 0 ) {
			
			System.out.println("회원 가입이 완료 되었습니다. " + hioMember.getMemberName() + "님, 환영합니다!");
			
		} else {
			
			System.out.println("회원 가입에 실패했습니다.");
		
		}	
	}
}
