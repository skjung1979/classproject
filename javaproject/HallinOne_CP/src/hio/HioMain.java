package hio;

import java.util.Scanner;
import hio.controller.HioMemberLoginController;
import hio.controller.HioReservInsertController;
import hio.controller.HioUpdateController;
import hio.domain.HioMember;
import hio.controller.HioAllMemberController;
import hio.controller.HioAllReservationController;
import hio.controller.HioHallAdminController;
import hio.controller.HioHallDeleteController;
import hio.controller.HioHallReservChkController;
import hio.controller.HioMemberDeleteController;
import hio.controller.HioMemberInsertController;

public class HioMain {

	public static Scanner sc = new Scanner(System.in);
	public static HioMember hioMember = new HioMember();
	
	public static void main(String[] args) {

		while (true) {

			hioMenu();
			
			System.out.print("메뉴 선택 >>  ");
			int selectMainNo = Integer.parseInt(sc.nextLine());
			int result = 9;
			switch (selectMainNo) {
			// 로그인
			case 1:
				result = new HioMemberLoginController().memberLogin();
				
				// 회원
				if (result == 1) {
					while(true) {
						if(result == -1) {
							break;
						}
					hioMemberMenu();
					int selectMemberNo = Integer.parseInt(sc.nextLine());
					switch (selectMemberNo) {
					case 1:	// 예약가능 여부 확인
						new HioHallReservChkController().reservChkSelect();
						break;
					case 2:	// 예약
						new HioReservInsertController().reservInsert();
						break;
					case 3:	// 예약 변경
						new HioUpdateController().memberUpdate();
						break;
					case 4:
						// 예약 취소
						new HioHallDeleteController().hallDelete();
						break;
					case 5:
						// 로그아웃
						result = -1;
						hioMember = new HioMember();
						break;
						}
					}
				}
				// 관리자
				else if(result == 0) {
					while (true) {
						if(result == -1) {
							break;
						}
						hioAdminMenu();
						int selectAdminNo = Integer.parseInt(sc.nextLine());
						switch (selectAdminNo) {
						case 1: // 회원 전체 정보 출력
							new HioAllMemberController().allmember();
							break;
						case 2: // 타석 관리
							new HioHallAdminController().hallAdmin();
							break;
						case 3:	// 회원 삭제
							int s = new HioMemberDeleteController().memberDelete();
							if (s==0) continue;
							break;
						case 4:	// 로그아웃
							result = -1;
							hioMember = new HioMember();
							break;
						}
					}
				}
				break;
				
				// 회원가입
			case 2:	
				new HioMemberInsertController().memberInsert();
				break;
				
				// 종료
			case 3:
				System.out.println("홀인원 (스크린 골프 예약 서비스)를 종료 합니다.");
				System.out.println("------------------------------------------------");
				System.exit(0);
				break;

			}

		}

	}

	public static void hioMenu() {

		System.out.println("----------- 홀인원 (스크린 골프 예약 서비스) -----------");
		System.out.println(" 1. 로그인");
		System.out.println(" 2. 회원 가입");
		System.out.println(" 3. 종료");
		System.out.println("------------------------------------------------");

	}

	public static void hioAdminMenu() {

		System.out.println("----------- 홀인원 (스크린 골프 예약 시스템) -----------");
		System.out.println(" 1. 회원 전체 보기");
		System.out.println(" 2. 타석 관리");
		System.out.println(" 3. 회원 삭제");
		System.out.println(" 4. 로그아웃");
		System.out.println("------------------------------------------------");

	}

	public static void hioMemberMenu() {

		System.out.println("----------- 홀인원 (스크린 골프 예약 시스템) -----------");
		System.out.println(" 1. 예약 가능 여부 확인");
		System.out.println(" 2. 타석 예약");
		System.out.println(" 3. 타석 예약 변경");
		System.out.println(" 4. 타석 예약 취소");
		System.out.println(" 5. 로그아웃");
		System.out.println("------------------------------------------------");

	}
}
