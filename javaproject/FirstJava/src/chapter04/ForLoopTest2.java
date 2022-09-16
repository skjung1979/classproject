package chapter04;

public class ForLoopTest2 {

	public static void main(String[] args) {
		// ===== for loop 예제 2=====
		
		// 구구단 2단
		// 2 X 1 = 2
		// 2 X 2 = 4
		// 2 X 3 = 6
		// ....
		// 2 X 9 = 18
		
//		for(int i=1; i<=9; i++)
//		{
//			System.out.println("2 X "+ i +" = "+ 2*i);
//		}
		
		// 구구단 2단~9단까지는? 반복문 중첩
		// 단의 반복: 2~9단
		for(int i=2; i<=9; i++)
		{
			System.out.println(i+"단");
			System.out.println("--------------"+ i +"단 시작");
			for(int j=1; j<=9; j++)
			{
				System.out.println(i+ " X " + j + " = " + i*j);
			}
			System.out.println("--------------"+ i +"단 종료");
		}
		

	}

}
