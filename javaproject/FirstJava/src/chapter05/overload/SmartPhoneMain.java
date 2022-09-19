package chapter05.overload;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		// SmartPhone 인스턴스 생성
		SmartPhone sp1 = new SmartPhone("Red", 4.7f, "삼성", 0); // 위치(순서)는 생성자의 타입 순서와 맞춰야 한다.
		
		sp1.volumeUp();
		sp1.showInfo();
		
		SmartPhone sp2 = new SmartPhone("검정", 3.7f, "애플", 7); // 위치(순서)는 생성자의 타입 순서와 맞춰야 한다.
		
		sp2.showInfo();
		
		SmartPhone sp3 = new SmartPhone(); // SmartPhone.java에서 SmartPhone() 생성자를 오버로딩 했기 때문에 정상 표기 됨.

		SmartPhone sp4 = new SmartPhone("애플애플", 50f);
		sp4.showInfo();
		
		SmartPhone sp5 = new SmartPhone("애플+삼성");
		sp5.showInfo();
		
	}

}
