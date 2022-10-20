package dept;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Controller controller = new Controller();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
		
			menu();
			System.out.println("---메뉴 번호를 입력하세요.---");
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
