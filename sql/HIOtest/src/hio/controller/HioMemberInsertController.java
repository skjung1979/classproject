package hio.controller;

import java.util.Scanner;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioMemberInsertService;

public class HioMemberInsertController implements HioMemberInsertInterface {

	HioMember hioMember = new HioMember();
	
	Scanner sc = new Scanner(System.in);
	public void memberInsert() {
		
		System.out.println("------------------------------------------------");
		System.out.println("-------------------- 회원가입 --------------------");
		
		while(true) {
		System.out.print("회원 아이디 입력 >>");
		String memberId = sc.nextLine();
		
		int select = new HioMemberInsertService().selectMemberName(memberId);
			if(select < 0) {
				hioMember.setMemberId(memberId);
				break;
			}
			else {
				System.out.println("이미 존재하는 아이디 입니다. 다시 입력해 주세요.");
			}
		}
		
		
		System.out.print("회원 비밀번호 입력 >>");
		String memberPwd = sc.nextLine();
		System.out.print("회원 이름 입력 >>");
		String memberName = sc.nextLine();
		System.out.print("회원 주소 입력 >>");
		String memberAddress = sc.nextLine();
		System.out.print("회원 전화번호 입력 >>");
		String memberPhone = sc.nextLine();
		
//		hioMember.setMemberId(memberId);
		hioMember.setMemberPwd(memberPwd);
		hioMember.setMemberName(memberName);
		hioMember.setMemberAddress(memberAddress);
		hioMember.setMemberPhone(memberPhone);
		
		int result = new HioMemberInsertService().memberInsert(hioMember);
		
		
		if(result > 0) {
			System.out.println("회원가입이 완료 되었습니다. 회원 ID : " +hioMember.getMemberId() + " 입니다." );
		}
		else {
			System.out.println("회원가입에 실패했습니다. 다시 시도해 주세요." );
		}
	
	}
}
