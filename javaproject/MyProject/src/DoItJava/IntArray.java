package DoItJava;

import java.util.Scanner;

public class IntArray {

	
	
	
	
	
	public static void main(String[] args) {
		// 구성 요소의 자료형이 int형인 배열(구성 요소수는 5 / new에 의해 본체를 생성)
		
		// int[] a = new int[5]; // 배열의 선언
		
		int[] a = {1,2,3,4,5}; // 배열 초기화에 의해 생성
		
		for(int i=0; i<a.length;i++)
		{
			
			System.out.println("a["+i+"] = "+a[i]);
		}
		
		// 배열에서 최대값 구하기
		
		int max = a[0];

		
		
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>max) max = a[i];
		}
		System.out.println("최대값은 "+max);
		
		// 실습. 키의 최대값을 구합니다
		// 사람수와 키값을 입력 받는다.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("키의 최대값을 구합니다. 사람수와 키를 입력해주세요.");
		System.out.print("사람수는? >>");
		int nPeople = scan.nextInt();
		System.out.println();
		System.out.println("키는? >>");
		int[] height = new int[nPeople];
		
		for(int i=0; i<nPeople;i++)
		{
			System.out.print(i+"번째 사람의키: ");
			height[i] = scan.nextInt();
		}
		
		System.out.println("이중에 가장 큰 키는 "+ maxOf(height) + "입니다.");
			
	}
	static int maxOf(int[] a)
	{
		int max = a[0];
		for(int i=1; i<a.length; i++)
		{
			if(a[i]>max) max = a[i];
		}
		return max;
	}


}
