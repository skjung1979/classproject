package chapter09;

public class StringBufferTest {

	public static void main(String[] args) {

		// StringBuffer, StringBuilder 
		// ==> 변수, 생성자, 메소드 모두 같다!!
		
		StringBuffer sb = new StringBuffer("Hello"); // 6+16개의 저장공간 만든다.
			
		System.out.println(sb);
			
		// 문자열 붙이기
		sb.append('~');
		sb.append(false);
		
		System.out.println(sb);
		
		// 특정 문자열 삭제
		System.out.println(sb.delete(0, 1));

		// 특정위치에 문자열 삽입
		System.out.println(sb.insert(6, "~"));
		System.out.println(sb.insert(sb.length(), true));
		
		System.out.println();
		System.out.println(sb.reverse());
		
	}

}
