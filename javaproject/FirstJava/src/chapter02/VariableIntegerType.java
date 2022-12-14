package chapter02;

public class VariableIntegerType {

	public static void main(String[] args) {
		
		// 정수: byte   short   int(기본타입)  long
		// 		1byte   2byte   4byte          8byte
		
		int num = 100;
		
		byte byteNum1 = 10;
		byte byteNum2 = 127;
		// byte byteNum3 = 128; 'Type mismatch: cannot convert from int to byte.' 에러가 뜨므로 아래같이
		byte byteNum3 = (byte)200; // 형변환 시켜 준다.
		
		System.out.println(byteNum1);
		System.out.println(byteNum2);
		System.out.println(byteNum3);
		
		// int longNum1 = 2200000000; 에러나므로 아래 같이 long타입으로 할 것
		long longNum1 = 2200000000L; // 데이터 뒤에 long이라는 표시를 해줘야 한다.
		
		int num1 = 100000;
		int num2 = 100000;
		
		// 곱하기 연산
		int resultInt = num1 * num2;
		long resultLong = (long)num1 * num2; // long * long
		
		System.out.println(resultInt); // 형변환 하지 않았을때 왜곡됨 > 1410065408
		System.out.println(resultLong); // 정상적으로 형변환 했을때 맞게 출력됨 > 10000000000
		
		double a = 1.5;
		double b = 1.3;
		
		double c = a + b;
		
		System.out.println(c);
		
	}
}
