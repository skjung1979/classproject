package chapter02;

public class VariableCharType {

	public static void main(String[] args) {
		
		// 문자 타입: char이라하며,
		// 유니코드 숫자를 저장: 보이는 것은 문자이지만, 실제 메모리 저장되는 것은 문자의 숫자값이 저장
	
		char ch1 = 'A';
		
		int codeNumber = ch1 + 0; // 유니코드 값을 알아내는 간단한 변수 선언 방법
		
		System.out.println(ch1 + ":" + codeNumber);
		
		char ch2 = 66;
		
		System.out.println(ch2);
		
		char ch3 = 51088;
		
		System.out.println(ch3);
		
	}
	
}
