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
	private Contact[] contacts; 
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
	
	// 데이터 수정 (이름 검색)
	
	// 검색 출력 (이름 검색)
	
	// 삭제 (이름 검색)
	
	// 전체 데이터 출력
	
	
	
	
	
	
	
	
	
	
	
	
}



















