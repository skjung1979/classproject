package chapter05.modifier;

public class PrivateTest {
	
	// private 같은 클래스에서는 접근 가능하나, 다른 클래스(파일)에서는 접근 불가
	private String name;
	private int age;
	
	// 생성자 자동생성: shift + alt + s
	public PrivateTest() {
		this.name = "손흥민";
		this.age = 30;
	}
	
	public void showInfo()
	{
		System.out.println("이름: "+ this.name);
		System.out.println("나이: "+ this.age);
	}
	
	

}
