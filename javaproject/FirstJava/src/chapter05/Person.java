package chapter05;

public class Person
{

//	// 외부에서 변수의 값을 참조 시키는 기능: getter메소드
//	public String getName() {
//		return name;
//	}
//
//	// 외부에서 변수의 값을 설정(입력): setter메소드
//	public void getName(String name) {
//		this.name = name;
//	}
	
	private String name;
	private int age;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}

	// 자동 생성 한 것
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	} // 데이타 확인 용도?? 어떻게 들어가 있는지..
	
	public static void main(String[] args) {
		
		Person p = new Person();
		
		// 참조변수는 주소값을저장하고 있다.
		System.out.println(p);	// 주소값 출력?? 아니다.
								// 이미 정의되어 있는 toString()을 부른다...
		
	}
}




























