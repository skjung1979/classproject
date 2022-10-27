package mem;

import java.util.Scanner;

//project MemManager
public class MemMain {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Command comm = new Command();
		
		while (true) {
			
			menu();
			System.out.println("============================");
			System.out.println("원하시는 메뉴 번호를 입력하세요. >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			comm.comm.get(select).process();
			
		}
		
	}
	
	public static void menu() {
		
		System.out.println("===== 회원 관리 프로그램 =====");
		System.out.println("1. 전체 회원 조회");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 신규 등록");
		System.out.println("4. 회원 정보 변경");
		System.out.println("5. 회원 정보 삭제");
		System.out.println("6. 프로그램 종료");
		
	}
	
	
	

}
