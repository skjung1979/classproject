package chapter02;

public class Member {
	
	public static void main(String[] args) {
		// class 파일의 실행 포인트
		
		printMyName("정성균");
		printMyName("sonny");
		
	}
	
	// 자기 자신의 이름을 출력하는 메소드
	// 반환타입: 없다면 -> void (메소드 안에서 바로 결과가 도출되는 경우)
	// 매개변수: 없다.
	// 처리내용: 자신의 이름을 출력한다.
	
	//아래 메소드 앞에 public static을 입력해야 메인메소드에서 호출이 가능하다.
	public static void printMyName(String name) {
				
		System.out.println("안녕하세요." + name + "입니다.");
		
		// 반환타입이 있다면 'return 변수명'을 기술한다.
		
	}
	
	
}
