package MyProject;

public class Calculator {
	
	public static void main(String[] args) {
		
		addResultPrint(10.5, 11.0);
		subResultPrint(10.5, 11.0);
		mulResultPrint(14.5, 16);
		divResultPrint(100, 17.0);
		
	}
	
	public static void addResultPrint(double num1, double num2) {
		
		double sum = num1 + num2;
		
		System.out.println(sum);
		
	}
	
	public static void subResultPrint(double num1, double num2) {
		
		double sum = num1 - num2;
		
		System.out.println(sum);
	}
	
	public static void mulResultPrint(double num1, double num2) {
		
		double sum = num1 * num2;
		
		System.out.println(sum);
	}
	
	public static void divResultPrint(double num1, double num2) {
		
		double sum = num1 / num2;
		
		System.out.println(sum);
	}

}
