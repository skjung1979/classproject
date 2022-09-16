package chapter04;

public class ForLoopTest {

	public static void main(String[] args) {
		// ===== for loop test 예제 =====

//		for(초기식 ; 반복의 조건식 ; 증가식)
//		{
//			반복할 문장들..args. args
//		}
		
		
		// "JAVA" 출력을 5번 해보자
		for(int i=0; i<5; i++)
		{
			System.out.println("JAVA "+i);
		}
		
		// 1~10까지의 숫자 중 짝수만 출력
		for(int i=0; i<=10; i+=2)
		{
			System.out.println(i);
		}
		
		
	}

}
