package ver02;

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
	
	private Contact[] contacts; // 배열 변수 선언
								// 초기화 안 했으므로 null이 들어감.
								// 생성자에서 초기화할 것! 외부에서 보여질 이유가 없으니 private
	private int numOfContact; // 입력된 정보의 개수를 받는 변수, 배열의 index 값으로 사용
	Scanner sc; // 스캐너 여기서는 선언만!!!!
	
	// 생성자
	// 싱글톤 조건 private
	private SmartPhone(int size){
		contacts = new Contact[size]; // 초기화
		numOfContact = 0;
		sc = new Scanner(System.in); // 스캐너 여기서 초기화
	}
	
	// 싱글톤 조건: 인스턴스 생성 시 private static
	private static SmartPhone sp = new SmartPhone(10);
	
	// 싱글톤 조건: 반환 메소드에 private public static
	public static SmartPhone getInstance() {
		if(sp==null) {
			sp = new SmartPhone(10);
		}
		return sp;
	}
	
	// ② 배열에 인스턴스를 저장하고, (save)
	//				수정하고, (modify)
	//				삭제, (delete)
	// 				검색 후 결과 출력, (search)
	//				저장된 데이터의 리스트를 출력 (print)하는 메소드를 정의합니다.

	//		검색 후 결과 출력, (search) 이름으로검색
	void searchInfoPrint() {
		// 1. 사용자에게 검색할 키워드(이름) 입력 받는다.
		// 2. 배열에서 이름 검색
		// 3. 결과 출력: "검색한 이름은 데이터 출력" or "검색한 이름의 정보가 없습니다."
	
		
		
	}
	
	// 전체 입력 데이터의 출력
	void printAllData() {
		// 배열에 저장된 데이터를 모두 출력
		for(int i=0;i<numOfContact;i++) {
			contacts[i].printInfo();
		}
	}
	
	
	void insertContact() {
		// 배열에 인스턴스를 저장하고, (1~3항목)
		// 1. 데이터 받고,
		// 2. 인스턴스 생성하고,
		// 3. 배열에 인스턴스의 참조값을 저장
		
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		String phoneNumber = null;
		String email = null;
		String address = null;
		String birthday = null;
		String group = null;
		
		// 1. 데이터 받고
		System.out.println("입력을 시작합니다.");
		System.out.print("이름 >");
		name = sc.nextLine();
		
		System.out.print("전화번호 >");
		phoneNumber = sc.nextLine();
		
		System.out.print("이메일 >");
		email = sc.nextLine();
		
		System.out.print("주소 >");
		address = sc.nextLine();
		
		System.out.print("생일 >");
		birthday = sc.nextLine();
		
		System.out.print("그룹 >");
		group = sc.nextLine();
		
		// 2. 인스턴스 생성
		Contact contact = new Contact(name, phoneNumber, email, address, birthday, group);
				
		
		// 3. 배열에 저장	
		// 처음 입력: numOfContact => 0
		contacts[numOfContact++] = contact;
				
		
	}
	
}




















