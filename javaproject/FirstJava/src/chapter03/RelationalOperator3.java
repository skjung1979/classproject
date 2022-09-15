package chapter03;

public class RelationalOperator3
{

	public static void main(String[] args)
	{

		// 관계연산자 (비교연산자)
		// > < >= <= == !=
		
		// 관계연산도 자료형을 일치 시켜놓고 연산이 이루어진다.
		
		char c = 'A'; // 65
		int num = 10;
		
		int codeNum = c + num; // 65 + 10
		System.out.println(codeNum);
		
		System.out.println(c > num); // 큰 범위 변수로 자동 형현환 된다.
		System.out.println('1' > '0');
		System.out.println(num == 10f); // int == float --> float == float (지동 형변환)
		
	}
}
