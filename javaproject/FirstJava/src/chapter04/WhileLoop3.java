package chapter04;

public class WhileLoop3 {

	public static void main(String[] args) {
		// ===== while loop =====
		// 1~10까지의 합 -> 55
		
		// 반복 10번 또는 카운터할 변수가 1~10까지 나오도록 해야한다.
		
		int num = 1;
		int sum = 0; // 합을 저장할 변수 초기값은 합이므로 0으로 해야한다.
				
		while(num<=10)
		{
			// 합을 구하는 연산
			sum = sum + num; // ((((0+1)+2)+3).....+10)
			
			// 증가식
			num++;
			
			// System.out.print(sum+"+"+num+"="+(sum+=num));			
		}
		System.out.println("1~10까지의 함: "+ sum);

	}

}
