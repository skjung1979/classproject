package chapter03;

public class RelationalOperator
{

	public static void main(String[] args)
	{

		// 관계연산자 (비교연산자)
		// > < >= <= == !=
		
		int num1 = 30;
		int num2 = 200;
		
		System.out.println(num1 > num2); // true
		System.out.println(num1 < num2); // false
		System.out.println(num1 >= num2); // true
		System.out.println(num1 <= num2); // false
		System.out.println(num1 == num2); // false
		System.out.println(num1 != num2); // true
		
		if(num1 > num2)
		{
			// 참일 때 처리되는 블럭
			System.out.println("num1이 num2보다 큽니다.");
		}else
		{
			// 거짓일 때 처리되는 블럭
			System.out.println("num1이 num2보다 작거나 같습니다.");
		}
	}
}
