package chapter08.phone;

public interface Phone {
	
	// 폰이 가지는 다이얼 숫자를 상수로 표현 하고자 한다.
	int PHONE_NUM_1 = 1;	// public static final 생략
	int PHONE_NUM_2 = 2;
	int PHONE_NUM_3 = 3;
	int PHONE_NUM_4 = 4;
	int PHONE_NUM_5 = 5;
	int PHONE_NUM_6 = 6;
	int PHONE_NUM_7 = 7;
	int PHONE_NUM_8 = 8;
	int PHONE_NUM_9 = 9;
	int PHONE_NUM_0 = 0;
	
	// 메소드는 추상 메소드로 정의
	// 전화 걸기
	void call();	// public abstract 생략
	
	// 전원 켜기
	void turnOn();
	
	// 전원 끄기
	void turnOff();

}
