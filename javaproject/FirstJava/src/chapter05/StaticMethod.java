package chapter05;

public class StaticMethod
{
	
	static int num1 = 10;	// 클래스 변수
	int num2;	// 인스턴스 변수
	
	static void staticMethod()
	{
		System.out.println("staticMethod");
		// System.out.println(num2);	// static이라고 선언된 메소드안에서 num2는 static 변수가 아니라서.
		// 클래스 멤버 메소드안에서 인스턴스 멤버(변수,메소드)는 사용 불가!!!
			
		// 메소드의 경우 사용하려면 아래같이 생성을 해줘야 한다.		
		StaticMethod sm = new StaticMethod();
		sm.instanceMethod();
				
	}
	
	void instanceMethod()
	{
		System.out.println("instanceMethod");
		System.out.println(num1);	// static 변수는 어디서나 호출 가능
		staticMethod();	// static메소드는 어디서나 호출 가능
	}

}
