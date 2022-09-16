package chapter04;

public class WhileLoop2 {

	public static void main(String[] args) {
		// ======= While문 예제 2 =======
		
		int cnt = 0;
		
		// 무한 반복을 이용해서 5번 출력
		while(true)
		{
			System.out.println("JAVA");
			
			if(cnt++>=4) // 0부터 시작하므로 5개하려면 4가 된다.
			{
				break;
			}
			
		}
		
		
		// 짝수이면서: num2%2==0
		// 7의 배수인 수: num2%7==0
		
		int num = 1; // 값을 나눠야 하므로 0이 아닌 1을 초기값으로 해 준다.
		
		while(true)
		{
			if(num%2==0 && num%7==0)
			{
				System.out.println("짝수 이면서 7의 배수인 0과 가장 가까운 수: "+ num);
				break;
			}else
			{
				num++;
			}
		}
		
		
	}

}
