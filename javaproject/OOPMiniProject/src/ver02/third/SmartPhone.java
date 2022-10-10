package ver02.third;

import java.util.Scanner;

public class SmartPhone {
	
// 기능 클래스: 속성을 가지지 않고 메소드들로만 정의된 클래스이다.
// 여러개의 인스턴스가 생성될 필요가 없다면 -> 싱글콘 패턴으로 구성한다.
//		1. private 생성자
//		2. 클래스 내부에서 인스턴스를 생성한다. 접근자는 private static
//		3. 내부에서 생성한 참조값을 반환해주는 메소드가 필요하다.접근자는 public static

// 요구사항
// 이 클래스는 연락처 정보를 관리하는 클래입니다.
// 1. Contact 클래스의 인스턴스 10개를 저장할수 있는 배열을 정의 합시다.
//		10개 정보를 저장항다는 것은 => 배열 인스턴스를 생성한다는 것! Contact[]
//		Contact클래스 기반의 인스턴스를 최대 10개까지 만들어서 배열에 참조값을 저장한다.
	
	private Contact[] contacts;
	int numOfContact; // 입력된 정보의 개수값이며, 배열 index 값으로 사용한다.
	Scanner sc; // 여러군데에서 사용하므로 이곳에서 선언한다.
	
	// 싱글톤 생성자 private
	private SmartPhone(int size) {
		contacts = new Contact[size]; // 개수를 받아서 생성하기 위해 생성자 블록에서 생성한다.
		numOfContact = 0;
		sc = new Scanner(System.in);
	}
	
	private static SmartPhone sp = new SmartPhone(10);
	
	// 싱글톤 메소드 public static: 내부에서 생성한 참조값을 반환한다. 
	public static SmartPhone getInstance() {
		if(sp == null) {
			sp = new SmartPhone(10);
			System.out.println();
		}
		return sp;
	}
	
// 기능
// 2. 배열에 인스턴스를 저장하고,
//		수정하고,
//		삭제하고,
//		검색 후 결과 출력하고,
//		저장도니 데이터의 리스트를 출력하는 메소드를 정의합니다.
	
	// 전체 입력 데이터의 출력
	void printAllData() {
		System.out.println("===== 전체 데이터 출력 =====");
		if(numOfContact == 0) {
			System.out.println("출력할 데이터가 없습니다.");
			return;
		}
		for(int i=0; i<numOfContact; i++) {
			contacts[i].printInfo();
		}
		
	}
	
	// 데이터 입력하기
	void insertContact() {
		// 배열에 인스턴스를 저장
		//	1. 데이터를 받고,
		//	2. 인스턴스 생성하고,
		//	3. 배열에 인스턴스의 참조값을 저장

		if(numOfContact==contacts.length) {
			System.out.println("최대 저장 개수는 "+ contacts.length + " 개 입니다.");
			return;
		}
		
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address= null;
		String birthday = null;
		String group = null;
		
		// 1. 데이터 입력 받기
		System.out.println("데이터 입력을 시작합니다.");
		System.out.print("이름 >>> ");
		name = sc.nextLine().trim();
		
		System.out.print("전화번호 >>> ");
		phoneNumber = sc.nextLine().trim();
		
		System.out.print("이메일 >>> ");
		email = sc.nextLine().trim();
		
		System.out.print("주소 >>> ");
		address = sc.nextLine().trim();
		
		System.out.print("생일 >>> ");
		birthday = sc.nextLine().trim();
		
		System.out.print("그룹 >>> ");
		group = sc.nextLine().trim();
		
		// 2. 인스턴스 생성
		Contact contact = new Contact(name, phoneNumber, email, address, birthday, group);
		
		// 3. 배열에 인스턴스의 참조값을 저장
		contacts[numOfContact++] = contact;
		
		System.out.println(numOfContact + "번째 데이터 저장이 완료 되었습니다.");
	}
	
