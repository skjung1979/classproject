package ver07.teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhoneListUsed {
	
	List<Contact> contacts;
	Scanner sc;
	
	public SmartPhoneListUsed() {
		super();
		contacts = new ArrayList<Contact>();
		sc = new Scanner(System.in);
	}
	
	// 입력 그룹 구분자
	public Contact inputContactData(int type) {
		
		Contact contact = null;
		
		String name = getString("이름");
		String phoneNumber = getString("전화번호");
		String email = getString("이메일");
		String address = getString("주소");
		String birthday = getString("생일");
		String group = getString("이름");
		
		if (type == 1) {
			String company = getString("회사명");
			String depart = getString("부서명");
			String job = getString("직급");
			
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, depart, job);
		} else if (type == 2) {
			String company = getString("거래처명");
			String product = getString("품목명");
			String job = getString("직급");
			
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product, job);
		}
	}
	
	// 
	public String getString(String label) {
		
		String str = null;
		
		while (true) {
			
			System.out.print(label + " : ");
			str = sc.nextLine();
			
			if (str.isEmpty()) {
				
				try {
					throw new Exception("공백 문자열 입력!");
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			} else if (label.equals("전화번호") && existPhoneNumber(str)) {
				try {
					throw new Exception("존재하는 전화번호 입력하세요.");
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			} else if (label.equals("전화번호") && !checkPhoneNumber(str)) {
				
				try {
					throw new Exception("전화번호 형식에 맞지 않습니다.");				
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			} else if (label.equals("이름") && checkName(str)) {
				
				try {
					throw new Exception("잘못된 이름을 입력하셨습니다.");					
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			}
			break;
		}
		return str;
	}
	

}






















