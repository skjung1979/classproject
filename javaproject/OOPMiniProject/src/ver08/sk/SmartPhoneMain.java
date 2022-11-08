package ver08.sk;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		SmartPhone sp = SmartPhone.getInstance();

		while (true) {

			printMenu();
			
			int select = 0;
			
			try {
				select = Integer.parseInt(sp.sc.nextLine());
				if(select < 0 || select > 8) {
					Exception e = new Exception();
					throw e;
				}
			}catch(Exception e){
				System.out.println("1~8사이 정수로 입력 해 주세요.");
			}
			switch (select) {
			case 1:
				sp.insertContact();
				break;
			case 2:
				sp.searchInfoPrint();
				break;
			case 3:
				sp.editContact();
				break;
			case 4:
				sp.deleteContact();
				break;
			case 5:
				sp.printAllData();
				break;
			case 6:
				sp.saveFile();
				break;
			case 7:
				sp.loadFile();
				break;
			case 8:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
	
	static void printMenu() {
		System.out.println("==========================");
		System.out.println("# 전화번호부");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 출력");
		System.out.println("6. 연락처 파일 저장");
		// 연락처 파일 불러오기를 해야 contacts에 기존에 입력한 내용이 다시 입력이되며,
		// 5번 전체 출력하면 해당 내용을 다시 확인 할 수 있다.
		// 아니면 SmartPhone.java의 생성자에 loadFile()메소드를 호출하면,
		// 불러오기를 하지 않아도 contacts에 data가 세팅되어 있다.
		System.out.println("7. 연락처 파일 불러오기");
		System.out.println("8. 프로그램 종료");
		System.out.println("==========================");
		System.out.println("원하시는 메뉴 번호를 입려해주세요.");
	}

}
