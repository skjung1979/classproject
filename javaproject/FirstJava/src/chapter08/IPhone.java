package chapter08;

public class IPhone extends Phone {

	// 추상클래스의 생성자는 상속되지 않으므로
	public IPhone(String phoneNumber) {
		super(phoneNumber);
	}
	
	@Override
	void turnOn() {

		System.out.println("아이폰의 전원을 켭니다.");
		power = true;
	}

}
