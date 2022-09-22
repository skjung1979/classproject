package chapter06;

import java.util.Scanner;

		//========== 챕터 06-2 문제풀이 JSK ==============

public class StudentMainSK
{

	public static void main(String[] args)
	{
		/*
		 * 3. main()메소드에 아래 내용을 정의해봅시다. ① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열
		 * 인스턴스를 생성해 봅시다. ② Student 타입의 인스턴스를 생성하고 배열에 저장하는 코드를 정의해봅시다. ③ 배열에 저장된
		 * Student 타입의 인스턴스의 메소드를 이용해서 모든 데이터를 출력해봅시다.
		 */
	
		StudentSK[] students = new StudentSK[10]; // 선언 및 생성
		
		while(true)
		{
			Scanner scan = new Scanner(System.in);
			System.out.println("성적표 출력 2가지 중 하나를 선택하세요.");
			System.out.println("1.랜덤 점수 출력 / 2.정보 직접 입력 / 3. 종료");
			int n = scan.nextInt();
			
			// 과목별 총점 변수에 대한 선언 및 초기화
			int korTotalSco = 0;
			int engTotalSco = 0;
			int mathTotalSco = 0;
			
			if(n==1) // 랜덤 점수 출력
			{				
				// ① Student 타입의 배열을 선언하고, 요소 10개를 저장할 수 있는 배열 인스턴스를 생성해 봅시다.
				// 점수 초기화
				for (int i = 0; i < students.length; i++) {
					// 학생+i, 국어, 영어, 수학의 랜덤 점수를 입력
					// 랜던 점수: (int)(Math.random()*51)+50 => 50이상~100까지
					students[i] = new StudentSK("학생" + i, (int) (Math.random() * 51) + 50, (int) (Math.random() * 51) + 50,
							(int) (Math.random() * 51) + 50);
				}
				
				System.out.println("|||||||||||||||||||| 성적표  ||||||||||||||||||||||");
				System.out.println("-------------------------------------------------");
				System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("-------------------------------------------------");

				// 한줄 데이타를 출력
				for (StudentSK s : students) {
					s.printLine();
					// 출력은 안되지만, 각 과목의 총점을 생성한 변수에 값을 넣어준다.
					korTotalSco += s.getKorSco(); // get으로 얻은 데이타를 변수에 계속 대입한다.
					engTotalSco += s.getEngSco();
					mathTotalSco += s.getMathSco();
				}

				System.out.println("-------------------------------------------------");
				System.out.println("과목총점\t" + korTotalSco + "\t" + engTotalSco + "\t" + mathTotalSco + "\t");
				System.out.println("과목평균\t" + korTotalSco / 10f + "\t" + engTotalSco / 10f + "\t" + mathTotalSco / 10f);
				System.out.println("-------------------------------------------------");
		
			}else if(n==2)
			{
				System.out.println("여기에서 직접 입력 받아서 출력");
				// 이름, 국어, 영어, 수학 점수를 입력받아서 각 행에 넣어준다.
				for(int i=0; i<students.length; i++)
				{	
					System.out.print((i+1)+"번째 학생의 국어 점수는? >>>");			
					int ks = scan.nextInt();
					System.out.print((i+1)+"번째 학생의 영어 점수는? >>>");
					int es = scan.nextInt();
					System.out.print((i+1)+"번째 학생의 수학 점수는? >>>");
					int ms = scan.nextInt();
					scan.nextLine(); // nextInt()다음에는 이걸 꼭
					System.out.print((i+1)+"번째 학생의 이름은? >>>");
					String nm = scan.nextLine(); // 이름은 왜 입력이 안될까?...ㅠ
					
					students[i] = new StudentSK(nm, ks, es, ms);	
				}
				System.out.println("|||||||||||||||||||| 성적표  ||||||||||||||||||||||");
				System.out.println("-------------------------------------------------");
				System.out.println("학생이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println("-------------------------------------------------");
	
				for (StudentSK s : students) {
					s.printLine();
					// 출력은 안되지만, 각 과목의 총점을 생성한 변수에 값을 넣어준다.
					korTotalSco += s.getKorSco(); // get으로 얻은 데이타를 변수에 계속 대입한다.
					engTotalSco += s.getEngSco();
					mathTotalSco += s.getMathSco();
				}
				System.out.println("-------------------------------------------------");
				System.out.println("과목총점\t" + korTotalSco + "\t" + engTotalSco + "\t" + mathTotalSco + "\t");
				System.out.println("과목평균\t" + korTotalSco / 10f + "\t" + engTotalSco / 10f + "\t" + mathTotalSco / 10f);
				System.out.println("-------------------------------------------------");
					
			}else if(n==3)
			{		
				System.out.println("Thank you bye~");
				break;
			}	
		}
	}
}
