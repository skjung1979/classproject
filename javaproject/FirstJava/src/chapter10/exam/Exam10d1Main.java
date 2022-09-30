package chapter10.exam;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exam10d1Main {

	public static void main(String[] args) {

//		10. 콘솔에서 사용자 아이디를 입력 받아 
//		정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다. 
//		① 사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
//		② 예외 클래스 이름은 BadIdInputException이라고 정의합시다.

		// 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다. 
		// 'a' <= c <= 'z' || 'A' <= c <= 'Z' || '0' <= c <= '9'   < 이것이 조건의 정상적인 입력 범위 이다!!!
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아이디를 입력하세요.(영문자,숫자만) >>> ");
		String id = sc.nextLine(); //  "12ABCabc!";
		boolean chk1 = Pattern.matches("^[a-z0-9A-Z]*$", id); // ==> 영문자와 숫자 조합의 패턴
		// ^: 패턴의 시작 / $: 패턴의 종료 / *: 앞의 문자패턴이 있는지 없는지 / +: 반드시 들어가야한다.
		System.out.println(chk1?"Good":"Try again");
			
		try {
			if (!chk1) {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("소문자, 대문자, 숫자 입력만 가능합니다.");
		}
		
		
		// * 패턴 정리 *
		// 숫자만 => ^[0-9]*$
		// 영문자만(대소문자) => ^[a-zA-Z]*$
		// 한글만 => ^[가-힣]*$
		// 영어+숫자 => ^[a-z0-9A-Z]*$
		// 이메일 => ^[a-zA-Z0-9]+@+[a-zA-Z0-9]\.+[a-zA-Z]+$
		// 핸드폰 번호 => ^\d{3}-\d{4}-\d{4}+$    => {자리수}      \d: 숫자
		// ? :  물음표 앞의 문자가 하나이거나 없거나
		// | : or
		// . : 임의의 하나의 문자
		// \. : dot
		// \w : 알파벳 + 숫자
		// \d : 숫자 [0-9]
	}

}
