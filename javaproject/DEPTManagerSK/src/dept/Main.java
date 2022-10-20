package dept;

import java.util.Scanner;

import dept.controller.SelectByController;
import dept.controller.SelectController;

public class Main {
		
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		
		while (true) {
			menu();
			System.out.println("--- 메뉴 번호를 입력하세요. >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			switch (select) {
			case 1:
				new SelectController().process();
				break;
			case 2:
				new SelectByController().process();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				
			}
			
			
			
			
			
			
			
			
			
			
		}

	}
	
	public static void menu() {
		System.out.println("부서 관리 프로그램");
		System.out.println("1. 전체 부서 리스트");
		System.out.println("2. 부서 검색");
		System.out.println("3. 부서 정보 저장");
		System.out.println("4. 부서 정보 수정");
		System.out.println("5. 부서 정보 삭제");
		System.out.println("6. 종료");
	}

}
