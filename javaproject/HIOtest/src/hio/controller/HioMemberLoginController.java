package hio.controller;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioMemberLoginService;

//HIOtest 프로젝트
public class HioMemberLoginController implements HioMemberLoginInterface{

	// 콘솔에서 입력 받은 값들을 담기위해 hioMember인스턴스 생성해서 세터로 값 입력.
	HioMember hioMember = HioMain.hioMember;
	
	@Override
	public int memberLogin() {

		int result = -1;
		
		System.out.println("----------- 로그인 -----------");
		
		while (true) {
			
			System.out.println("회원 아이디 입력: >> ");
			String memberId = HioMain.sc.nextLine();
			
			System.out.println("회원 비밀번호 입력: >> ");
			String memberPwd = HioMain.sc.nextLine();
			
			// 아이디와 비밀번호를 받는 생성자가 없으므로 세터를 통해 입력한 값을 hioMember에 담는다.
			hioMember.setMemberId(memberId);
			hioMember.setMemberPwd(memberPwd);
			
			result = new HioMemberLoginService().memberLogin(hioMember);
			
			if (result >= 0) {
				return result;
			} else {
				System.out.println("로그인 실패: 다시 입력해주세요.");
			}				
		}		
	}
}
