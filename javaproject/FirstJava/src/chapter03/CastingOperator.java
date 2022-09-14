package chapter03;

public class CastingOperator {

	public static void main(String[] args) {
		
		byte num1 = 10;
		byte num2 = 20;
		
		// 기본형 / 참조형
		// 기본형
		// 숫자, 문자, 논리값
		// 정수, 실수, 문자, 논리값
		
		
		// byte result = num1 + num2; <오류 수정 전>
		// 연산식에서는 byte + byte -> int + int 로 변한다.
		// 결과를 담는 변수 자료형을 늘리거나, 연산식에서의 기존 변수를 축소 형변환 시켜 준다.
		byte result2 = (byte)(num1 + num2); // <오류 수정 후>
		
		
	}
	
}
