package chapter03;

public class AssignmentOperator {

	public static void main(String[] args) {
		
		int num = 10;
		
		num += 5; // num = num + 5 --> num = 10 + 5
		System.out.println("num: "+ num);
		
		num -= 3; // num = num - 3 --> num = 15 - 3
		System.out.println("num: "+ num);
		
		num *= 2; // num = num * 2 --> num = 12 * 2
		System.out.println("num: "+ num);
		
		num /= 3; // num = num / 3 --> num = 24 / 3 --> 8
		System.out.println("num: "+ num);
		
		num %= 4; // num = num % 4 --> num = 8 % 4 --> 0
		System.out.println("num: "+ num);
		
		String str = "안녕하세요.";
		str += " 저는 정성균 입니다."; // str = str + "저는 정성균 입니다."
		str += " 프로그래머 입니다.";
		
		System.out.println(str);
		
	}
	
}
