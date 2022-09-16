package chapter04.exam;

public class Exam03 {

	public static void main(String[] args) {
//  ========= 카페 '반복문 연습 문제' ========= 강사님 문제풀이
		
//		문제 3.
//		구구단의 짝수 단(2,4,8 - 6단 제외)만 출력하는 프로그램 작성.
//		단, 2단은 2x2까지, 4단은 4x4까지, 8단은 8x8 까지 출력
		
		for(int i =2; i<10; i*=2)
		{
			System.out.println(i);
			for(int j=1; j<=i; j++)
			{
				System.out.println(i + " X " + j + " = "+ i*j);
			}
		}
		
	}

}
