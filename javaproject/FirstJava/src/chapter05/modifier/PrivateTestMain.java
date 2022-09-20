package chapter05.modifier;

public class PrivateTestMain {

	public static void main(String[] args) {

		PrivateTest pt = new PrivateTest();
		
		
		// private 변수 이므로 아래처럼 직접 접근은 안됨.
//		System.out.println(pt.name);
//		System.out.println(pt.age);
//		pt.age = 300;
		
		//아래처럼 간접적으로 메소드를 통해 호출해야 한다.
		pt.showInfo();
		
	}

}
