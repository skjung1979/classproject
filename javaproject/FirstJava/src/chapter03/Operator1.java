package chapter03;

public class Operator1 {

	public static void main(String[] args) {
		
		
		// 대입 연산자: =  -> 오른족에서 왼족으로 연산 진행
		// 순서는 가장 마지막이다.
		
		int num1 = 10;
		num1 = 10 + 20;
		
		boolean check = num1-27 > 5; // 비교연산의 결과는 논리값
		// 비교연산(>) 보다 산술 연산(-)이 먼저다. 그리고 마지막에 대입연산(=)이 진행된다.

		// 단항연산자: 오른쪽에서 왼쪽으로 연산
		int num = 0;
		System.out.println(num);
		
		// 증감연산자: ++, -- 사용
		++num; // 현재의 num에 +1하여 대입한다. -> num = num + 1;
		System.out.println(num);
		num++; // num = num + 1; -> num = 1 + 1; -> num = 2;
		System.out.println(num);
		
		--num; // num = num - 1; -> num = 2 - 1; -> num = 1;
		System.out.println(num);
		
		num--; // num = num - 1; -> num = 1 - 1; -> num = 0;
		System.out.println(num);
		
		// 증감연산자가 앞에 들어가는 경우와 뒤에 들어가는 경우의 차이점은???
		// PrefixOperator.java와 PostfixOperator.java에서 비교 테스트
		
		
		// 부호 연산자
		// +, -
		int num2 = 1;
		num2 = +num2;
		System.out.println("num2: "+num2);
		
		num2 = -num2; // num2 * -1 (가독성이 더 있음)
		System.out.println("num2: "+num2);
		
		// 논리 부정 연산자: ! -> 논리값을 부정
		boolean btn = false;
		
		System.out.println("btn: "+btn);
		
		btn = !btn;
		
		System.out.println("btn: "+btn);
		
		
	}
	
}
