package ver07.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {

	// 기능 클래스: 속성을 가지지 않고 메소드들로만 정의된 메소드
	// 메인에서 여러개의 인스턴스가 생성될 필요가 없다면 => 싱글톤 패턴
	// 싱글톤
	// 1. private 생성자
	// 2. 클래스 내부에서 인스턴스를 생성 static private
	// 3. 내부에서 생성한 참조값을 반환 해주는 메소드 필요 public static

	// 요구사항
	// 이 클래스는 연락처 정볼르 관리하는 클래스입니다.
	// ① Contact 클래스의 인스턴스 10개를 저장 할 수 있는 배열을 정의합시다. Contact[]
	// Contact 클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장한다.
	
	// private Contact[] contacts; 아래로 변경
	// int seq; 아래로 변경
	List<Contact> contacts;
	Scanner sc;
	
	// 생성자
	//private SmartPhone(int size) { 아래로 변경
	private SmartPhone() {
		// contacts = new Contact[size]; 아래로 변경
		// seq = 0; 아래로 변경
		contacts = new ArrayList<Contact>();
		sc = new Scanner(System.in);
	}
	
	private static SmartPhone sp = null;
	
	public static SmartPhone getInstance() {
		if(sp == null) {
			//sp = new SmartPhone(10); 아래로 변경
			sp = new SmartPhone();
		}
		return sp;
	}

	// 기능
	// ② 배열에 인스턴스를 저장하고,
	// 수정하고, 
	// 삭제, 
	// 검색 후 결과 출력, 
	// 저장된 데이터의 리스트를 출력하는 메소드를 정의합니다.
	
	// 전체 입력 데이터 출력
	void printAllData() {
		System.out.println("===== 전체 데이터 출력 =====");
		// 배열 변수에 저장된 모든 데이터 출력
		//if (seq==0) { 아래로 수정
		if (contacts.size()==0) { // contacts.isEmpty()로 해도 됨
			System.out.println("입력된 데이터가 없습니다.");
			return;
		}
		//for (int i=0; i<seq; i++) { 아래로 수정
		for (int i=0; i<contacts.size(); i++) {
			//contacts[i].printInfo(); 아래로 수정
			contacts.get(i).printInfo();
		}
	}
	
	// 데이터 수정 (이름 검색)
	void editContact() {
		// 검색어 받기
		System.out.println("데이터 수정을 진행합니다.");
		System.out.println("수정하고자 하는 이름을 입력하세요.");
		
		int searchIndex = getIndex();
		
		if(searchIndex < 0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}
		
		//Contact contact = contacts[searchIndex]; 아래로 변경
		Contact contact = contacts.get(searchIndex);
		
		
		System.out.println("데이터 수정을 시작합니다.");
		
		System.out.println("변경하고자 하는 이름을 입력해주세요. (현재값: " + contact.getName() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newName = getString();
		contact.setName(newName);
		
		System.out.println("변경하고자 하는 전화번호를 입력해주세요. (현재값: " + contact.getPhoneNumber() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newPhoneNumber = getPhoneNumber();
		contact.setPhoneNumber(newPhoneNumber);
		
		System.out.println("변경하고자 하는 이메일을 입력해주세요. (현재값: " + contact.getEmail() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newEmail = getString();
		contact.setEmail(newEmail);
		
		System.out.println("변경하고자 하는 주소를 입력해주세요. (현재값: " + contact.getAddress() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newAddress = getString();
		contact.setAddress(newAddress);
		
		System.out.println("변경하고자 하는 생일을 입력해주세요. (현재값: " + contact.getBirthday() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newBirthday = getString();
		contact.setBirthday(newBirthday);
		
		System.out.println("변경하고자 하는 그룹을 입력해주세요. (현재값: " + contact.getGroup() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
		String newGroup = getString();
		contact.setGroup(newGroup);
		
		if (contact instanceof CompanyContact) {
			
			CompanyContact comContact = (CompanyContact) contact;
			
			System.out.println("변경하고자하는 회사명을 입력해주세요. (현재값: " + comContact.getCompany() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newCompany = getString();
			comContact.setCompany(newCompany);
			
			System.out.println("변경하고자하는 부서명을 입력해주세요. (현재값: " + comContact.getDivision() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newDivision = getString();
			comContact.setDivision(newDivision);
			
			System.out.println("변경하고자하는 직급을 입력해주세요. (현재값: " + comContact.getManager() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newManager = getString();
			comContact.setManager(newManager);
			
		} else if (contact instanceof CustomerContact) {

			CustomerContact custContact = (CustomerContact) contact;

			System.out.println("변경하고자하는 거래처명을 입력해주세요. (현재값: " + custContact.getCompany() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newCompany = getString();
			custContact.setCompany(newCompany);

			System.out.println("변경하고자하는 품목을 입력해주세요. (현재값: " + custContact.getProduct() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newProduct = getString();
			custContact.setProduct(newProduct);

			System.out.println("변경하고자하는 담당자를 입력해주세요. (현재값: " + custContact.getManager() + ")\n변경하지 않으려면 엔터를 치세요. >>> ");
			String newManager = getString();
			custContact.setManager(newManager);

		}
		
		System.out.println("데이터가 수정되었습니다.");
		//contacts[searchIndex].printInfo(); 아래로 변경
		contacts.get(searchIndex).printInfo();
	}
	
	
	// 삭제 (이름 검색)
	void deleteContact() {
		System.out.println("데이터 삭제를 진행합니다.");
		System.out.print("삭제하고자 하는 이름을 입력하세요. >>> ");
		//String name = getString();
		
		int searchIndex = getIndex();
		
		if (searchIndex<0) {
			System.out.println("삭제하고자 하는 이름의 데이터가 존재하지 않습니다.");
		} else {
			// 삭제하기 위해서 배열에서는 시프트를 해야 했지만, List를 적용하면 시프트를 할 필요 없다
			//for (int i=searchIndex; i<seq; i++) {
			//		contacts[i] = contacts[i+1];
			//}
			//seq--;
			
			// 리스트의 remove메소드를 호출하면 해당 인덱스의 값이 삭제된다.
			contacts.remove(searchIndex);
			
			System.out.println("데이터가 삭제되었습니다.");
		}
		
	}
	
	// 검색 후 결과 출력 (이름 검색)
	void searchInfoPrint() {
		
		// 1. 사용자에게 검색할 키워드 입력 받는다.
		// 2. 배열에서 이름 검색
		// 3. 결과 출력: "검색한 이름의 정보가 없습니다."
		
		String name = null; // 검색하고자 하는 이름
		
		System.out.println("검색을 시작합니다.");
		System.out.print("검색할 이름을 입력하세요. >>> ");

		int searchIndex = getIndex();
		
		// 3. 결과 출력: "검색한 이름의 정보가 없습니다."
		System.out.println("===== 검색의 결과 =====");
		if (searchIndex < 0) {
			System.out.println("검색한 이름의 정보가 없습니다.");
		} else {
			//contacts[searchIndex].printInfo(); 아래로 수정
			contacts.get(searchIndex).printInfo();
		}
			
	}
	
	// 데이터 신규 등록
	void inserContact() {
		// 배열에 인스턴스 저장
		// 1. 데이터 입력 받기
		// 2. 인스턴스 생성
		// 3. 배열에 인스턴스 참조값 저장
		
		//if(seq == contacts.length) { 아래로 수정
		if(contacts.size() == 10) {
			System.out.println("최대 저장 개수는 10개 입니다.");
			return;
		}
		
		int select = 0;
		
		while(true) {
			System.out.println("입력하고자하는 친구 타입을 선택해주세요.");
			System.out.println("1. 회사동료 | 2. 거래처");
			
			try {
				select = Integer.parseInt(sc.nextLine());
				if(!(select == 1 || select ==2)){
					throw new Exception();
				}else {
					break;
				}
			}catch(Exception e) {
				System.out.println("1과 2 중에 입력하세요.");
			}
		}
		
		
		String name = null;
		String phoneNumber =  null;
		String email =  null;
		String address =  null;
		String birthday =  null;
		String group =  null;
		
		// 데이터 입력 받기
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 >>> ");
		name = getName();
		
		System.out.print("전화번호 >>> ");
		phoneNumber = getPhoneNumber();
		
		System.out.print("이메일 >>> ");
		email = getString();
		
		System.out.print("주소 >>> ");
		address = getString();
		
		System.out.print("생일 >>> ");
		birthday = getString();
		
		System.out.print("그룹 >>> ");
		group = getString();
		
		Contact contact = null;
		
		// 분기하여 생성 => 1. 회사동료 | 2. 거래처
		if (select == 1) {
			// CompanyContact 인스턴스 생성
			System.out.print("회사명 >>> ");
			String company = getString();
			
			System.out.print("부서명 >>> ");
			String divison = getString();
			
			System.out.print("회사명 >>> ");
			String manager = getString();
			
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group, company, divison, manager);
			
		}else {
			// CustomerContact 인스턴스 생성
			System.out.print("거래처명 >>> ");
			String company = getString();
			
			System.out.print("품목명 >>> ");
			String product = getString();
			
			System.out.print("담당자 >>> ");
			String manager = getString();
			
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product, manager);	
		} 
		
		//contacts[seq++] = contact; 아래로 수정
		contacts.add(contact);
		
		//System.out.println(seq + "번째 데이타가 입력 되었습니다."); 아래로 수정
		System.out.println(contacts.size() + "번째 데이타가 입력 되었습니다.");
	
	}
	
	// Scanner를 통해 입력받은 문자열이 공백일 경우 다시 입력하도록 하는 기능
	private String getString() {

		String str = null;

		while (true) {

			str = sc.nextLine().trim();

			if (str != null & str.length() >0) {
				break;
			}else {
				System.out.println("공백은 허용되지 않습니다. 정상적인 문자를 입력하세요.");
			}
		}
		return str;
	}
	
	// 이름을 입력 받을 때(신규 등록 시에만 적용) 중복 여부 체크. 중복되면 다시 입력 권유 + 공란 입력 방지
	private String getName() {

		String name = null;

		while (true) {

			try {

				name = sc.nextLine().trim();

				if (name != null && name.length()>0) {
					// 공백없이 입력은 받았지만 형식이 맞는지 체크
					if (!Pattern.matches("^[a-zA-Z가-힣]*$", name)) {
						throw new Exception("이름에는 영문자와 한글만 가능합니다. 다시 입력해주세요.");
					}
					
					// 정상적인 입력이 들어온 상태에서, 배열 요소에 같은 이름의 요소가 있는지 체크
					boolean check = false;

					// 이름 검색
					//for (int i=0; i<seq; i++) { 아래로 수정
					for (int i=0; i<contacts.size(); i++) {
						//if(name.equals(contacts[i].getName())) { 아래로 수정
						if(name.equals(contacts.get(i).getName())) {
							check = true;
							break;
						}
					}
					if (check) {
						System.out.println("같은 이름의 데이터가 존재합니다. \n 다시 입력하세요.");
						continue;
					}else {
						break;
					}
				}else {
					//System.out.println("공란은 허용되지 않습니다. 정상적인 문자를 입력하세요.");
					throw new Exception("예외발생! 공란은 허용되지 않습니다. 정상적인 문자를 입력해주세요. >>>");
				}
			} catch(Exception e) {
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}	
		}
		return name;	
	}
	
	// 전화번호 입력 받을 때 중복 여부 체크. 중복되면 다시 입력 권유 + 공란 입력 방지
	private String getPhoneNumber() {
		String phoneNumber = null;
		
		while (true) {

			// 전화번호 형식에 맞지 않을때 예외처리를 하고 중복될때 예외 상황이 발생하도록 하고 예외 처리를 한다.
			try {

				phoneNumber = sc.nextLine().trim();

				if(phoneNumber != null && phoneNumber.length()>0) {

					// 전화번호 패턴 확인
					if (!Pattern.matches("^\\d{3}-\\d{4}-\\d{4}+$", phoneNumber)) {
						throw new Exception("000-0000-0000형식에 맞도록 입력하세요.\n다시 입력해주세요.");
					}

					boolean check = false;

					// 중복 여부 체크
					//for(int i=0; i<seq; i++) { 아래로 수정
					for(int i=0; i<contacts.size(); i++) {
						//if(phoneNumber.equals(contacts[i].getPhoneNumber())) { 아래로 수정
						if(phoneNumber.equals(contacts.get(i).getPhoneNumber())) {
							check = true;
							break;
						}
					}

					if (check) {
						System.out.print("중복된 전화번호가 존재합니다.\n 다시 입력하세요. >>>");
					}else {
						break;
					}
				}else {
					//System.out.println("공란은 허용되지 않습니다. 다시 입력하세요.");
					throw new Exception("예외발생! 공란은 허용되지 않습니다. 다시 입력해주세요.");
				}

			} catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
		
		return phoneNumber;
	}
	
	// 이름 입력 받고 이름 가지고 해당 index를 찾아서 반환 => 수정, 검색, 삭제에서 사용
	private int getIndex() {

		String name = getString().trim();

		int searchIndex = -1;

		//for (int i=0; i<seq; i++) { 아래로 변경
		for (int i=0; i<contacts.size(); i++) {
			//if(contacts[i].getName().equals(name)) { 아래로 변경
			if(contacts.get(i).getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		return searchIndex;	
	}
}

	

