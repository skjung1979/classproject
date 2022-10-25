package hio;

import java.util.Scanner;
import hio.controller.HioMemberLoginController;
import hio.controller.HioReservInsertController;
import hio.domain.HioMember;
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

			switch (selectMainNo) {
			case 1:
			
				int result = new HioMemberLoginController().memberLogin();
				
				if (result == 1) {
					hioMemberMenu();
					int selectMemberNo = Integer.parseInt(sc.nextLine());
					switch (selectMemberNo) {
					case 1:
						break;
					case 2:
						System.out.println("타석 예약");
						int reservResult = new HioReservInsertController().reservInsert();
						if(reservResult<0) {
							System.out.println(reservResult);
						}
						
						break;
					case 3:
						break;
					case 4:
						break;
					case 5:
						break;
					}
				}
				else if(result == 0) {
					hioAdminMenu();
					int selectAdminNo = Integer.parseInt(sc.nextLine());
					switch (selectAdminNo) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						new HioMemberDeleteController().memberDelete();
						int s = new HioMemberDeleteController().memberDelete();
						if (s==0) continue;
						break;
					case 4:
						break;
					}
				}
				break;
			case 2:	// 회원가입
				new HioMemberInsertController().memberInsert();
				break;
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
