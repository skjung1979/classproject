package DoItJava;

import java.util.Scanner;

public class Multi99Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("구구단을 외자! 구구단을 외자~~^^");
		
		System.out.print("   |");
		for(int i = 1; i<10;i++)
		{
			System.out.printf("%3d", i); // 행을 한번만 뿌려준다.
		}
		System.out.println("\n---+---------------------------"); // 구분선을 출력한다.
		
		for(int i=1; i<10;i++)
		{
			System.out.printf("%2d |", i); // 열을 한번 출력한다.
			for(int j=1; j<10; j++)
			{
				System.out.printf("%3d", i*j);
			}
			System.out.println();
			
		}
		
		System.out.println("===============================");
		// 구구단 덧셈표를 출력
		
		System.out.println("---------구구단 덧셈표 출력---------");
		
		System.out.print("   |");
		for(int i=1; i<=9; i++)
		{
			System.out.printf("%3d", i);
		}
		System.out.println("\n---+---------------------------");
		
		for(int i=1; i<=9; i++)
		{
			System.out.printf("%2d |", i);
			for(int j=1; j<=9; j++)
			{
				System.out.printf("%3d", i+j);
			}
			System.out.println();
		}
		
		// 값을 입력하면 *로 정사각형 만들기
		
		System.out.println("-----값을 입력 받아 *로 정사각형 만들기-----");
		
		Scanner scan = new Scanner(System.in);
				
		int in;
	
		do
		{
			System.out.println("변의 길이는? >>");
			in = scan.nextInt();
		}while(in<=0);
		
		for(int i=1; i<=in; i++)
		{
			
			for(int j=1; j<=in; j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}



















