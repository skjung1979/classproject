package chapter08;

public class OuterClass extends Object {

	
	// 아우터 클래스의 멤버(변수,생성자,메소드) 구성
	private String name;
	private int num;
	
	public OuterClass(String name) {
		super();
		this.name = name;
		this.num = 0;
	}
	
	public void tellYourName() {
		System.out.println("OuterClass Name: "+ this.name+" - "+num++);
	}

	// 내부 클래스: 클래스의 블럭 내부에 다른 클래스를 정의
	// 목적: 캡슐화(클래스를 외부에 노출하지 않아아할 때
	// 주로 이벤트 클래스(클릭, 터치, 드래그 등)들이 내부클래스로 구성되어 있다.
	class InnerClass{
		
		InnerClass(){
			tellYourName();	//아우터의 메소드 바로 호출 가능
		}
		
	}
	
	public static void main(String[] args) {
		
		// 내부클래스의 인스턴스 생성은 외부 클래스의 인스턴스 생성 후 생성이 가능하다.
		OuterClass out1 = new OuterClass("King");
		OuterClass out2 = new OuterClass("Scott");
		
		// out1.tellYourName();
		// out2.tellYourName();
		
		// 내부 클래스 변수 선언과 인스턴스 생성
		OuterClass.InnerClass in1 = out1.new InnerClass();
		OuterClass.InnerClass in2 = out2.new InnerClass();
		
		OuterClass.InnerClass in3 = out1.new InnerClass();
		OuterClass.InnerClass in4 = out2.new InnerClass();
		
		OuterClass.InnerClass in5 = out1.new InnerClass();
		
	}

}














