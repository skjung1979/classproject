package MentorKing;

import java.util.ArrayList;
import java.util.HashMap;

public class EvenNumberSum {

  	public static void main(String[] args) {

//		int sumA = 0;
//		
//		for (int i=1; i<=10; i++) {
//			if (i % 2 == 0) {
//				sumA += i;
//			}
//		}
//
//		System.out.println("for문 사용 sum: " + sumA);	
//		System.out.println("====================");

		
		int sumB = 0;
		int i = 0;

		while (i <= 100) {			
			switch (i % 2) {
				case 0:
					sumB += i;
					break;			
			}
			i++;
		}
		
		System.out.println("switch문 사용 sum: " + sumB);
//		
//		
//		HashMap<String, String> dataset = new HashMap<>();
//		
//		
//		
//		String[] str = new String[5] ;
//		str[3] = "asdfasf";	
	}
}
