package chapter10;

import java.util.Scanner;

public class ExceptionTryCatchTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 1을 입력하세요.");
		int num1 = sc.nextInt();
		
		System.out.print("숫자 2를 입력하세요.");
		int num2 = sc.nextInt();

		try {
			System.out.println("num1 / num2 = " + num1/num2);	// <= 예외 발생 예상 위치
		
			String str = null;
			
			// System.out.println(str.length());
		
		}catch(ArithmeticException e) {
			System.out.println("0으로 나누는 것은 불가합니다.");
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(NullPointerException e) {
			System.out.println("Null 예외처리완료");
		}catch(Exception e) {
			System.out.println("예외발생!!!");
			e.printStackTrace();
		}finally {
			System.out.println("프로그램을 종료합니다.");
		}
		
		
		
		
	}

}
