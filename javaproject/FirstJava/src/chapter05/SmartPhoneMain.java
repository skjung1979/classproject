package chapter05;

public class SmartPhoneMain {

	// 메인메소드는 프로그램의 시작 포인트이다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 참조변수 선언: 인스턴스의 메모리 주소값을 저장(★숙지★)
		SmartPhone sp = null;
		
		// 인스턴스 생성: 클래스에서 정의한 변수와 메소드를 사용할 수 있는 상태로 만드는 것
		// 인스턴스화 -> 변수와 메소드를 메모리에 로드한다.
		sp = new SmartPhone(); // 인스턴스 메모리를 생성하고, 주소값을 반환
		
		// 인스턴스 변수 참조 방법(양식): 참조변수.인스턴스변수이름
		System.out.println("스마트폰 제조사: " + sp.company);
		System.out.println("스마트폰의 색상: " + sp.color);
		System.out.println("스마트폰의 크기: " + sp.size);
		System.out.println("스마트폰 볼륨크기: " + sp.volumeSize);
		
		// 인스턴스 변수 할당
		sp.company = "Apple";
		sp.color = "Red";
		sp.size = 4.7f;
		sp.volumeSize = 7;
		
		System.out.println();
		System.out.println("-----인스턴스의 변수 값 할당 후-----");
//		System.out.println("스마트폰 제조사: " + sp.company);
//		System.out.println("스마트폰의 색상: " + sp.color);
//		System.out.println("스마트폰의 크기: " + sp.size);
//		System.out.println("스마트폰 볼륨크기: " + sp.volumeSize);
		
		// 인스턴스의 메소드 호출(양식): 참조변수.메소드이름();
		
		sp.showInfo();	
		
		// sp = null;	// 더이상 안 쓸 경우 생략가능.. 가상머신에서 알아서 정리함.
		
		// 간략한 객체 지향의 흐름: 클래스 정의 -> 인스턴스 생성 -> 참조변수 사용(★숙지★)
		System.out.println();
		// 볼륨 조정: 키우기
		sp.volumeUp();
		System.out.println("현재 볼륨: "+ sp.volumeSize);
		
		System.out.println();
		// 볼륨 조정: 출이기
		sp.volumeDown();
		sp.volumeDown();
		System.out.println("현재 볼륨: "+ sp.volumeSize);
		
	}

}
