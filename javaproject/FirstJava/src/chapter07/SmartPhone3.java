package chapter07;

public class SmartPhone3 extends Phone {
	
	String model;
		
	// 생성자
	SmartPhone3(String phoneNumber, String model){
		
		super(phoneNumber); //상위 클래스의 생성자가 2개일 경우는 반드시 정의 해 준다.
		this.model = model;
	}
	
	// 오버라이딩
	// 상위 클래스에서 정의한메소드를 재 정의
	// 단, 선언부는 동일하게 정의하고 처리블록 내부의 코드만 재 정의
	@Override
	void call() {
		super.call();
		System.out.println("이어팟을 이용해서 통화합니다.");
		System.out.println("현재 사용중인 모델은: "+ model);
		// System.out.println("하위 클래스에서 재 정의");
	}
	
	// 새롭게 정의한 메소드
	void playMusic() {
		System.out.println("다이너마이트가 플레이됩니다.");
	}
	
	public static void main(String[] args) {
		
		// 다형성
		// 상속관계에 있는 클래스들 간에 인스턴스 생성과 참조변수 사이의 정의
		// 조상클래스 타입의 변수 = new 자손타입의 클래스()
		
		Phone phone = new SmartPhone3("010-0000-0000","IOS");
		Phone phone2 = new SmartPhone2("010-1111-1111","Android");
		Phone phone3 = new SmartPhone();
		// 조상 타입의 참조변수 선언은 조상 타입의 멤버만 사용하겠다를 정의한 것
		
		System.out.println(phone.phoneNumber);
		phone.call();
		// System.out.println(phone.model); 오류 발생
		
	}
}
