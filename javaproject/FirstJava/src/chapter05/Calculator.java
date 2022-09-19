package chapter05;

// 기능만 제공하는클래스: 사칙연산
// 여기스 인스턴스 정의가 진행된다.
public class Calculator {
	
	long add(long num1, long num2)
	{
		return num1+num2;
	}
	
	// 메소드 오버로딩: 같은 이름의 메소드를 정의하는 것
	// 조건: 매개변수의 타입이 다르거나 매개변수의 개수가 다를 때 가능!!
	// 메소드의 구분은 메소드 호출시에 정의되는 매개변수 인가 값에 따라서 메소드가 선택되기 때문에!
	// ex) 메소드이름(값, 값, 값);
	
	float add(float num1, float num2)
	{
		return num1 + num2;
	}
	
	int add(int num1, int num2)
	{
		return num1 + num2;
	}
	
	long add(int num1, long num2)
	{
		return num1 + num2;
	}
	
	long add(long num1, int num2)
	{
		return num1 + num2;
	}
	
//	불가함
//	void add(int num1, int num2)
//	{
//		System.out.println(num1+num2);
//	}
	
	long multyfly(int num1, int num2)
	{
		return num1*num2;
	}

}
