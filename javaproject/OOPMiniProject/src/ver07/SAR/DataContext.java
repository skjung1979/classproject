package ver07.SAR;

import java.util.Scanner;
import java.util.regex.Pattern;

enum MENU {CLOSE, INSERT, UPDATE, SEARCH, DELETE, PRINT_ALL};
enum CLASS_TYPE {CONTACT, COMPANY, CUSTOMER};

public class DataContext {
	private static Scanner scan;
	private static DataContext instance;
	
	private DataContext() {
		this.scan = new Scanner(System.in);
	}
	
	public static DataContext getInstance() {
		if(instance == null) {
			instance = new DataContext();
		}
		return instance;
	}
	
	int printInputMenu() {
		System.out.println("=======연락처=======");
		System.out.println("1. 입력");
		System.out.println("2. 수정");
		System.out.println("3. 검색");
		System.out.println("4. 삭제");
		System.out.println("5. 출력");
		System.out.println();
		System.out.println("0. 종료");
		System.out.println("===================");
		System.out.println("원하시는 항목을 입력하세요. >>> ");
		
		String input = scan.nextLine();
		int result;
		try {
			result = Integer.parseInt(input);
		}catch(Exception e) {
			System.out.println("데이터 입력이 잘못되었습니다.");
			System.out.println(e.getMessage());
			result = -1;
		}
		return result;
	}
	Contact inputContactData(MENU menu, String searchName) {
		Contact data = null;
		
		String name, phoneNumber, email, address, group, birth;
		
		System.out.println("그룹 구분(화사:1 / 거래처:2) >>> ");
		String input = inputString();
		int inputType = 0;
		
		try {
			inputType = Integer.parseInt(input);
			
			if(inputType != CLASS_TYPE.COMPANY.ordinal() && inputType != CLASS_TYPE.CUSTOMER.ordinal()) {
				throw new Exception("해당 데이터는 입력할 수 없습니다.");
			}
		}catch(Exception e) {
			System.out.println("잘못된 데이터 입력");
			System.out.println(e.getMessage());
			return null;
		}
		
		if(menu == MENU.INSERT) {
			System.out.println("이름 >>> ");
			name = inputString();
			if(checkNameRule(name) == false) {
				return null;
			}
		}else {
			name = searchName;
		}
		
		System.out.println("전화번호 >> ");
		phoneNumber = inputString();
		if(checkPhoneNumberRule(phoneNumber) == false) {
			return null;
		}
		System.out.print("e-Mail>>");
		email = inputString();
		System.out.print("주소>>");
		address = inputString();
		System.out.print("생일>>");
		birth = inputString();
		System.out.print("그룹>>");
		group = inputString();
		
		if(inputType == CLASS_TYPE.COMPANY.ordinal()) {
			String company, department, position;
			System.out.print("회사>>");
			company = inputString();
			System.out.print("부서>>");
			department = inputString();
			System.out.print("직책>>");
			position = inputString();
			
			data = new CompanyContact(name, phoneNumber, email, address, birth, group, company, department, position);
		} else if(inputType == CLASS_TYPE.CUSTOMER.ordinal()) {
			String company, item, position;
			System.out.print("거래처>>");
			company = inputString();
			System.out.print("거래 물품>>");
			item = inputString();
			System.out.print("직책>>");
			position = inputString();
			
			data = new CustomerContact(name, phoneNumber, email, address, birth, group, company, item, position);
		}
		
		return data;
	}
	
	String inputString() {
		String str = null;
		while(true) {
			str = scan.nextLine();
			if(str != null && str.trim().length() != 0) {
				break;
			}
			System.out.println("공란으로 둘수 없습니다.");
			System.out.println("다시 입력해주세요. >> ");
		}
		return str;
	}
	
	boolean checkNameRule(String name) {
		Pattern pattern = Pattern.compile("^[가-힣]{2,4}|[a-zA-Z]{2,10}\\s[a-zA-Z]{2,10}$");
		
		try {
			if(pattern.matcher(name).find() == false || name.strip().length() != name.length()) {
				throw new BadInputException("입력 값은 영문 및 숫자만 가능합니다.");
			}
		}catch(BadInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	boolean checkPhoneNumberRule(String phoneNumber) {
		Pattern pattern = Pattern.compile("^\\d{3}-\\d{4}-\\d{4}$");
		
		try {
			if(pattern.matcher(phoneNumber).find() == false || phoneNumber.strip().length() != phoneNumber.length()) {
				throw new BadInputException("000-0000-0000형식으로 입력해주세요. >>");
			}
		}catch(BadInputException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}































