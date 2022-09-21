package chapter06;
//=================== 챕터 06-3 강사님 문제풀이 =============
public class StudentMain {

	public static void main(String[] args) {
	
		/*
		 * 3. main()메소드에 아래 내용을 정의해봅시다.
		 * ① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
		 * ② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다.
		 * ③ 배열에 저장된 Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		 */		
		
		
		// 학생 10명의 정보를 저장하는 배열 (이름, 국어, 영어, 수학)
		Student[] students = new Student[10]; // 선언 및 생성
		
		// 점수 초기화
		for(int i=0; i<students.length;i++)
		{
			students[i] = new Student("학생"+i, (int)(Math.random()*51)+50, (int)(Math.random()*51)+50, (int)(Math.random()*51)+50);
		}
		
		int engTotalScore = 0;
		int korTotalScore = 0;
		int mathTotalScore = 0;
		
		System.out.println("|||||||||||||||||||| 성적표  ||||||||||||||||||||||");
		System.out.println("-------------------------------------------------");
		System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-------------------------------------------------");
		
		for(Student s : students)
		{
			s.printData();
			korTotalScore += s.getKorScore();
			engTotalScore += s.getEngScore();
			mathTotalScore += s.getMathScore();
		}

		System.out.println("-------------------------------------------------");
		System.out.printf("과목총점\t%d \t %d \t %d \t \n",korTotalScore, engTotalScore, mathTotalScore);
		System.out.printf("과목평균\t%.1f \t %.1f \t %.1f \t \n", (korTotalScore/10f), (engTotalScore/10f), (mathTotalScore/10f));
		System.out.println("-------------------------------------------------");
		
	}

}
