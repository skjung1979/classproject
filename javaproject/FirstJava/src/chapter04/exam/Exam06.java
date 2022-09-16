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
		
		
	}
}
