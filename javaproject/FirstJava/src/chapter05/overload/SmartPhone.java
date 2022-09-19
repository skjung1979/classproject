package chapter05.overload;

// 실행 목적이 아니므로 main메소드 필요 없다.
// 클래스는 인스턴스를 생성하기위한 설계도 역할을 하는 것이다.
// 클래스에서 정의한 변수, 메소드는 바로 사용이 불가하며,
// 클래스로 인스턴스를 만들어서 사용한다.!!!
// class 정의는 class 키워드를 사용해서 정의한다.

// public이 없어도 되지만, 파일명과 같은 클래스에만 public을 붙일수 있다.(★숙지★)
public class SmartPhone
{
	// 클래스는 변수와 메소드로 구성한다. (변수와 메소드는 필수는 아니다)
	// 생성자: 필수이지만 생략 가능하다.
	
	// 클래스의 멤버: 변수, 메소드
	// 클래스 내부에 정의된 변수: 멤버 변수 or 인스턴스 변수(인스턴스가 만들어져야 사용가능하기때문) 라고함.
	// 클래스 내부에 정의된 메소드: 멤버 메소드 or 인스턴스 메소드  라고함.
	
	// 스마트 폰의 속성: 컬러, 크기(인치 or cm), 제조사, 볼륨 사이즈
	// 속성 -> 변수
	
	String color;	// 변수명의 색깔이 파랑색인 것은 인스턴스 변수이다.
				 	// 같은 이름으로는 선언이 불가하다.
					// 초기화 생략 가능 => 인스턴스 생성시에 타입별 기본 초기값(0, 0.0, false등)으로 할당.
						// 보통은 생략하는 것이다.
	float size;
	String company;
	int volumeSize;
	
	// 생성자(보통 이 위치에 생성자를 선언한다.): 인스턴스 생성시에 단 한번 실행하는 초기화 메소드(★숙지★)
		// 형식 -> 
		// 클래스이름(매개변수1, 매개변수2...){
		// 초기화 코드
		// }
	
	
	// 생성자 1(디폴트 생성자): 매개변수에 해당 하는 변수를 초기화하는 것이다.
	// 매개변수에 포함되지 않는 변수는 정의하지 않으면 기본 초기값을 갖게 되므로,, 정의 해 주는 것이 좋다.(★숙지★)
	SmartPhone(){
		// 매개변수 없고, 처리 내용도 없는 생성자 => 기본생성자이며, 생략가능하다(어차피 자동 생성됨)(★숙지★)
	}
	
	// 생성자 2: 매개변수에 해당 하는 변수를 초기화하는 것이다.
	// 매개변수에 포함되지 않는 변수는 정의하지 않으면 기본 초기값을 갖게 되므로,, 정의 해 주는 것이 좋다.(★숙지★)
	// 생성자의 오버로딩: 같은 이름의 생성자를 정의해 주는 것
	SmartPhone(String color, float size, String company, int volumeSize){
		// 인스턴스를 생성하면 this 참조변수도 생성
		// this는 현재 인스턴스 자신의 주소값을 가지는 변수
		this.color = color;
		this.size = size;
		this.company = company;
		this.volumeSize = volumeSize;
	}
	
	// 생성자 3: 매개변수에 해당 하는 변수를 초기화하는 것이다.
	// 매개변수에 포함되지 않는 변수는 정의하지 않으면 기본 초기값을 갖게 되므로,, 정의 해 주는 것이 좋다.(★숙지★)
	SmartPhone(String company, float size)
	{
//		this.company = compnay;
//		this.size = size;
//		this.color = "검정-생성자에서 픽스된 값";
//		this.volumeSize = 10;	// 생성자에서 픽스된 값
		
		this("검정", size, company, 10);	// 위 4줄을 간단히 표현
	}
	
	// 생성자 4: 매개변수에 해당 하는 변수를 초기화하는 것이다.
	// 매개변수에 포함되지 않는 변수는 정의하지 않으면 기본 초기값을 갖게 되므로,, 정의 해 주는 것이 좋다.(★숙지★)
	SmartPhone(String company){
//		this.company = company;
//		this.size = 5.3f;	// 생성자에서 픽스된 값
//		this.color = "검정-생성자에서 픽스된 값";
//		this.volumeSize = 10;	// 생성자에서 픽스된 값
		
		this("검정", 4f, company, 10);	// 위 4줄을 간단히 표현
	}
		
	
	// == 기능 ==
	// 전화 걸기
	void call()
	{
		System.out.println("전화 걸기~");
	}
	
	// 볼륨 키우기
	void volumeUp()
	{
		System.out.println("볼륨을 키웁니다~");
		volumeSize++;
	}
	
	// 볼륨 낮추기
	void volumeDown()
	{
		System.out.println("볼륨을 낮춥니다~");
		volumeSize--;	// 같은 클래스에 있어서 volumeSize 변수 접근이 가능하다.(★숙지★)
	}
	
	// 속성 정보 보여주기
	void showInfo()
	{
		// String color = "";	// 이렇게 선언도 가능.
								// 이것은 힙영역에 저장되는 변수 위에 것은 static영역에 저장되는 변수
		System.out.println("폰 정보 입니다.");
		System.out.println("제조사: " + company);
		System.out.println("색상: " + this.color); // this.color라고하면 위의 color(인스턴스 메소드의)를 호출한다.
		System.out.println("사이즈: " + size);
		System.out.println("현재 볼륨: " + volumeSize);
		
	}
//	void showPhoneInfo(SmartPhone sp)
//	{
//		sp.showInfo();
//	}
//	
	

}
