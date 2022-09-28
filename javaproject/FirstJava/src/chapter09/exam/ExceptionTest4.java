package chapter09.exam;

import java.util.Scanner;

public class ExceptionTest4 {

	public static void main(String[] args) {

//		Scanner sc = null;
//		try {
//			sc = new Scanner(System.in);
//		} finally {
//			if(sc != null) {
//			sc.close();
//			}
//		}
//		
//		
		
		// 이렇게하면 스캐너가 오토 클로징이 된다.!!!
		try(Scanner sc = new Scanner(System.in);)
		{
			
		}catch(Exception e) {
			
		}
		
			
		
		
		
	}
}
