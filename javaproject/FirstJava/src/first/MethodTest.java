package first;

public class MethodTest {

	public static void main(String[] args){
		// 메소드: 기능
		
		// 메소드의 정의 시 유의
		// :필요한 데이터 유무, -> 매개 변수 결정하는 것 (필수사항 아님)
		// 어떤 연산이지, -> 목적/문제 해결을 위한 코드
		// 반환 테이터 있는지 -> 메소드 선언부 맨 앞에 데이터 타입 정의 (필수 아님)
						//	-> return 키워드로 데이터를 반환
						// 데이터 반환이 없는 경우 return 키워드 생략하며,
						//	반환 타입은 void라고 표시 해 준다.

		// 숫자 두개를 전달 받아 덧셈한 결과를 반환하는 메소드 정의해보자!!!
			// 숫자 두개를 전달 받아 -> 매개 변수
			// 덧셈한 -> 덧셈 연산
			// 결과를 반환하는 -> return 결과값
			// 메소드 정의해보자!!!

			int sum = add(100, 50);
			
			System.out.println(sum); // = System.out.println(add(100,50));
		
			addResultPrint(50,60);
			
		}	
		//반환 타입
		public static int add(int num1, int num2){
			
			// add(100, 50); 메소드의 호출
			
			//합을 저장하는 변수 필요
			int sum; // 정수 데이터를 저장하는 변수 선언
			
			sum = 0; // sum변수 초기화: 최초 데이터를 저장하는 것(그래야 오류를 막음)
			
			// 더하기 연산
			sum = num1 + num2;
			
			// 연산 결과 반환
			return sum;
		}
		// 정수 두개를 전달 받아 합을 출력하는 메소드를 정의
		public static void addResultPrint(int num1, int num2) {
			
			int sum = num1 + num2;		
			
			System.out.println(sum);
			
		}
		
}
