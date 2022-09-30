package chapter10.exam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam10d2Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
	
			System.out.print("숫자를 입력하세요. >>> ");

			int num = 0;
			try {
				num = sc.nextInt(); // 여기가 예외처리 포인트
				System.out.println("num = " + num);
		
			} catch (InputMismatchException e) {
				System.out.println("예외발생 ");
				System.out.println("정상적인 숫자를 입력해주세요.");
			}
		
		
		
	}
}
