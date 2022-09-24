package chapter07;

public class SmartPhone extends Phone {
	
	// 하위 클래스: (기존)상위 클래스 멤버 + 새로운 멤버 정의
	String model;
	
	// 디폴트 생성자
	SmartPhone(){
		super("010-2222-2222"); // 상위 클래스의 생성자 선언 및 초기화?
		this.model = "IOS";
	}
	
	// 전화번호만 초기화하는 생성자
	SmartPhone(String phoneNumber){
		super(phoneNumber);
		this.model = "Android";
	}
	
	SmartPhone(String phoneNumber, String model){
		super(phoneNumber);
		this.model = model;
		
	}
	
	void play() {
		System.out.println("app을 실행합니다.");
	}
	
	public static void main(String[] args) {
		
		// SmartPhone sp = new SmartPhone(); // 인스턴스 생성
		// SmartPhone sp = new SmartPhone("010-3333-4444");
		SmartPhone sp = new SmartPhone("010-4444-5555", "Google");
		
		System.out.println(sp.phoneNumber);
		sp.call();
		System.out.println(sp.model);
		sp.play();
		
	}

}
