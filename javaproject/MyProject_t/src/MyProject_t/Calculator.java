package MyProject_t;

public class Calculator {
	
	public static void main(String[] args) {
		
		plusResultPrint(21.88,10);
		subResultPrint(20.88,10);
		mulResultPrint(20.88,10);
		divResultPrint(20.88,10);
				
	}
	
	// 숫자 2개, 더하기 메소드
	public static void plusResultPrint(double num1, double num2) {
		
		double sum = num1 + num2;
		
		System.out.println(sum);
		
	}
	
	// 숫자 2개, 빼기 메소드
	public static void subResultPrint(double num1, double num2) {
		
		double sum = (double)(num1*100 - num2*100)/100.0;
		// 위 코딩은 소수점의 개수를 체킹하는 로직이 필요하다...
		
		System.out.println(sum);
	}
	
	// 숫자 2개, 곱하기 메소드
	public static void mulResultPrint(double num1, double num2) {
		
		double sum = num1 * num2;
		
		System.out.println(sum);
	}
	
	// 숫자 2개, 나누기 메소드
	public static void divResultPrint(double num1, double num2) {
		
		double sum = num1 / num2;
		
		System.out.println(sum);
	}

}
