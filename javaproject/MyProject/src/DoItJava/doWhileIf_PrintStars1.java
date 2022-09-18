package DoItJava;

import java.util.Scanner;

public class doWhileIf_PrintStars1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("*를 n개 출력하됙, w개마다 줄을 바꿔서 출력합니다.");
		
		int n;
		int w;
		
		do
		{
			System.out.print("n값은? >>> ");
			n = scan.nextInt();

			
		}while(n<=0); // 위 조건에 걸리면 계속 값을 입력하라고 물어 본다. 정수만 입력 받기 위한 것이다.
		
		do
		{
			System.out.println("w값은? >>> ");
			w = scan.nextInt();
		}while(w<=0 || w>n); // 위 조건에 걸리면 계속 값을 입력하라고 물어 본다. 정수만 입력 받고 n보다 작은 값을 입력 받기 위한 것이다.
		
//		for(int i=0; i<n; i++)
//		{
//			System.out.print("*");
//			if(i%w == w-1)
//			{
//				System.out.println();
//			}
//		}
//		if(n%w != 0)
//		{
//			System.out.println();
//		}
//		
		// 위 코드는 for문 돌때마다 if문을 실행하므로 비효율적이다. 아래와 같이 수정한다.
		
		for(int i=0; i < n/w; i++)
		{
			System.out.println("*".repeat(w));
		}
		
		int rest = n%w;
		if(rest!=0)
		{
			System.out.println("*".repeat(rest));
		}
		
		
	}

}
