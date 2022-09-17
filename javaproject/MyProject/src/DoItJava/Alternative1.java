package DoItJava;

import java.util.Scanner;

public class Alternative1 {

	public static void main(String[] args) {
		// +, -를 번갈아 n개 출력 합니다.
		
		Scanner scan = new Scanner(System.in);
		int n;
		
		System.out.println("+와 - 번갈아 n개 출력합니다.");
		
		
		do
		{
			System.out.print("n값은? >> ");
			n = scan.nextInt();
		}while(n<=0);

//		for(int i=1;i<=n;i++)
//		{
//			if(i%2==1)
//			{
//				System.out.print("+");
//			}else
//			{
//				System.out.print("-");
//			}
//		}
		
		// 위 코드는 비효율적이므로, 아래와 같이 수정한다.
		
		for(int i = 0; i < n/2; i++)
		{
			System.out.print("+-");

		}
		if(n%2!=0)
		{
			System.out.print("+");
		}
		
		
		
	}

}
