package hio;

import java.util.Scanner;

import hio.controller.HioAllMemberController;
import hio.controller.HioHallAdminController;
import hio.controller.HioMemberInsertController;
import hio.controller.HioMemberLoginController;
import hio.domain.HioMember;

// HIOtest 프로젝트
public class HioMain {
	
	public static Scanner sc = new Scanner(System.in);
	public static HioMember hioMember = new HioMember();
	
	public static void main(String[] args) {
		
		while (true) {
			
			int result = 9; // 메뉴 이동에 사용하기 위해 return 받은 result
			
			System.out.println("메인 메뉴 화면입니다.");
			
			hioMainMenu();
					
			int selectMainNo = Integer.parseInt(sc.nextLine());
			
			switch (selectMainNo) {
			case 1: // 1. 로그인
				// result 반환값이 1이면 일반 회원이다. memberGrade값을 반환 받음
				result = new HioMemberLoginController().memberLogin();
				System.out.println("반갑습니다. " + hioMember.getMemberName() + "회원님!^^");
				
				if (result == 1) { // 일반회원 -> 일반회원 메뉴 표시
					
					while (true) {
						
						// 5. 로그아웃을 위한 장치
						if (result == -1) {
							break;
						}
						
						hioMemberMenu();
						
						int selectMemberNo = Integer.parseInt(sc.nextLine());
						
						switch (selectMemberNo) {
						case 1: // 예약 가능 여부 확인
							break;
						case 2: // 예약
							break;
						case 3: // 예약 변경
							break;
						case 4: // 예약 취소
							break;
						case 5: // 로그아웃
							result = -1;
							break;
						}
						
					}
					
				} else if (result == 0) { // 관리자 -> 관리자 메뉴 표시
					
					while (true) {

						if (result == -1) {
							break;
						}
						
						hioAdminMenu();

						int selectAdminNo = Integer.parseInt(sc.nextLine());

						switch (selectAdminNo) {
						case 1: // 회원 전체 리스트
							new HioAllMemberController().allMemberList();
							break;
						case 2: // 타석 관리
							new HioHallAdminController().hallAdmin();
							break;
						case 3: // 회원 삭제
							break;
						case 4: // 로그아웃
							result = -1;
							break;
						}

					}
				
				}
				
				break;
			case 2: // 2. 회원 가입
				new HioMemberInsertController().memberInsert();
				break;
			case 3: // 3. 종료
				System.out.println("프로그램을 종료합니다. Bye~");
				System.exit(0);
				break;
			}
	
		}
		
	}
	
	public static void hioMainMenu() {
		
		System.out.println("----------- 홀인원 (스크린 골프 예약 서비스) -----------");
		System.out.println(" 1. 로그인");
		System.out.println(" 2. 회원 가입");
		System.out.println(" 3. 종료");
		System.out.println("------------------------------------------------");
		System.out.println("원하시는 번호를 입력하세요. >> ");
		
	}
	
	public static void hioAdminMenu() {
		
		System.out.println("----------- 홀인원 (스크린 골프 예약 시스템) -----------");
		System.out.println(" 1. 회원 전체 보기");
		System.out.println(" 2. 타석 관리");
		System.out.println(" 3. 회원 삭제");
		System.out.println(" 4. 로그아웃");
		System.out.println("------------------------------------------------");
		System.out.println("원하시는 번호를 입력하세요. >> ");
		
	}
	
	public static void hioMemberMenu() {
		
		System.out.println("----------- 홀인원 (스크린 골프 예약 시스템) -----------");
		System.out.println(" 1. 예약 가능 여부 확인");
		System.out.println(" 2. 타석 예약");
		System.out.println(" 3. 타석 예약 변경");
		System.out.println(" 4. 타석 예약 취소");
		System.out.println(" 5. 로그아웃");
		System.out.println("------------------------------------------------");
		System.out.println("원하시는 번호를 입력하세요. >> ");
		
	}
}
