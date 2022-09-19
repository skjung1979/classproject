package chapter05;

import java.util.Scanner;	// 다른 패키지에 있기 때문에 import가 되는 것이고,
							// 같은 패키지에 있는 calculator는 import하지 않는다.(자동 임포트)

public class CalculatorMain {

	public static void main(String[] args) {
		
		// 더하기, 곱하기하는 프로그램
		
		Calculator cal = new Calculator();	// 인스턴스 생성
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자1은? >>");
		int num1 = scan.nextInt();
		System.out.println();
		System.out.print("숫자2는? >>");
		int num2 = scan.nextInt();
		
		// 더하기 곱하기 연산의 결과
		System.out.println();
		System.out.println("다하기 곱하기 연산의 결과");
		System.out.println("num1 + num2 = " + cal.add(num1, num2));
		System.out.println("num1 * num2 = " + cal.multyfly(num1, num2));
		
		
		System.out.println("---------------------");
		System.out.println("오버로딩 테스트");
		System.out.println("num1 + num2 = " + cal.add(1, 2));
		System.out.println("num1 + num2 = " + cal.add(1L, 2L));
		System.out.println("num1 + num2 = " + cal.add(1f, 2f));

	}

}
