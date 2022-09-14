package chapter03;

public class CharTypeOperator {

	public static void main(String[] args) {
		
		char c1 = 'A';
		
		int codeNum = c1 + 0; // char + int -> int + int로 바뀜
		
		System.out.println(codeNum);
		
		System.out.println(++c1); // B
		System.out.println(c1++); // B -> 출력 후 1증가 시키므로 c1은 C가 됨
		System.out.println(++c1); // D
		
	}
	
}
