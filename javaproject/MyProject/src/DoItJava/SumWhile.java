package DoItJava;

import java.util.Scanner;

public class SumWhile {

	public static void main(String[] args) {
		// 1~n까지의 합을 구한다.
		
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.print("1~n까지의 합을 구합니다. n값은? >> ");
		int n = scan.nextInt();
		System.out.println("-----------------------------------");
		int i = 1;
		int sum = 0;
		
		while(i<=n)
		{
			sum += i;
			i++;
		}
		
		System.out.println("whil문으로 구한 합");
		System.out.println("1부터"+ n + "까지의 합은 "+ sum+"입니다.");
		
		System.out.println("-----------------------------------");
		
		
		sum = 0;
		
		for(i=1; i<=n; i++)
		{
			sum += i;
		}
		System.out.println("for문으로 구한 합");
		System.out.println("1부터"+ n + "까지의 합은 "+ sum+"입니다.");
		
		System.out.println("-----------------------------------");
		System.out.println("정수 a, b를 입력하시면, 두 수 사이의 모든 정수의 함을 구합니다.");
		System.out.print("a값은? >");
		int a = scan.nextInt();
		System.out.print("b값은? >");
		int b = scan.nextInt();
		
		
		System.out.println("입력하신 두 정수"+ a +"와"+b+"사이 정수들의 합은 "+sumof(a,b)+"입니다.");
		
		
	}
	
	static int sumof(int a, int b)
	{

		int min; // 시작하는 수. 두 정수 중 작은 수
		int max; // 종료 수 두 정수 중 큰 수
		int sum = 0;
		
		if(a>b)
		{
			min = b;
			max = a;
		}else
		{
			max = b;
			min = a;
		}
		
		for(int i=min; i<=max; i++)
		{
			sum += i;
		}
		
		return sum;
	}
	
	
	
	
	
	

}
