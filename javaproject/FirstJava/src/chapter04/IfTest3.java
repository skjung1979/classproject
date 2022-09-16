package chapter04;

import java.util.Scanner;

public class IfTest3 {

	public static void main(String[] args) {

		// ============중첩 조건에 대한 예제==========
		
		// 점수에 따라서 학점 표기를 합시다.
		// 100 ~ 97: A+
		// 94 ~ 96: A
		// 90 ~ 93: A-
		// 80점 대는 B+, B, B-
		// 70점 대는 C+, C, C-
		// 나머지는 F
		// 조건문의 중첩
		
		Scanner in = new Scanner(System.in);
				
		System.out.print("당신의 점수는요? >>> ");
		int score = in.nextInt();
		
		String result = "F";
		
		if(score>=90)
		{
			// A, A+, A-
			result = "A";
			
			// 중첩 조건: 100~97 : A+
			if(score>=97)
			{
				result += "+"; // result = result + "+"
			}else if(score<94)
			{
				// 중첩 조건: 90~93: A-
				result += "-";
			}
			
		}else if(score>=80)
		{
			// B, B+, B-
			result = "B";
			
			// B+
			if(score>=87)
			{
				result += "+";
			}else if(score<84)
			{
				result += "-";
			}
			
			
		}else if(score>=70)
		{
			// C, C+, C-
			result = "C";
			
			if(score>=77)
			{
				result += "+";
			}else if(score<74)
			{
				result += "-";
			}
		} /* 
			 * else { result = "F"; }  --> result 변수의 초기값에 F를 넣었으므로 생략해도 된다.
			 */
		System.out.println("당신의 학점은 "+ result + "입니다.");
	}
}




































