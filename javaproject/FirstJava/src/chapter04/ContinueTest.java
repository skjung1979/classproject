package chapter04;

public class ContinueTest {

	public static void main(String[] args) {
		// ==== continu test 예제 ====
		
		//1~9 사이의 홀수 만 출력
		
		int num = 0;
		while(++num<10)
		{
			if(num%2==1)
			{
				continue;
			}
			System.out.println(num);
			//num++; continue하면 이것을 실행 안 하므로 조건식으로 증가식을 넘김
		}
		
	}
	
}
