package ver03.third;

import java.util.Scanner;

public class SmartPhone {

// 기능 클래스: 속성을 가지지 않고, 메소드들로만 정의된 클래스
// 여러개의 인스턴스가 생성될 필요가 없다 => 싱글톤 패턴
//		1. private 생성자
//		2. 클래스 내부에서 인스턴스를 생성 private static
//		3. 내부에서 생성한 참조값을 반환해주는 메소드 필요 public static
	
// 요구사항
// 이 클래스는 연락처 정보를 관리(CRUD)하는 클래스입니다.
// ① Contact 클래스의 인스턴스 10개를 저장할 수 있는 배열 정의
//		=> 10개 정보 저장 => 배열 인스턴스 생성 Contact[]
// Contact클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장한다.
	
	// 변수 선언
	private Contact[] contacts; // 배열 변수
	int seq; // 입력된 정보의 개수값을 갖고 있는 변수, 순번개념, 배열의 index값으로 사용
	Scanner sc; // 여러군데에서 사용하므로 이곳에 올려서 선언
	
	// 싱글톤 요건: private 생성자
	private SmartPhone(int size) {
		contacts = new Contact[size];
		seq = 0;
		sc = new Scanner(System.in);
	}
	
	// 싱글톤 요건: 클래스 내부에서 인스턴스를 생성
	private static SmartPhone sp = new SmartPhone(10);
	
	// 싱글톤 요건: 내부에서 생성한 참조값을 반환해주는 메소드. 반환 타입 명시: SmartPhone
	public static SmartPhone getInstance() {
		if(sp == null) {
			sp = new SmartPhone(10);
			System.out.println();
		}
		return sp;
	}
	
// 기능
// ② 배열에 인스턴스를
// 1. 저장
// 2. 수정
// 3. 삭제
// 4. 검색 후 결과 출력
// 5. 저장된 데이터 전체 리스트 출력
	
	// 데이터 신규 등록
	void inserContact() {
		// 배열에 인스턴스를 저장
		//	1. 데이터 입력 받기
		//	2. 인스턴스 생성
		//	3. 배열에 인스턴스의 참조값을 저장
		
		if(seq == contacts.length) {
			System.out.println("최대 저장 개수는 " + contacts +"개 입니다.");
		}
		
		// 1. 회사 동료 입력 / 2. 거래처 정보 입력
		
		System.out.println("입력하고자하는 그룹 타입을 선택해주세요.");
		System.out.println("1. 회사동료 | 2. 거래처");
		int select = Integer.parseInt(sc.nextLine());
		
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;
		
		// 1. 데이터 입력 받기
		System.out.println("입력을 시작합니다.");
		System.out.print("이름 >>> ");
		name = sc.nextLine();
		
		System.out.print("전화번호 >>> ");
		phoneNumber = sc.nextLine();
		
		System.out.print("이메일 >>> ");
		address = sc.nextLine();

		System.out.print("주소 >>> ");
		address = sc.nextLine();
		
		System.out.print("생일 >>> ");
		birthday = sc.nextLine();
		
		System.out.print("그룹 >>> ");
		group = sc.nextLine();
		
		Contact contact = null;
		
		// 1. 회사동룍 | 2. 거래처 => 분기하여 인스턴스 생성
		if(select == 1) {
			// CompanyContact 인스턴스 생성
			System.out.print("회사명 >>> ");
			String company = sc.nextLine();
			
			System.out.print("부서명 >>> ");
			String division = sc.nextLine();
			
			System.out.print("직급 >>> ");
			String manager = sc.nextLine();
			
			contact = new CompanyContact(name, phoneNumber, email, address, birthday, group,
					company, division, manager);
		}else {
			// CustomerContact 인스턴스 생성
			System.out.print("거래처명: >>> ");
			String company = sc.nextLine();
			
			System.out.print("품목명: >>> ");
			String product = sc.nextLine();
			
			System.out.print("담당자: >>> ");
			String manager = sc.nextLine();
			
			contact = new CustomerContact(name, phoneNumber, email, address, birthday, group, company, product, manager);			
		}
		
		// 3. 배열에 대입(저장)
		contacts[seq++] = contact;
	
	}
	
	// 데이터 수정 (이름 검색)
	void editContact() {
		System.out.println("데이터 수정이 진행됩니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요. >>> ");
		String name = sc.nextLine();
		
		// 수정하고자하는 index를 찾아야한다.
		int searchIndex = -1; // 0부터 데이터가 있는 것이므로 초기값은 -1
		
		// 데이터 찾기
		for(int i=0; i<seq; i++) {
			if(contacts[i].getName().trim().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		if(searchIndex<0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
		}
		
		// 찾은 배열 값을 contact에 넣고 contact변수를 가지고 수정 진행
		Contact contact = contacts[searchIndex];
		
		System.out.println("데이터 수정을 시작합니다.");
		System.out.print("변경하고자하는 이름을 입력해주세요. (현재값: "+ contact.getName() +")\n 변경을 원치않으시면 엔터를 치세요.");
		String newName = sc.nextLine().trim();
		
		if(newName != null && newName.length()>0) {
			contact.setName(newName);
		}
		
		System.out.print("변경하고자하는 전화번호를 입력해주세요. (현재값: " + contact.getPhoneNumber() +")\n 변경을 원치 않으시면 엔터를 치세요.");
		String newPhoneNumber = sc.nextLine().trim();
		
		if(newPhoneNumber != null && newPhoneNumber.length()>0) {
			contact.setPhoneNumber(newPhoneNumber);
		}
		
		System.out.print("변경하고자하는 이메일을 입력해주세요. (현재값: " + contact.getEmail() +")\n 변경을 원치 않으시면 엔터를 치세요.");
		String newEmail = sc.nextLine().trim();
		
		if(newEmail != null && newEmail.length()>0) {
			contact.setEmail(newEmail);
		}
		
		System.out.print("변경하고자하는 주소를 입력해주세요. (현재값: " + contact.getAddress() +")\n 변경을 원치 않으시면 엔터를 치세요.");
		String newAddress = sc.nextLine().trim();
		
		if(newAddress != null && newAddress.length()>0) {
			contact.setAddress(newAddress);
		}
		
		System.out.print("변경하고자하는 생일을 입력해주세요. (현재값: " + contact.getBirthday() +")\n 변경을 원치 않으시면 엔터를 치세요.");
		String newBirthday = sc.nextLine().trim();
		
		if(newBirthday != null && newBirthday.length()>0) {
			contact.setBirthday(newBirthday);
		}
		
		System.out.print("변경하고자하는 그룹을 입력해주세요. (현재값: " + contact.getGroup()+")\n 변경을 원치 않으시면 엔터를 치세요.");
		String newGroup = sc.nextLine();
		
		if(newGroup != null && newGroup.length()>0) {
			contact.setName(newName);
		}
		
		
		
		
	}
	
	// 검색 출력 (이름 검색)
	
	// 삭제 (이름 검색)
	
	// 전체 데이터 출력
	
	
	
	
	
	
	
	
	
	
	
	
}



















