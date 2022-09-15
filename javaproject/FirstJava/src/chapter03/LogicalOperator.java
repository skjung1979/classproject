package chapter03;

public class LogicalOperator {

	public static void main(String[] args) {

		boolean chk1 = true;
		boolean chk2 = false;
		boolean chk3 = true;
		boolean chk4 = false;
		
		System.out.println(chk1 && chk3); // AND연산, 둘다 true니깐 결과는 당연히 true
		System.out.println(chk1 && chk2); // false
		System.out.println(chk2 && chk3); // false
		
		System.out.println("------------------");
		
		System.out.println(chk1 || chk3); // OR연산, 하나라도 true이면 결과는 무조건 true
		System.out.println(chk1 || chk2); // 하나라도 true이므로 결과는 true
		System.out.println(chk2 || chk3); // 하나라도 true이므로 결과는 true
		System.out.println(chk2 || chk4); // OR연산, 두개가 모두 false여야 결과가 false

	}

}
