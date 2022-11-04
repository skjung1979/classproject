package ver09.teacher;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SmartPhoneListUsed sp = new SmartPhoneListUsed();
		
		while (true) {
			
			printMenu();
			// String choiceMenu = scanner.nextLine();
			int choiceMenu = 0;
			try {
				choiceMenu = Integer.parseInt(sc.nextLine());
			} catch (InputMismatchException e) {
				System.out.println("숫자를 입력해주세요.!!!!!!!");
				continue;
			}

			switch (choiceMenu) {
			case 1:
				System.out.println("-------------------------------");
				System.out.println("입력 타입을 선택해주세요. ");
				System.out.println("1. 회사,   2. 거래처");
				System.out.println("-------------------------------");
				int select = Integer.parseInt(sc.nextLine());
			
				sp.addContact(sp.inputContactData(select));
				break;
			case 2:
				
				System.out.println("검색하고자하는 이름을 입력하세요.");
		
				sp.searchContact(sc.nextLine());
				
				break;
			case 3:
				
				System.out.println("수정하고자하는 이름을 입력하세요.");
				String editName = sc.nextLine();
				
				Contact contact = sp.searchContact(editName);
				
				if (contact != null) {
					System.out.println("데이터를 새로 입력해주세요.");
					
					if (contact instanceof CompanyContact) {
						sp.editContact(editName, sp.inputContactData(1));
					} else if (contact instanceof CustomerContact) {
						sp.editContact(editName, sp.inputContactData(2));
					}
				}
				
				break;
			case 4:
				System.out.println("삭제하고자하는 이름을 입력하세요.");
				sp.deleteContact(sc.nextLine());
				
				break;
			case 5:
				sp.printAllContact();
				
				break;
			case 6:
				sp.saveFile();
				return;
			case 7:
				sp.loadFile();
				return;
			case 8:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 메뉴입니다. 다시 선택해주세요.");				
			}
		}
	}
	
	public static void printMenu() {
		System.out.println("Contact --------------------------");
		System.out.println(">> 1. 연락처 입력");
		System.out.println(">> 2. 연락처 검색");
		System.out.println(">> 3. 연락처 수정");
		System.out.println(">> 4. 연락처 삭제");
		System.out.println(">> 5. 연락처 전체 리스트 보기");
		System.out.println(">> 6. 연락처 파일 저장");
		System.out.println(">> 7. 연락처 파일 로드");
		System.out.println(">> 8. 프로그램 종료");
		System.out.println("------------------------------------");
		System.out.println("원하시는 기능의 번호를 입력하세요.");
	}
}
