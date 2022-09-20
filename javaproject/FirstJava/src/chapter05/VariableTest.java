package chapter05;

public class VariableTest {
	
	int iv = StaticVariable.cv; // 이것도 가능
	int iv2;
	
	static int cv;	// 
	
	public static void main(String[] args) {
		
		// ★주의★ 메인메소드 블록 안내서 클래스 변수를 참조할 때는 클래스이름.변수이름
		System.out.println(StaticVariable.cv);
		System.out.println(StaticVariable.PI);
		

	}

}
