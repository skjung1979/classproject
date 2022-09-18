package DoItJava;

import java.util.Scanner;

public class spira {

	public static void main(String[] args) {
		// n단의 피라미드를 출력하는 메서드 작성
		
		Scanner scan = new Scanner(System.in);
		
		int n;
		System.out.println("n단의 피라미드를 출력합니다.");
		do
		{
			System.out.println("몇 단으로 할까요? >>");
			n = scan.nextInt();
		}while(n<=0);
		
		spiraa(n);
		System.out.println("----------------");
		npiraa(n);
		
		
	
	}

	static void spiraa(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i; j++)
			{
				System.out.print(" ");
			}
			for(int j=1; j<=(i-1)*2+1; j++) // 조건식이 홀수로 증가한다.
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void npiraa(int n)
	{
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n-i; j++)
			{
				System.out.print(" ");
			}
			for(int j=1; j<=(i-1)*2+1; j++) // 조건식이 홀수로 증가한다.
			{
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	
}
