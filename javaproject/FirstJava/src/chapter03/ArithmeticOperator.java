package chapter03;

public class ArithmeticOperator {

	public static void main(String[] args) {
		
		int num1 = 15;
		int num2 = 4;
		float num3 = 2.0f;
		
		System.out.println(num1+num2);
		System.out.println(num1-num2);
		System.out.println(num1*num2);
		System.out.println(num1/num2);
		System.out.println(num1/num3);
		System.out.println(num1%num2);
		System.out.println(num1%num3);
		
		int result = num1 / 0; // 0으로 나누면 에러남
		
	}
	
}
