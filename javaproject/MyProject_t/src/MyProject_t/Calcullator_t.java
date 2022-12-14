package MyProject_t;

public class Calcullator_t {

	public static void main(String[] args) {
		
		/* chapter1-3
		 * 
		 *	① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
			② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
			③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
			④ 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
		 * */
		
		System.out.println("10+20="+add(10,20));
		System.out.println("100-10="+substract(100,10));
		System.out.println("100*100="+mul(100,100));
		System.out.println("10/3="+div(10,3));
		// 변수는 double이고 데이터는 정수이지만 자동으로 형변환이 된다.
		// 하지만 결과는 왜곡이 있다... 정밀하지 못하다.
		System.out.println("10/2="+div(10,2));
	}
	
	// ① 숫자 두 개를 매개변수의 인자로 전달받아 더하기 메소드를 추가합시다.
	// a. 반환하는 경우 (메인메소드로 반환하므로 메인메소드에서 출력코딩해야 함.)
	public static long add(long num1, long num2) {
		
		// long result = num1 + num2;
		// return result;
		
		// 한 줄 표현 가능: 불필요한 메모리 낭비가 없어 효율적이다.
		return num1 + num2;	
	}
	
	// ② 숫자 두 개를 매개변수의 인자로 전달받아 빼기 메소드를 추가합시다.
	// a. 반환하는 경우 (메인메소드로 반환하므로 메인메소드에서 출력코딩해야 함.)
	
	public static long substract(long num1, long num2) {
		
		return num1 - num2;
		
	}
	
	// ③ 숫자 두 개를 매개변수의 인자로 전달받아 곱하기 메소드를 추가합시다.
	public static long mul(long num1, long num2) {
		
		return num1 * num2;
		
	}
	
	// ④ 숫자 두 개를 매개변수의 인자로 전달받아 나누기 메소드를 추가합시다.
	public static double div(double num1, double num2) {
		
		return num1 / num2;
		
	}
}
