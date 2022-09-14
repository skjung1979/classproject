package chapter02;

public class VariableCastingOperator {

	public static void main(String[] args) {
		
		//
		char c1 = 'a';
		int result = c1 + 10; // char + int => int + int => 결과는 int
		
		System.out.println(c1+0);
		System.out.println(result);
		
		int num1 = 10;
		float num2 = 10.0f;
		
		float result2 = num1 + num2; // int + float => float + float => 결과는 float
		
		System.out.println(result2);
		
		float num3 = 1.2f;
		double num4 = num3;
		
		System.out.println(num4);
		
		double result3 = (int)(num3*10 + num4*10)/10.0;
		
		System.out.println(result3);
				
	}
}
