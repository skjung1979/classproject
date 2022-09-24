package chapter07;

public class SmartPhone2 extends Phone {
	
	String model;
		
	// 생성자
	SmartPhone2(String phoneNumber, String model){
		
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
		// System.out.println("하위 클래스에서 재 정의");
	}
	
	public static void main(String[] args) {
		
		SmartPhone2 phone2 = new SmartPhone2("010-0000-0000","삼성");
		
		// call()호출
		phone2.call();	
	}
}
