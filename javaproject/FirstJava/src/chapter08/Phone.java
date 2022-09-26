package chapter08;

public abstract class Phone {

	String phoneNumber;
	boolean power; // false, 전원
	
	public Phone(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		this.power = false;
	}
	
	void call() {
		System.out.println("전화 걸기!!!");
	}
	
	// void turnOn() {}   이렇게도 가능하지만, 추후 작업이 누락되어도 감지 장치가 없음.
	abstract void turnOn(); // 그래서 이렇게 추상메소드로 정의해야 감지가 된다.!!!! 이렇게 해야 이 클래스를 상속받는 클래스에서 구현하라고 메세지가 뜬다.
	
}
