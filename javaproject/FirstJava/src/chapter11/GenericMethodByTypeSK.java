package chapter11;

public class GenericMethodByTypeSK {
	
	public <T> void hello(T t) {
		System.out.println("안녕하세요. " + t.toString() + "입니다.");
	}
	
	public static void main(String[] args) {
		GenericMethodByTypeSK byType = new GenericMethodByTypeSK();
		byType.<String>hello("정성균");
		byType.hello(10); // 메소드 앞에 타입 지정하지 않으면 매개변수에 따라 자동으로 타입 결정됨
	}

}
