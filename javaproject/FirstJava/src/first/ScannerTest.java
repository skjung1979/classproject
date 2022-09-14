package first;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {

		//java.util.Scanner in; // 이렇게 하거나
								// 맨 위에 import하고 Scanner in; 쓰거나
								// 하지만 풀네일을 쓰는 것보다 맨위에 import하는 것이 더 편리하다.

		Scanner in = new Scanner(System.in);
		
		System.out.print("이릅을 입력 해 주세요. >>> ");
		String name = in.nextLine(); // 문자열을 반환 하므로 반환한 문자열을 담을 변수를 선언(String name)해야한다.
		
		System.out.println("이름은 "+name+"이고,");
		
		System.out.print("나이를 입력 해 주세요. >>> ");
		int age = in.nextInt(); // 반환 받은 나이 값을 age변수에 담는다.
		
		System.out.println("나이는 "+age+"입니다.");
		
	}

}
