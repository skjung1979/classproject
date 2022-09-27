package chapter09;

public class StringTest {

	public static void main(String[] args) {
		
		// 문자열을 다루는 String
		String str1 = "String";
		String str2 = "String";
		String str3 = new String("String");
				
		System.out.println("str1 == str2 => "+ (str1 == str2)); // 결과: True
		System.out.println("str1 == str3 => "+ (str1 == str3)); // 결과: False
		
		System.out.println(str1.equals(str3)); // 결과: True
		
		// 특정 타입의 데이터 -> 문자열 String 타입으로 변경
		String str4 = "" + 1;
		String str5 = String.valueOf(false);
		String str6 = new String();
		System.out.println(str5);
		
		///////////////////////////
		
		String str = "Hello~";
		System.out.println(str.toString());
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(5));
		
		// 문자열을 역순으로 출력해보자
		System.out.println("문자열 출력 ------ ");
		for(int i=0; i<str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		System.out.println();
		
		System.out.println("역순 출력 ------ ");
		for(int i=str.length()-1;i>=0;i--) {
			System.out.println(str.charAt(i));
		}
						
		// 문자열의 합
		System.out.println(str.concat(str1));
		
		System.out.println();
		// 포함 확인
		System.out.println("특정문자 포함여부: " + str.contains("He"));
		
		System.out.println();
		// 시작 문자, 끝나는 문자 확인
		System.out.println(str.startsWith("He"));
		System.out.println(str.endsWith(".pdf"));
		
		System.out.println();
		System.out.println(str.equals("top"));
		System.out.println(str.equals("Hello~"));
		
		System.out.println();
		System.out.println(str.indexOf("l"));	// 앞에서부터 l의 인덱스를 찾는다.
		System.out.println(str.lastIndexOf("l"));	// 뒤에서부터 l의 인덱스를 찾는다.
		
		System.out.println(str.indexOf("ll"));
		
		System.out.println();
		System.out.println(str.isEmpty());
		System.out.println("".isEmpty());
		System.out.println(" ".isEmpty());
		System.out.println(" ".trim().isEmpty());
		
		System.out.println(str.length());
		System.out.println(str.length()==0);
		
		System.out.println();
		// 문자열 치환
		System.out.println(str.replace("~", "!"));
		System.out.println(str);
		
		
		
		
		
	}
	
}




















