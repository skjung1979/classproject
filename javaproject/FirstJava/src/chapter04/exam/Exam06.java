package chapter04.exam;

public class Exam06 {

	public static void main(String[] args) {
//  ========= 카페 '반복문 연습 문제' ========= 강사님 문제풀이

//		문제 6.
//		1 부터 99까지의 합을 구하는 프로그램 작성
//		while문, for문, do while 문을 각각 사용

		int num = 1;
		int sum = 0;
		
		System.out.println("이하는 while문 이용한 1~99까지 합");
		while(num<100)
		{
			sum += num;
			num++;
		} System.out.println(sum);
		
		System.out.println("------------------------");
		System.out.println("이하는 for문 이용한 1~99까지 합");
		
		sum = 0;
		for(num=1; num<100; num++)
		{
			sum += num;
		} System.out.println(sum);
		
		System.out.println("------------------------");
		System.out.println("이하는 do while문 이용한 1~99까지 합");
		
		num = 1;
		sum = 0;
		do
		{
			sum += num;
			num++;
		}while(num<100);
		System.out.println(sum);
		
		
//  ========= 카페 '반복문 연습 문제' ========= 정성균 문제풀이
		System.out.println("----------복습-----------");
		
//			문제 6.
//			1 부터 99까지의 합을 구하는 프로그램 작성
//			while문, for문, do while 문을 각각 사용

		// while문 이용
//		while(조건식)
//		{
//			참이면 실행되는 코드;
//			증감식;
//		}
		
		int n1 = 1; // 증가 변수. 초기값은 합이므로 0
		int sum1 = 0;
		
		while(n1<100)
		{
			sum1 += n1; // sum1 = sum1 + n1
			n1++;
		} System.out.println("while문을 이용한 1~99까지의 합: "+ sum1);
		
		// do while문 이용
//		do
//		{
//			참이면 실행되는 모드(초기 한번은 조건에 상관없이 무조건 실행된다.);
//			증감식;
//		}while(조건식);
		
		int n2 = 1;
		int sum2 = 0;
		
		do
		{
			sum2 += n2;
			n2++;
		}while(n2<100);
		System.out.println("do while문을 이용한 1~99까지의 합: "+ sum2);
		
		//  for문 이용
//		for(초기값; 조건; 증감식)
//		{
//			참일 때 실행도는 코드;
//		}
		
		int sum3 = 0;
		for(int n3=1; n3<100; n3++)
		{
			sum3 += n3;
		} System.out.println("for문을 이용한 1~99까지의 합: "+ sum3);
		
		
		
		
		
	}
}
