package DoItJava;

import java.util.Scanner;

public class Max3 {

	public static void main(String[] args) {


		// 3개의 값을 입력 받아 최대값을 출력 해 준다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("세 정수의 최대값을 구합니다.\n3개의 정수를 입력하세요. >>>");
		System.out.print("a 값 입력: ");
		int a = scan.nextInt();
		System.out.print("b 값 입력: ");
		int b = scan.nextInt();
		System.out.print("c 값 입력: ");
		int c = scan.nextInt();
		
		int max = a;
		if(b>max)
		{
			max = b;
		}
		if(c>max)
		{
			max = c;
		}
		
		System.out.println("최대값은 "+ maxR(a,b,c) + "입니다.");
		
		// 메소드에서 처리하도록 하려면
		
		
		
	}
	
	
	public static int maxR(int a, int b, int c)
	{
		int max = a;
		
		if(b>max)
		{
			max = b;
		}
		if(c>max)
		{
			max = c;
		}
		
		return max;
	}
	

}
