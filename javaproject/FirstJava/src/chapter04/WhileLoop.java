package chapter04;

public class WhileLoop {

	public static void main(String[] args) {
		// ======= While문 예제 =======
		

		
// 		반복 체크할 변수 필요
//		
//		while(반복의 조건)
//		{
//			반복해야 할 코드
//			
//			변수 증감식 연산식 필요 (반복문을 탈출하기 위해 꼭 필요하다!!!)
//		}
//		
		
		// 5번 "JAVA"를 출력하는 코드 작성하기
		// 5번 출력문 실행
				
		int count = 0; // 0 1 2 3 4 5
		
		while(count++<5) // 간단한 1씩 증가하는 거라면 이렇게도 가능 ++이 전위로가면 4번만 실행(증가하고 실행하기 때문에)된다.
		{
			System.out.println("JAVA");
			
			// 반복문을 탈출할수 있는 즘감식 count = count + 1
			//count += 1; 또는 count += 2;
			//count++; // 하나씩 한다면 이것도 가능
		}
		
		
	}

}
