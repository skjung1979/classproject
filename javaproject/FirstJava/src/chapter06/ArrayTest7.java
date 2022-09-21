package chapter06;

public class ArrayTest7 {

	public static void main(String[] args) {
				
		// Math.random() -> 반환 타입은 double
		// 결과 범위: 0.0 <= Math.random() < 1
		
		System.out.println(Math.random());

		// 0~9의 결과를 뽑아내고 싶다면??
		// 범위 양 끝에 10을 곱한다.
		// 그려면 범위가 이렇게. 0.0*10 <= Math.random()*10 < 1*10
		// 형변환해서 소수점을 없앤다.
		// 0.0*10 <= (int)(Math.random()*10) < 1*10
		System.out.println((int)(Math.random()*10));
		
		
		System.out.println("-----------------");
		
		String[] players = {"손흥민", "박지성", "KANE", "이강인", "황희찬"};
		
		// 0번지의 값과 1번지 값을 치환
		
		
		for(int i=0; i<10000; i++)
		{
			int randomIndex = (int)(Math.random()*4)+1;
			
			String temp = null;
			temp = players[0];
			players[0] = players[randomIndex];
			players[randomIndex] = temp;
		}
		
		for(String name : players)
		{
			System.out.println(name);
		}

		
		
//		System.out.println(players[0]);
//		System.out.println(players[1]);
//		
		
		System.out.println("-----index: 0~4 중 랜덤으로 한개------");
		// index: 0~4
		int index = (int)(Math.random()*4); 
				
		String pickName = players[index];
		
		System.out.println(pickName);

		
		
	}
}
