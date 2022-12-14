package first;

public class PrintMethodTest {
	
	public static void main(String[] args) {
		
		// print 메소드: 매개변수로 전달하는 데이터를 출력
		System.out.print("개인 소개");
		
		// println은 매개변호로 전달된 데이터를 출력하고 개행한다.
		System.out.println(); // 줄바꿈 효과
		
		System.out.print("Name: 정성균");
		
		System.out.println();
		
		System.out.println("Age: 44");
		
		System.out.println("Job: programmer");

		// printf("문자열의 규칙", 데이터1, 데이터2, 데이터3)
		// 정수: %d
		// 문자열: %s
		// 문자: %c
		// 실수: %f, %e(지수)
		
		// 문자열 저장 변수 선언: String 변수이름 = "정성균";
		
		String userName = "정성균";
		int age = 44;
		float height = 173.8f; // or double height = 173.8d; 이런 석으로
		String job = "programmer";
		
		System.out.println();
		
		System.out.printf("Name: %s , Ages: %d , Height: %fcm , Job: %s", "정성균", 44, 173.800001f, "programmer" );
		
		System.out.println();
		
		System.out.printf("Name: %s, Ages: %d, Height: %fcm, Job: %s", userName, age, height, job);
		
	}

}
