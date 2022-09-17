package Q200;

import java.util.Scanner;

public class IfCoffe1 {

	public static void main(String[] args) {
		// 가진 돈으로 커피를 몇잔 살수 있는지
		// 커피 한잔은 3500원이다.
		
//		1. 가지고 있는 돈을 입력 받는다.
//		2. 가지고 있는 돈을 커피 1잔(3500)값으로 나누고, 변수를 생성하여 변수에 넣는다.
		
		Scanner scan = new Scanner(System.in);
		System.out.print("얼마를 가지고 계신가요? >>>");
		
		int money = scan.nextInt(); // 보유한 돈을 입력 받는다.
		
		
		
		
		if(money<3500)
		{
			int needM = 3500 - money;
			System.out.println("커피 한잔은 3500원입니다. "+needM+"원이 더 필요합니다.");
		}else
		{
			int availCoff = money / 3500;
			System.out.print("구매 가능하신 커피는 "+ availCoff+"잔 이고, ");
			
			int chs = money - (availCoff*3500);
			System.out.println("거스름돈은 "+ chs + "입니다.");
			
		}
	}
}
