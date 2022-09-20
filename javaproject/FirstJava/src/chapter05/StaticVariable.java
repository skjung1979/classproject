package chapter05;

public class StaticVariable {
	
	static int cv;
	int iv;
	
	// 상수: 변하지 않는 수. 'final' 키워드를 삽입하여 선언한다.
	// 상수의 식별자는 모두 대문자로 표현한다!!!!
	static final float PI = 3.14f;
	
	public static void main(String[] args) {
		System.out.println(cv);
		// ★주의★ System.out.println(iv); // 사용 불가. iv가 static이 아니라서 그렇고
		// iv가 메인 메소드에서 호출되었기 때문에 사용이 불가한 것이고,
		// 일반 메소드에서 호출되면 사용 가능하다.
	}
	

}
