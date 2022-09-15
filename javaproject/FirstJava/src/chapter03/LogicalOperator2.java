package chapter03;

public class LogicalOperator2 {

	public static void main(String[] args) {

		int age = 15;
		
		// 청소년(13~19세 가정) 판별 코딩
		
		boolean chk = age >= 13 && age <= 19;
		
		System.out.println("청소년 판별: "+ chk);
		System.out.println('a' > 'b'); // 97 > 98 --> false
		
		// 소문자 판별
		char c = '#';
		boolean chk2 = c >= 'a' && c <= 'z';
		
		// 대문자 판별
		boolean chk3 = c >= 'A' && c <= 'Z';
		
		// 숫자 판별
		boolean chk4 = c >= '0' && c <= '9';
		
		System.out.println("c변수의 데이터가 소문자인지 판별: "+ chk2);
		
		// 대문자 또는 소문자 또는 숫자만 사용 가능한 경우  -> 사용자 아이디에 들어가지 않는 숫자들에 대한 조건을 걸어 제대로된 데이터를 입력 받도록 함.
		// 대문자 판별 || 소문자 판별 || 숫자 판별 하는 코딩
		boolean result = c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
		
		System.out.println("대문자 또는 소문자 또는 숫자만 사용: "+ result);
		
		
		

	}

}
