package chapter05;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		// 인스턴스는 생성할때마다 개별(독립)적인 메모리공간이 생성
		// 클래스 내부에서 정의한 변수들도 인스턴스 생성과 동시에 생성된다. 같은걸 공유X
		// 참조변수는 주소값만 가지는 것이다.(★숙지★)
		
		SmartPhone sp1 = new SmartPhone();
		SmartPhone sp2 = new SmartPhone();
		
		// 참조변수의 주소값 비교
		System.out.println("sp1 주소 == sp2 주소: " + (sp1==sp2));
		System.out.println(sp1.hashCode());
		System.out.println(sp2.hashCode());
		System.out.println();
		
		sp1.showInfo();
		sp2.showInfo();
		
		// 각 인스턴스의 속성값 적용
		sp1.company = "APPLE";
		sp1.color = "Red";
		sp1.size = 5.0f;
		sp1.volumeUp();
		sp1.volumeUp();
		
		sp2.company = "Samsung";
		sp2.color = "Black";
		sp2.size = 4.7f;
		sp2.volumeUp();
		sp2.volumeUp();
		sp2.volumeUp();
		sp2.volumeUp();
		
		System.out.println("각 인스턴스 설정 후 데이터출력");
		sp1.showInfo();
		sp2.showInfo();
		
		// sp2에 sp1을 할당한다.
		
		sp2 = sp1;	// 매개변수: 메소드에서 정의
					// int num1, int num2
					// SamrtPhone sp
					// sp2의 참조값이 바뀌어서 기존 데이터와의 관계가 끊기고 sp1의 데이터와 연결됨. 
		
		System.out.println();
		sp1.showInfo();
		sp2.showInfo();
		
		showPhoneInfo(sp1);	// SmartPhone 인스턴스를 가르키는 주소값 전달해주어야 한다.
		

	}
	public static void showPhoneInfo(SmartPhone sp)
	{
		// SmartPhone sp = 0x100;
		
		System.out.println("매개변수를 참조변수로 정의해서 메소드 내부에서 객체 참조!!!★숙지★");
		sp.showInfo();	//	메소드 생성시 괄호(SamrtPhone sp)안에서 정의했기 때문에 호출 가능하다.
	}
	
	
	

}















