package chapter07;

public class Phone {
	// 전화가 갖는 속성 정리
	// 전화번호 변수
	// 전화 걸기 메소드 등등

	// 변수 선언: 전화번호
	String phoneNumber;
	
	// 생성자 (기본)
	Phone(){
		this.phoneNumber = "010-1111-1111";
	}
	
	// 생성자 (타입지정)
	Phone(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	// 메소드 정의: 전화걸기
	void call() {
		System.out.println("전화를 걸기!!!");
	}
	
	
}
