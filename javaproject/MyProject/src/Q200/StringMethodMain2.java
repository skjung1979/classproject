package Q200;

public class StringMethodMain2 {

	public static void main(String[] args) {
		
		String b = "Hello, I love you.";
		
		// 1. 대문자로 변환
		String d = b.toUpperCase(); // 대문자로
		System.out.println(d);
		String e = b.toLowerCase(); // 소문자로
		System.out.println(e);
		
		// 2. 양쪽 공백 제거
		System.out.println("   안녕하세요~~   ".trim());
		
		// 3. String <--> int
		int istr = Integer.parseInt("37");
		String stri = String.valueOf(istr);
		String stri2 = istr + "";
		System.out.println(istr);
		System.out.println(stri);
		System.out.println(stri2);
		
		// 4. 대소문자 상관없이 비교하기
		System.out.println("hel".compareToIgnoreCase("Hello")); // 앞의 문자와 뒤 문자의 글자 수 비교, 앞글자 기준
		
		// 5. +와 같은 concatenation
		stri = stri.concat("hello");
		System.out.println(stri);
		
		// 6. 문자열 <-> char 배열
		char[] chs = b.toCharArray();
		String copys1 = String.copyValueOf(chs);
		String copps2 = new String(chs);
		for(char ch : chs) {
			System.out.printf("%c", ch);
		}
		System.out.println();
		// 문자를 포함하고 있는가?
		System.out.println("hello".contains("el"));

	}

}
