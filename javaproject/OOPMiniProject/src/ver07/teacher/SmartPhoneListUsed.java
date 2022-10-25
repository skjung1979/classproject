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
	
	// 입력 메소드
	public Contact inputContactData(int type) { // type는 전달 받은 매개 변수 select
		
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
		return contact;
	}
	
	// 공백, 존재여부, 형식 등 체크하는 메소드
	public String getString(String label) { // getString사용자에게 받은 매개변수 ex) "이름" 등
		
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
					throw new Exception("중복되는 전화번호입니다!");
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			} else if (label.equals("전화번호") && !checkPhoneNumber(str)) {
				
				try {
					throw new Exception("전화번호 형식에 맞지 않습니다!");				
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			} else if (label.equals("이름") && checkName(str)) {
				
				try {
					throw new Exception("잘못된 이름을 입력하셨습니다. 영문자, 한글로만 입력 가능합니다!");					
				} catch (Exception e) {
					System.out.println(e.getMessage() + ": 다시 입력해주세요.");
					continue;
				}
			}
			break;
		}
		return str;
	}
	
	// 전화 번호 존재하는지 체크
	public boolean existPhoneNumber(String number) {
		boolean exist = false;
		for (int i=0; i<contacts.size(); i++) {
			if (contacts.get(i).getPhoneNumber().equals(number)) {
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	// 이름 형식 체크 (영문자나 한글로만 입력 받도록. 숫자 안됨)
	public boolean checkName(String name) {
		boolean check = true;
		for (int i=0; i<name.length(); i++) {
			char c = name.charAt(i);
			if (c>='a' && c<='z' || c>='A' && c<='Z' || c>='가' && c<='힣') {
				check = false;
				break;
			}
		}
		
		return check;
	}
	
	// 전화번호 형식 체크
	public boolean checkPhoneNumber(String number) {
		boolean check = true;
		for (int i=0; i<number.length(); i++) {
			char c = number.charAt(i);
			if (!(c>='0' && c<='9' || c=='-')) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	// 배열에 연락처 객체 저장
	public void addContact(Contact contact) {
		
		contacts.add(contact);
		System.out.println(">> 데이터가 저장되었습니다. (" +contacts.size() + ")");
		
	}
	
	public void printContact(Contact contact) {
		System.out.println("---------------------------------------");
		contact.printInfo();
		System.out.println("---------------------------------------");
	}
	
	// 모든 연락처 출력
	public void printAllContact() {
		for (int i=0; i<contacts.size(); i++) {
			printContact(contacts.get(i));
		}
	}
	
	// 연락처 검색
	public Contact searchContact(String name) {
		
		for (int i=0; i<contacts.size(); i++) {
			Contact contact = contacts.get(i);
		
			if (contact.getName().equals(name)) {
				printContact(contact);
				return contact;
			}
		}
		System.out.println("검색 결과가 없습니다.");
		return null;
	}
	
	// 연락처 삭제
	public void deleteContact(String name) {
		for (int i=0; i<contacts.size(); i++) {
			Contact contact = contacts.get(i);
			if (contact.getName().equals(name)) {
				contacts.remove(i);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}
	
	// 연락처 수정
	public void editContact(String name, Contact newContact) {
		for (int i=0; i<contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				deleteContact(name);
				contacts.add(newContact);
				return;
			}
		}
		System.out.println("검색 결과가 없습니다.");
	}

}






















