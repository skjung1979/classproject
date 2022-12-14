package chapter02;

public class VariableTest {
	
	// 클래스의 시작 main메소드
	public static void main(String[] args) {
		
		// 자료형 변수이름 = 데이터;  <- 일반적인 변수 선언과 초기화(최초값) 입력 형식
		int num = 1000;
		// 숫자 1000을 저장하기 위한 메모리 공간 생성, 저장 공간을 찾아가는 주소를 갖는 이름 num
		// 이것이 변수 선언과 초기화이다.
		
		// 숫자
		// -> 정수: byte, short, int, long
		// -> 실수: float, double
		// 문자: char
		// 논리값: boolean
		// 문자열(참조형): String
		//
		
		int num1 = 100; // 자료형의 기본값 > byte나 short 사용 상황이어도 int를 사용한다.
		byte num2 = 100;
		short num3 = 100;
		long num4 = 100;
		// -> 결과는 모두 값지만 메모리 점유 차이는 다르다.
		
		float num5 = 0.5f; // 0.5 -> 리터럴
		double num6 = 0.5;
		
		boolean check = true; // true or false
		
		String str = null; // 문자열에 대한 초기값은 null이다.
		str = "String";
		
	}

}
