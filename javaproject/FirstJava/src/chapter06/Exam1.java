package chapter06;

public class Exam1 {
// ============ 챕터 06-1번 강사님 문제풀이 ==============
	
	public static void main(String[] args) {
		// 1. 국어, 영어, 수학 점수 10개씩을 저장하는 배열을 정의하고
		// 점수를 모두 출력하고,
		// 평균 점수를 출력하는 프로그램을 작성해봅시다.
		
		int[][] scores = new int[10][3];
		
		// 박복하여 데이터를 넣는 for문
		for(int i=0; i<scores.length; i++)
		{
			for(int j=0; j<scores[i].length; j++)
			{
				//System.out.print(scores[i][j]);
				int num = (int)(Math.random()*51)+50; // 0+50 <= num <= 50+50
				scores[i][j] = num; // 반복하면서 점수를 랜덤하게 넣기 위함!!!
			}
		}
		
		
		System.out.println("------------------성적표-------------------");
		System.out.println("-----------------------------------------");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------");
		
		int korTotal = 0;
		int engTotal = 0;
		int mathTotal = 0;
		
		
		// 반복하여 입력된 값을 출력하는 for문
		for(int i=0; i<scores.length; i++)
		{
			int sum = 0;
			
			for(int j=0; j<scores[i].length; j++)
			{
				System.out.print(scores[i][j]+"\t");
				sum += scores[i][j];
				
				// 영어 점수일 때
				if(j==0) // or if(j==scores[i].length와 같은가???
				{
					korTotal += scores[i][j]; // 계속 합산 점수를 적립해 나간다.
				}
				
				// 영어 점수일 때
				if(j==1)
				{
					engTotal += scores[i][j]; // 계속 합산 점수를 적립해 나간다.
				}
								
				// 수학 점수일 때
				if(j==2)
				{
					mathTotal += scores[i][j]; // 계속 합산 점수를 적립해 나간다.
				}
				
			}
			System.out.print(sum + "\t" + ((float)sum/scores[i].length)); // 한 줄(행)에 대한 총점과 평균
			System.out.println();
		}
		System.out.println("-----------------------------------------");
		System.out.print(korTotal+"\t"+engTotal+"\t"+mathTotal);
		System.out.println();
		System.out.println((float)korTotal/scores.length+"\t"+(float)engTotal/scores.length+"\t"+(float)mathTotal/scores.length);

	}

}
