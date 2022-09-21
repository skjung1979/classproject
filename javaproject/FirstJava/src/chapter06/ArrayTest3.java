package chapter06;

public class ArrayTest3 {

	public static void main(String[] args) {
		

		int[] korScore = new int[10];	// 배열 선언(좌변)과 생성(우변)
										// 좌, 우변은 같은 타입이어야 함
		
		// 배열의 사이즈를 가지고 있는 length
		System.out.println("배열의 요소 개수: "+ korScore.length);
		

		
		// 배열 요소의 초기화
		korScore[0] = 90;
		korScore[1] = 80;
		korScore[2] = 88;
		korScore[3] = 68;
		korScore[4] = 80;
		korScore[5] = 96;
		korScore[6] = 99;
		korScore[7] = 100;
		korScore[8] = 78;
		korScore[9] = 93;
		
		System.out.println();
		sum(korScore);
		
		
	}
	
	public static void sum(int[] arr) {
		// arr => korScore의 배열인스턴스 주소값을 갖고 있다.
		
		System.out.println("메소드 호출에 의한 출력");
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("총점: " + sum);
		System.out.println("반 평균: " + (float) sum / arr.length); // 형변환한 이유 -> 평균을 소수점으로.
	}
}






