	// 데이터 수정하기: 이름으로 검색하고 수정
	void editContact() {
		System.out.println("데이터 수정을 진행합니다.");
		System.out.print("수정하고자 하는 이름을 입력해주세요. >>> ");
		String name = sc.nextLine();
		
		// 수정하고자하는 index를 찾아야한다.
		int searchIndex = -1; // 초기값은 -1해야하는 이유는 0이면 값이 있는 것이기 때문에.
		
		// 데이터 찾기
		for(int i=0; i<numOfContact; i++) {
			if(contacts[i].getName().equals(name)) {
				searchIndex = i;
				break;
			}
		}
		
		if(searchIndex<0) {
			System.out.println("찾으시는 데이터가 존재하지 않습니다.");
			return;
		}
		
		// searchIndex를 찾았다면 해당 인덱스의 데이터를 contact 변수에 넣는다.
		Contact contact = contacts[searchIndex];
		
		// 이름 변경
		System.out.println("변경하고자 하는 이름을 입력해주세요. (현재값: "+ contact.getName() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newName = sc.nextLine();
		
		if(newName != null && newName.trim().length()>0) {
			contact.setName(newName);
		}
		
		// 전화번호 변경
		System.out.println("변경하고자 하는 전화번호를 입력해주세요. (현재값: "+ contact.getPhoneNumber() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newPhoneNumber = sc.nextLine();
		
		if(newPhoneNumber != null && newPhoneNumber.trim().length()>0) {
			contact.setPhoneNumber(newPhoneNumber);
		}
		
		// 이메일 변경
		System.out.println("변경하고자 하는 이메일을 입력해주세요. (현재값: "+ contact.getEmail() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newEmail = sc.nextLine();
		
		if(newEmail != null && newEmail.trim().length()>0) {
			contact.setEmail(newEmail);
		}
		
		// 주소 변경
		System.out.println("변경하고자 하는 주소를 입력해주세요. (현재값: "+ contact.getAddress() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newAddress = sc.nextLine();
		
		if(newAddress != null && newAddress.trim().length()>0) {
			contact.setAddress(newAddress);
		}
		
		// 생일 변경
		System.out.println("변경하고자 하는 생일을 입력해주세요. (현재값: "+ contact.getBirthday() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newBirthday = sc.nextLine();
		
		if(newBirthday != null && newBirthday.trim().length()>0) {
			contact.setBirthday(newBirthday);
		}
		
		// 그룹 변경
		System.out.println("변경하고자 하는 그룹을 입력해주세요. (현재값: "+ contact.getGroup() + ")\n 변경하지 않으려면 엔터를 치세요.");
		String newGroup = sc.nextLine();
		
		if(newGroup != null && newGroup.trim().length()>0) {
			contact.setGroup(newGroup);
		}
		
		System.out.println("데이터가 수정되었습니다.");
		contact.printInfo();
		
	}
	
	// 데이터 조회: 이름으로 검색하여 출력
	void searchInfoPrint() {
		// 1. 사용자에게 검색할 키워드(이름)을 입력받는다.
		// 2. 배열에서 이름ㅇ르 검색한다.
		// 3. 검색 결과 출력한다. 있는 경우와 없는 경우
		
		String name = null;
		
		System.out.println("데이터 검색을 진행합니다.");
		System.out.print("검색할 이름을 입력해주세요. >>> ");
		name = sc.nextLine();
		
		Contact contact = null;
		
		// 배열에서 해당 이름을 가지는 인스턴스의 데이터 출력 메소드 실행
		for(int i=0; i<numOfContact; i++) {
			// 각 요소이 참조변수로 객체를 참조해서 이름을 비교
			if(contacts[i].getName().equals(name.trim())) {
				contact = contacts[i];
				break; // 찾았으니 for문 탈출한다.
			}
		}
		
		// 검색 결과 유무에 따라 분기를 해 준다.
		System.out.println("===== 검색 결과 =====");
		if(contact == null) {
			System.out.println("검색한 이름 " + name + "의 정보가 없습니다.");
		}else {
			contact.printInfo();
		}	
	}
	
	// 데이터 삭제: 이름으로 검색하여 삭제
	void deleteContact() {
		System.out.println("데이터 삭제가 진행됩니다.");
		System.out.print("삭제 데이터의 이름을 입력주세요. >>> ");
		String name = sc.nextLine();
		
		// 삭제하고자하는 index를 찾아야 한다.-> 이후에 시프트하기
		int searchIndex = -1;
		
		// 데이터 찾기
		for(int i=0; i<numOfContact; i++) {
			if(contacts[i].getName().equals(name.trim())) {
				searchIndex = i;
				break;
			}
		}
		
		// 검색한 searchIndex값으로 분기하기: 시프트를 하거나 검색 결과 이름이 존재하지 않는다.
		if(searchIndex < 0) {
			System.out.println("입력하신 이름의 데이터가 존재하지 않습니다.");
		}else {
			for(int i=searchIndex; i<numOfContact-1; i++) {
				contacts[i] = contacts[i+1];
			}
			numOfContact--; // 시트트를 했으므로 하나 감소되도록 한다.
			System.out.println("데이터가 삭제되었습니다.");
		}
	}
	
}






























