package chapter10;

public class ExceptionClassTest {

	public static void main(String[] args) {

		try {
		Class cl = Class.forName("Test");
		}catch(ClassNotFoundException e){
			
		}

		
		try {
			int num = 10/0;
		}catch(ArithmeticException e) {
			
		}
		
		
		int[] arr = new int[3];
		try {
		arr[3] = 10;
		}catch(ArrayIndexOutOfBoundsException e) {
			
		}
		
		try {
		String[] names = new String[-1];
		}catch(NegativeArraySizeException e) {
			
		}
		
		
	}

}
