// 연습문제 chapter3 강사 문제 풀이
package chapter03.exam;

import java.util.Scanner;

public class Calculator_t {

    public static void main(String[] args) {

	Scanner in = new Scanner(System.in);
	
	/*
	 * ① 정수 두 개를 매개변수의 인자로 전달받아 더하기연산 후 출력하는 메소드를 정의 -> void
	 * ② 정수 두 개를 매개변수의 인자로 전달받아 빼기연산 후 출력하는 메소드를 정의 -> void
	 * ③ 정수 두 개를 매개변수의 인자로 전달받아 곱하기연산 후 출력하는 메소드를 정의 -> void
	 * ④ 정수 두 개를 매개변수의 인자로 전달받아 나누기연산 후 출력하는 메소드를 정의 -> void
	 * ⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의 -> void X, return 값 O
	 * ⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의 원의 -> void X, return 값 O
	 * 둘레 : 2 x π x r , 월의 넓이 : π x r x r
	 */
	
	System.out.print("숫자 1을 입력해주세요. >>> ");
	int num1 = in.nextInt();
	
	System.out.println();
	
	System.out.print("숫자 2를 입력해주세요. >>> ");
	int num2 = in.nextInt();
	
	System.out.println("사칙연산의 결과==========");
	
	addResultPrint(num1, num2);
	substractResultPrint(num1, num2);
	multiflyResultPrint(num1, num2);
	divideResultPrint(num1, num2);
	
	/////////////////////////////
	
	System.out.println("========================");
	
	System.out.print("원의 반지륾을 입력해주세요. >>> ");
	double rad = in.nextDouble();
	
	System.out.println();
	
	System.out.println("원의 둘레: "+ circum(rad));
	System.out.println("원의 넓이: "+ area(rad));
		
	
    }
    
    public static void addResultPrint(long num1, long num2) { // 반환할 것이 없으면 void이고 메소드명 앞에 변수 데이터타입을입력 할 필요 없다.
	System.out.println("두 수의 덧셈 결과: "+ (num1 + num2)); // 덧셈 연산 방향이 왼쪽->오른쪽이므로 괄호로 묶어준다.
    }
    
    public static void substractResultPrint(long num1, long num2) {
	System.out.println("두 수의 뺄셈 결과: "+ (num1 - num2));
    }
    
    public static void multiflyResultPrint(long num1, long num2) {
	System.out.println("두 수의 곱셈 결과: "+ num1 * num2);
    }

    public static void divideResultPrint(double num1, double num2) {
	System.out.println("두 수의 나눗셈 결과: "+ num1 / num2);
    }
    
    /*
     * ⑤ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 둘레를 구해 반환하는 메소드를 반환하는 메소드를 정의 -> void X, return 값 O
     * ⑥ 실수 반지름 하나를 매개변수의 인자로 전달받아 원의 넓이를 구해 반환하는 메소드를 반환하는 메소드를 정의 원의 -> void X, return 값 O
     * 둘레 : 2 x π x r , 월의 넓이 : π x r x r
     */
    
    public static double circum(double r) {
	
	return 2 * 3.14 * r;
    }
    
    public static double area(double r) {
	return 3.14 * r * r;
    }
    
}












































