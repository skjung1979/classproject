package chapter08;

public abstract class AbstractClass {
	
	// 추상클래스: 멤버 중 추상메소드가 하나라도 존재하면 추상클래스가 된다.
	// abstract 키워드로 추상클래스임을 정의 해 준다.
	// 추상클래스는 미완성된 클래스 이므로 인스턴스 생성이 불가!
	// 추상클래스의 정의 목적은 상속을 통해 미완성된 메소드를 완성해서 새로운 클래스를 정의하는데 도움을 주는 것이다.
	
	
	int num;
	String name;
	
	void printData() {
		System.out.println(num + " , " + name);
	}
	
	// 추상메소드: 메소드의 정의만 하고 처리부는 완성하지 않은 메소드
	abstract void abstractMethod();
	
	// 위 추상메소드가 상속받은 다른 클래스에서 오버라이딩 되어야 아래 인스턴스 메소드도 사용 가능
	void instanceMethod() {
		abstractMethod();
	}

}
