package ver03.third;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone sp = SmartPhone.getInstance();
		
		while(true) {
			printMenu();
			
			int select = Integer.parseInt(sp.sc.nextLine());
			
			switch(select) {
			case 1:
				sp.inserContact();
				break;
			case 2:
				break;
			case 3:
				sp.editContact();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	// 메뉴 메소드
	static void printMenu() {
		System.out.println("==================");
		System.out.println("===== 전화번호부 ====");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체출력");
		System.out.println("6. 프로그램 종료");
		System.out.println("==================");
		System.out.println("원하시는 메뉴 번호를 입력해주세요. >>>");
	}

}
