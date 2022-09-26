package chapter08;

public class AbstractClassMain {

	public static void main(String[] args) {

		// 추상클래스는 인스턴스 생성에 목적이 없다!
		// 즉, 인스턴스 생성을 하면 문제가 된다!!!
		AbstractClass abstractClass; // 변수 선언부에는 문제가 없다(=>다형성은 가능하다)
		// = new AbstractClass();		 하지만 인스턴스 생성은 불가!
		
		NewClass newClass = new NewClass();
		newClass.abstractMethod();
		
		abstractClass = newClass; // 다형성
		
		abstractClass.abstractMethod();
		
		newClass.name = "정성균";
		newClass.num = 77777;
		newClass.printData();
	}

}
