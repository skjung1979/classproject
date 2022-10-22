package book;

import java.util.Scanner;

//project DEPTManagerSK2
public class MainSK2 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Command comm = new Command();
		
		while (true) {
			menu();
			System.out.println("==============================");
			System.out.println("원하시는 메뉴 번호를 입력하세요. >> ");
			int select = Integer.parseInt(sc.nextLine());
			
			comm.comm.get(select).process();
			
		}
	}
	
	public static void menu() {
		
		System.out.println("도서 관리 프로그램");
		System.out.println("1. 전체 도서 리스트");
		System.out.println("2. 도서 검색");
		System.out.println("3. 도서 정보 저장");
		System.out.println("4. 도서 정보 수정");
		System.out.println("5. 도서 정보 삭제");
		System.out.println("6. 종료");
		
	}

}
