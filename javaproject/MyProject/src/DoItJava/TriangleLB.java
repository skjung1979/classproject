package DoItJava;

import java.util.Scanner;

public class TriangleLB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		int n;
		
		System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
		do
		{
			System.out.print("몇단 삼각형입니다? >> ");
			n = scan.nextInt();
		}while(n<=0);
		
		//--- 왼쪽 아래가 직각인 직각삼각형을  출력 ---//
		for(int i=1; i<=n; i++) // 행 개수는 입력 받은 n개 만큼 뿌려 줘야 한다.
		{
			for(int j=1;j<=i;j++) // 1행에서는 열도 1개만 뿌려주면 되므로 조건을 열j는 i보다 작거나 같도록 한다.
			{
				System.out.print("*");
			}
			System.out.println(); // 
		}
		
		//--- 왼쪽 아래가 직각인 직각삼각형을  출력 ---//
		System.out.println("--- 왼쪽 위가 직각인 직각삼각형을 출력 ---");
		
		for(int i=1; i<=n;i++)
		{
			for(int j=1; j<=n-i+1;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		//--- 오른쪽 위가 직각인 직각삼각형을  출력 ---//
				System.out.println("--- 오른쪽 위가 직각인 직각삼각형을 출력 ---");
				
				for(int i=1; i<=n;i++)
				{
					for(int j=1; j<=i-1; j++)
					{
						System.out.print(" ");
					}
					for(int j=1; j<=n-i+1;j++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				
		//--- 오른쪽 아래가 직각인 직각삼각형을 출력 --- //
				System.out.println("--- 오른쪽 위가 직각인 직각삼각형을 출력 ---");
				for(int i=1; i<=n; i++)
				{
					for(int j=1; j<=n-i;j++)
					{
						System.out.print(" ");
					}
					for(int j=1; j<=i;j++)
					{
						System.out.print("*");
					}
					System.out.println();
				}
				
		
		
		
		
	}

}
























