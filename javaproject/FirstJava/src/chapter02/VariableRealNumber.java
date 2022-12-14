package chapter02;

public class VariableRealNumber {

	public static void main(String[] args) {
		
		// 실수 타입: double,    float
		//            8byte,     4byte
		// int 4byte, long 8byte
		
		//double 타입
		double num1 = 0.3; // num1 = double 타입의 데이터
		double num3 = 1.1234567891023456789; // 소수점15자리까지 제대로 표시됨
		
		System.out.println(num1);
		System.out.println(num3);
		
		// float 타입
		float num2 = 0.3f; // num2 = double타입의 데이터
		float num4 = 1.1234567891023456789f; // 소수점8자리까지 표시됨
		
		
		System.out.println(num2);
		System.out.println(num4);
		
		double num5 = 1.1;
		double num6 = 1.3;
		
		double result = num5 + num6;
		
		System.out.println(num5);
		System.out.println(num6);
		System.out.println(result);
		
	}
}
