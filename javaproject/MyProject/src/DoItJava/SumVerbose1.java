package DoItJava;

import java.util.Scanner;

public class SumVerbose1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1~n까지의 합을 구합니다.(양수를 입력하세요.)");
		int n;
		do {
			
			System.out.print("n값은? >> ");
			n = scan.nextInt();
			
		}while(n <= 0); // 양수를 입력하도록 메세지를 계속 띄운다.
		
		int sum = 0;
		
		for(int i=1; i<=n; i++)
		{
			if(i<n)
			{
				System.out.print(i+" + ");
			}else
			{
				System.out.print(i+ " = ");
			}
			sum += i;
		}
		
		System.out.println(sum);
	}

}
