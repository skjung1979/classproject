package MyProject;

import java.util.Calendar;
import java.util.Scanner;

public class Member {
	
	public static void main(String[] args) {
		
		aaaMyName("정성균");
		
		String name = "정성균";
		int age = 44;
		double height = 173.8;
		boolean hasBook = false;
		
		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(hasBook);
		
		
		/* chapter04 문제 풀이 - 정성균
		 * 
		 * ① 독감예방 접종이 가능한지 여부를 확인하는 메소드를 정의합니다.
		 * - 매개변수로 태어난 해(년도)를 전달받습니다.
		 * - 15세 미만의 경우와 65세 이상의 경우 “무료예방접종이 가능합니다.” 메시지가 콘솔에 출력하도록 합니다.
		 * - 위에서 정의한 조건의 범위가 아닌 나머지의 경우 “무료접종 대상이 아닙니다.”라고 출력하도록 합니다.
		 */
		
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		
		// 매개변수로 태어난 해(년도)를 전달받습니다.
		
		Scanner in = new Scanner(System.in);
		System.out.print("태어난 년도를 입력해 주세요. >>> ");
		int birthYear = in.nextInt(); 
		
		//int birthYear = 1979;
		
		// 나이를 계산하려면, 현재 년도 - 출생년도 + 1 --> 2022 - 1979 + 1
		int availAge = year - birthYear + 1;
		
		checkDok(availAge);
		
		
		System.out.println("============================");
		
	
		
		
		
		
	}
	
	public static void aaaMyName(String nm) {
		

		System.out.println(nm);
		
	}
	
	public static void checkDok(int availAge) {
	 
	
	 		if(availAge >= 65 || availAge < 15) {
	 		    System.out.println("무료예방접종이 가능합니다.");
	 		}else {
	 		    System.out.println("무료접종 대상이 아닙니다.");
	 		}
	 		
	 		
	    
	}
	
	public static void checkHealth(int availAge, int birthYear) {
	    
		/*
		 * ② 건강검진 대상 여부를 판별하고 어떤 검진이 가능한지 확인하는 메소드를 정의합니다.
		 * - 매개변수로 태어난 해(년도)를 전달받습니다.
		 * - 대한민국 성인( 20세 )의 경우 무료로 2년마다 건강검진을 받을 수 있습니다.
		 * - 짝수 해에 태어난 사람은 올해가 짝수년이라면 검사 대상이 됩니다.
		 * - 40 이상의 경우는 암 검사도 무료로 검사를 할 수 있습니다.
		 */
	    int year = Calendar.getInstance().get(Calendar.YEAR);
	    
		if(availAge >= 20 && year%2 == birthYear%2) {
		    // 건강검진 대상이된다. 하지만 2년마다
		    if(availAge >= 40) {
			System.out.println("암 검진도 가능");
		    }
		    
		    
		    
		    
		    
		}else {
		    
		}
	    
	}

	
	
	
}
