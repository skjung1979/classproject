package chapter08;

public class OuterClass3 {

	private String name;
	
	OuterClass3(String name){
		this.name = name;
	}
	
	public BasicClass createLocalClassInstance() {
		
		// new 다음에 오는 타입이 익명 클래스: 이름없이 정의되는클래스
		// 여러번 사용하는 것이 아님. 한번 인스턴스 생성후 재 사용이 없는 경우
		// new 추상클래스(){추상메소드 구현}; 	< 요런 형식
		// new 인터페이스(){추상메소드 구현};	< 요런 형식
		return new BasicClass(){
			void tell() {
				System.out.println("안녕하세요. " + name + "입니다.");
			}
		};
		
	}
	
}
