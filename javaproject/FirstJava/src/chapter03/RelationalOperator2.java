package chapter03;

public class RelationalOperator2
{

	public static void main(String[] args)
	{

		// 관계연산자 (비교연산자)
		// > < >= <= == !=
	
		
		// 참조변수: 주소값을 가지는 변수
		// 주소: 객체를 가르키는 주소값
		// 크다 작다 비교는 하지 않는다.
		// 같은 주소를 가지는지 확인하는 연산이 주로 사용된다.
		
		String str1 = "JAVA"; // str1 변수에는 데이터 값이 저장된 주소값이 저장된다. <=> 객체를 가르키는 주소가 들어간다.
		String str2 = "HTML";
		String str3 = "JAVA";
		
		System.out.println(str1 == str2); // 두 변수의 주소값을 비교하는 것이다!!! 데이터의 내용을 비교하는 것이 아니고!!!
		System.out.println(str1 != str2);
		
		System.out.println("str1 == str3 => " + (str1 == str3));
		
		// System.out.println(str1 > str2); // <-- 오류 발생하여 아예 실행이 안된다.
		
	}
}
