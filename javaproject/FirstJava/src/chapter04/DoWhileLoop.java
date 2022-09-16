package chapter04;

public class DoWhileLoop {

	public static void main(String[] args) {
		// ===== do while loop =====
		
		// do while: 먼저 한번 반드시 처리한 후 반복해야하는 경우. 경우가 많지는 않다.
		
		int cnt = 0;
		
		do
		{
			// 반복할 문장
			System.out.println("자바"+cnt);
			cnt++;
		}while(cnt<0);

	}

}
