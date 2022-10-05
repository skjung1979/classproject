package ver07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhone {
	
	// 해당 클래스는 기능 클래스이다: 속성을 가지지 않고 메소드들로만 정의된 클래스이다.
	// 여러개의 인스턴스가 생성될 필요가 없다!
	// => 싱글톤 패턴 사용 (1~3항목)
	// 1. private 생성자
	// 2. 클래스 내부에서 접근하여 사용할 인스턴스를 생성 static private 표시
	// 3. 내부에서 생성한 참조값을 반환 해주는 메소드 필요 static public 표시

	// 요구사항
	// 이 클래스는 연락처 정보를 관리하는 클래스입니다.
	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다.
	// => 10개 정보를 저장할 수 있다. -> 배열 인스턴스를 생성 Contact[]
	// Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장

	// 이제 불필요하단. private Contact[] contacts; // 배열 변수 선언
								// 초기화 안 했으므로 null이 들어감.
								// 생성자에서 초기화할 것! 외부에서 보여질 이유가 없으니 private
	// 이제 불필요하단. private int numOfContact; // 입력된 정보의 개수를 받는 변수, 배열의 index 값으로 사용
	
	List<Contact> contacts;
	
	Scanner sc; // 스캐너 여기서는 선언만!!!!

	// 생성자
	// 싱글톤 조건 private
	private SmartPhone() {
		// contacts = new Contact[size]; // 초기화
		// numOfContact = 0;
		contacts = new ArrayList<>();
		sc = new Scanner(System.in); // 스캐너 여기서 초기화
	}

	// 싱글톤 조건: 인스턴스 생성 시 private static
	private static SmartPhone sp = new SmartPhone();

	// 싱글톤 조건: 반환 메소드에 public static
	public static SmartPhone getInstance() {
		if (sp == null) {
			sp = new SmartPhone();
		}
		return sp;
	}

	// ② 배열에 인스턴스를 저장하고,
	// 수정하고,
	// 삭제,
	// 검색 후 결과 출력,
	// 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.

	
	// 이름을 입력받고, 배열에 해당 이름의 Contact 객체가 있는 index 반환
	private int getIndex() {
		
		
		String name = sc.nextLine();
		 
		// 이름 검색하고자 하는 index 먼저 찾아야 한다. 
		int searchIndex = -1; //  -1d은 현재 검색의 결과는 없다!!는 의미다.

		// 데이터 찾기
		for(int i=0; i<contacts.size();i++) {
			if(contacts.get(i).getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		return searchIndex;
	}
		
	// 이름 검색 후 데이터 수정
	void editContact() {
		
		// 검색어 받기
		System.out.println("데이터 수정이 진행됩니다.");
		System.out.println("수정하고자 하는 이름을입 력해주세요.");
		
		int searchIndex = getIndex();
		
		if(searchIndex<0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}
		
		Contact contact = contacts.get(searchIndex);
		
		System.out.println("데이터 수정을 진행합니다.");
		// 추후 트랜젝션 처리를 할 필요가 있다!!!! 예외처리로!!!
		
		System.out.println("변경하고자하는 이름을 입력해주세요. (현재값: "+contact.getName()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
		String newName = sc.nextLine();	
		if(newName != null && newName.trim().length()>0) {
			contact.setName(newName);
		}
		
		System.out.println("변경하고자하는 전화번호를 입력해주세요. (현재값: "+contact.getPhoneNumber()+")\n"
				+ "변경하지않으려면 엔터를치세요. >");
		String newPhoneNumber = getPhoneNumber();		
		if(newPhoneNumber != null && newPhoneNumber.trim().length()>0) {
			contact.setPhoneNumber(newPhoneNumber);
		}
		
		System.out.println("변경하고자하는 이메일를 입력해주세요. (현재값: "+contact.getEmail()+")\n"
				+ "변경하지않으려면 엔터를치세요. >");
		String newEmail = sc.nextLine();		
		if(newEmail != null && newEmail.trim().length()>0) {
			contact.setEmail(newEmail);
		}
		
		System.out.println("변경하고자하는 주소를 입력해주세요. (현재값: "+contact.getAddress()+")\n"
				+ "변경하지않으려면 엔터를치세요. >");
		String newAddress = sc.nextLine();	
		if(newAddress != null && newAddress.trim().length()>0) {
			contact.setAddress(newAddress);
		}
		
		System.out.println("변경하고자하는 생일을 입력해주세요. (현재값: "+contact.getBirthday()+")\n"
				+ "변경하지않으려면 엔터를치세요. >");
		String newBirthday = sc.nextLine();
		if(newBirthday != null && newBirthday.trim().length()>0) {
			contact.setBirthday(newBirthday);
		}
		
		System.out.println("변경하고자하는 그룹을 입력해주세요. (현재값: "+contact.getGroup()+")\n"
				+ "변경하지않으려면 엔터를치세요. >");
		String newGroup = sc.nextLine();
		if(newGroup != null && newGroup.trim().length()>0) {
			contact.setGroup(newGroup);
		}
		
		if(contact instanceof CompanyContact) {
			
			CompanyContact companyContact = (CompanyContact)contact;
			// companyContact.setCompany(newGroup);

			System.out.println("변경하고자하는 회사이름을 입력해주세요. (현재값: "+companyContact.getCompany()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String company = sc.nextLine();
			if(company != null && company.trim().length()>0) {
				companyContact.setCompany(company);
			}
			
			System.out.println("변경하고자하는 부서이름을 입력해주세요. (현재값: "+companyContact.getDivision()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String division = sc.nextLine();
			if(division != null && division.trim().length()>0) {
				companyContact.setDivision(division);
			}
			
			System.out.println("변경하고자하는 직급이름을 입력해주세요. (현재값: "+companyContact.getManager()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String manager = sc.nextLine();
			if(manager != null && manager.trim().length()>0) {
				companyContact.setManager(manager);
			}
						
		}else if(contact instanceof CustomerContact) {
			
			CustomerContact customerContact = (CustomerContact)contact;
			
			System.out.println("변경하고자하는 거래처 이름을 입력해주세요. (현재값: "+customerContact.getCompany()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String company = sc.nextLine();
			if(company != null && company.trim().length()>0) {
				customerContact.setCompany(company);
			}
			
			System.out.println("변경하고자하는 거래품목을 입력해주세요. (현재값: "+customerContact.getProduct()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String product = sc.nextLine();
			if(product != null && product.trim().length()>0) {
				customerContact.setProduct(product);
			}
			
			System.out.println("변경하고자하는 담당자이름을 입력해주세요. (현재값: "+customerContact.getManager()+")\n"
					+ "변경하지않으려면 엔터를치세요. >");
			String manager = sc.nextLine();
			if(manager != null && manager.trim().length()>0) {
				customerContact.setManager(manager);
			}
			
		}else {
			System.out.println("오류 발생! 잘못된 타입입니다!");
		}
		
		
		
		System.out.println("정보가 수정되었습니다.");
		System.out.println();
	}
	
	// 삭제(이름으로 검색)
	void deleteContact() {
		
		// 검색어 받기
		System.out.println("데이터 삭제가 진행됩니다.");
		System.out.println("삭제하고자 하는 이름을입 력해주세요.");

		int searchIndex = getIndex();

		
		// 검색한 index값으로 분기: 시프트를 하거나, 검새과 이름이 존재하지 않는다.
		if(searchIndex<0) {
			System.out.println("삭제하고자하는 이름의 데이터가 존재하지 않습니다.");
		}else {
			
			contacts.remove(searchIndex);
			
			System.out.println("데이터가 삭제되었습니다.");
		}
	}
		
	// 검색 후 결과 출력, (search) 이름으로검색
	void searchInfoPrint() {
		// 1. 사용자에게 검색할 키워드(이름) 입력 받는다.
		// 2. 배열에서 이름 검색
		// 3. 결과 출력: "검색한 이름은 데이터 출력" or "검색한 이름의 정보가 없습니다."
		String name = null; // 검색할 이름
		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. >");
		
		int searchIndex = getIndex();

		Contact contact = null;

		

		// 3. 결과 출력
		System.out.println("검색의 결과 ===============");
		if (contacts.size() < 0) {
			System.out.println("입력한 이름 " + name + "의 검색 정보가 없습니다.");
		} else {
			contacts.get(searchIndex).printInfo();
		}

	}

	// 전체 입력 데이터의 출력
	void printAllData() {
		// 배열에 저장된 데이터를 모두 출력
		System.out.println("전체 데이타를 출력합니다. ==============");
		if(contacts.isEmpty()) {
			System.out.println("입력된 정보가 없습니다.");
			return; // 조건에 맞지 않다면 호출했던 메인메소드로 다시 넘깁니다.
		}
		
		for (int i = 0; i < contacts.size(); i++) {
			contacts.get(i).printInfo();
		}
	}

	void insertContact() {
		// 배열에 인스턴스를 저장하고, (1~3항목)
		// 1. 데이터 받고,
		// 2. 인스턴스 생성하고,
		// 3. 배열에 인스턴스의 참조값을 저장
		
		if(contacts.size() == 10) {
			System.out.println("최대 저장 개수는 10개 입니다.");
			return; // 조건에 맞지 않다면 호출했던 메인메소드로 다시 넘깁니다.
		}	
		
		// 회사 친구 입력?
		// 거래처 정보 입력? 어느것?
		System.out.println("입력하고자하는 친구 타입을 선택해주세요.");
		System.out.println("1. 회사동료 \t 2. 거래처");
		int select = Integer.parseInt(getString());

		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;

		// 1. 데이터 받고
		System.out.println("입력을 시작합니다.");
		System.out.print("이름 >");
		name = getName();

		System.out.print("전화번호 >");
		phoneNumber = getPhoneNumber();

		System.out.print("이메일 >");
		email = getString();

		System.out.print("주소 >");
		address = getString();

		System.out.print("생일 >");
		birthday = getString();

		System.out.print("그룹 >");
		group = getString();

		Contact contact = null;
		
		// 분기 1. 회사 2.거래처?
		if(select == 1) {
			// CompanyContact 인스턴스 생성
			System.out.println("회사이름 >> ");
			String company = getString();
			System.out.println("부서이름 >> ");
			String division = getString();
			System.out.println("직급 >> ");
			String manager = getString();
			
			// 인스턴스 생성
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, division, manager);
			
		}else {
			// CustomerContact 인스턴스 생성
			System.out.println("거래처 이름 >> ");
			String company = getString();
			System.out.println("거래 품목 >> ");
			String product = getString();
			System.out.println("담당자 >> ");
			String manager = getString();
			
			// 인스턴스 생성
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product, manager);
		}
		
		// 3. 배열에 저장
		// 처음 입력: numOfContact => 0
		contacts.add(contact);

	}

	// Scanner를 통해서 사용자에게 문자열을 받아서 반환화는 메ㅗㅅ드
	// 입력 문자가 공백일 경우 다시 입력하도록 하는 기능
	private String getString() {
		
		String str = null;
		
		while(true) {
			str = sc.nextLine();
			if(str != null && str.trim().length() != 0) {
				break;
			}else {
				System.out.println("공백은 허용되지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		return str;
	}
	
	// 이름 정보를 받아서 중복 여부 체크를 한다. 중복되면 다시 입력 권유. 체크 후 문자열 반환
	private String getName() {
		String name = null;

		while (true) {
			name = sc.nextLine();
			if (name != null && name.trim().length() != 0) {
				// 정상적으로 입력이 들어온 상태에서, 배열 요소에 같은 이름의 요소가 있는지
				boolean check = false;

				// 이름 검색
				for (int i = 0; i < contacts.size(); i++) {
					if (name.equals(contacts.get(i).getName())) {
						check = true;
						break;
					}
				}
				if (check) {
					System.out.println("같은 이름의 데이터가 존재합니다.\n 다시 입력하세요. >>");
					continue;
				} else {
					break;
				}

			} else {
				System.out.println("공백은 허용되지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		return name;
	}
		
	// 전화번호를 받아서 중복된 전화번호가 있는지 체크, 중복되지 않는 전화번호를 받아서 반환
	private String getPhoneNumber() {
		String phoneNumber = null;
		
		while(true) {
			
			phoneNumber = sc.nextLine();
			
			if(phoneNumber != null && phoneNumber.trim().length() > 0 ) {
				
				boolean check = false;
				
				// 중복여부 체크
				for(int i=0; i< contacts.size(); i++) {
					if(phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
						check = true;
						break;
					}
				}			
				if(check) {
					System.out.println("중복된 전화번호가 존재합니다. \n 다시 입력해주세요. >> ");
				}else {
					break;
				}			
			}else {
				System.out.println("공백 문자 허용되니 않습니다. 다시 입력해주세요.");
			}		
		}		
		return phoneNumber;
	}
}



















