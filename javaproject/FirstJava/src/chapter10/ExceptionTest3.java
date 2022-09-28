package chapter10;

public class ExceptionTest3 {

	public static void main(String[] args){
		
		try {
			check1();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	static void check1() throws ClassNotFoundException {// 호출한 쪽에서 예외처리해라!! 메인메소드
		check2();
	}
	
	static void check2() throws ClassNotFoundException { // 호출한 쪽에서 예외처리해라!!check1()
		
		Class.forName("NULL");
		
	}

}
