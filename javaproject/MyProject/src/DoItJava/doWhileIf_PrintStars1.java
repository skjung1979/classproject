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

			
		}while(n<=0);
		
		do
		{
			System.out.println("w값은? >>> ");
			w = scan.nextInt();
		}while(w<=0 || w>n);
		
		for(int i=0; i<n; i++)
		{
			System.out.print("*");
			if(i%w == w-1)
			{
				System.out.println();
			}
		}
		if(n%w != 0)
		{
			System.out.println();
		}
		
		
	}

}
