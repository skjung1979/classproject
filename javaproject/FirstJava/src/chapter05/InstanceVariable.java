package chapter05;

public class InstanceVariable {
	
	// 인스턴스 변수는 인스턴스 생성시에 생성되어 인스턴스 소멸할 때까지의 생명주기를 갖는다.
	// 인스턴스 변수는 클래스 멤버(변수, 메소드)들이 참조 가능하다.
	int iv;	// 인스턴스 변수는 자동 초기화
	int iv2 = iv;
	
	void InstanceMethod(int num)
	{
		System.out.println(iv);
		// 참조변수, 변수
	}
	
	void InstanceMethod2(int num)
	{
		System.out.println(iv);
		// 참조변수, 변수
	}
	
	public static void main(String[] args)
	{
		InstanceVariable iv = new InstanceVariable();
		System.out.println(iv.iv);
		
		iv = null;
		
		System.out.println(iv.iv); 	// 실행하면 에러남. iv가 null인데 출력했으므로!!!(★주의★)
		
	}


}
