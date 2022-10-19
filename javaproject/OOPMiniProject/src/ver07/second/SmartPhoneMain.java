package ver07.second;

public class SmartPhoneMain {

	public static void main(String[] args) {

		SmartPhone sp = SmartPhone.getInstance();
		
		while (true) {
			try {
					
				printMenu();

				int select = Integer.parseInt(sp.sc.nextLine().trim());

				if (!(select >= 1 && select <=8)) {
					throw new Exception("1~8 사이 번호를 입력하세요.");
				}

				switch (select) {
				case 1:
					sp.inserContact();
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
					System.out.println("프로그래을 종료합니다.");
					return;
				}	

			} catch(NumberFormatException e) {
				System.out.println("정수 형태로 입력 해 주세요.");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// 처음시작할때 직렬화된 데이트 불려와서 그대로 사용하도록? 파일 저장, 수정, 삭제, 종료 할때 직렬화 하기
	
	static void printMenu() {
		System.out.println("=====================");
		System.out.println("=======전화번호부=======");
		System.out.println("1. 연락처 저장");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체출력");
		System.out.println("6. 파일 저장");
		System.out.println("7. 파일 로드");
		System.out.println("8. 프로그램 종료");
		System.out.println("==================");
		System.out.println("원하시는 메뉴 번호를 입력해주세요. >>>");
	}
}
