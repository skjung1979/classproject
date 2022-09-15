package chapter03;

import java.util.Scanner;

public class Exam03_01
{

	public static void main(String[] args)
	{

		Scanner scanner = new Scanner(System.in);
		
		System.out.print("두 개의 숫자를 입력하세요. >>> ");
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		System.out.println("두 수의 합: "+ add(a,b));
		System.out.println("두 수의 차: "+ sub(a,b));
		System.out.println("두 수의 곱: "+ mul(a,b));
		System.out.println("두 수를 나눈 값: "+ div(a,b));	
		
		System.out.println("-------------------");
		
		System.out.print("반지름을 입력하시면 원의 둘레와 넗이를 알려 드립니다. >>> ");
		
		double r = scanner.nextDouble();
		
		System.out.println("원의 둘레는 "+ cirCircle(r));
		System.out.println("원의 둘레는 "+ areaCircle(r));
		
	}
	
	public static int add(int a, int b)
	{
		int re = a + b;
		return re;
	}
	
	public static int sub(int a, int b)
	{
		int re = a - b;
		return re;
	}
	
	public static int mul(int a, int b)
	{
		int re = a * b;
		return re;
	}
	
	public static double div(int a, int b)
	{
		double re = a / b;
		return re;
	}

	// 원의 둘레 구하는 메소드
	public static double cirCircle(double a)
	{
		double re = 2 * 3.14 * a;
		return re;
	}
	
	// 원의 넓이 구하는 메소드
	public static double areaCircle(double a)
	{
		double re = 3.14 * a * a;
		return re;
	}		
}
