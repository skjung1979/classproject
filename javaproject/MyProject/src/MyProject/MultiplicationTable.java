package MyProject;

public class MultiplicationTable {

	public static void main(String[] args) {

		// ===========반복문 중첩 연습==========
		
		// 구구단을 짜자. 세로로 쭉
		// 횟수는 2단~9단
		
		for(int i=2; i<10; i++)
		{
			System.out.println(i+"단 입니다.");
			for(int j=1; j<10; j++)
			{
				System.out.println(i + " X " + j + " = " + i*j);
			}
		}

		// 구구단 가로로
		// 2 X 1 = 2	3 X 1 = 3	4 X 1 = 4 ..... 9 X 1 = 9 이런식으로
		// 세로는 단을 먼저 반복 시키지만,,,
		// 가로로 표시하려면 단 뒤의 값을 먼저 반복 시킨다....
		
		System.out.println("-----------while문으로--------");
		int i = 1;
		while(i<10)
		{
			//System.out.println(i);
			int j=2;
			while(j<10)
			{
				System.out.print(j+" X "+ i +" = "+ j*1 +"\t");
				j++;
			}System.out.println();// 중첩의 안쪽 문장이 끝나면 한행을 개행한다.
			
			i++;
		}
		
		// for문으로 가로 구구단을 짜보자
		System.out.println("-----------for문으로--------");
		for(int j=1; j<10; j++)
		{
			for(int a=2; a<10; a++)
			{
				System.out.print(a+" X "+ j + " = " + a*j + "\t");
			}System.out.println();
		}
		
		
	}

}






















