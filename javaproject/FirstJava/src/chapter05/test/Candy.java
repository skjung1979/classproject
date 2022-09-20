package chapter05.test;


public class Candy {

	static int width = 100;
	static int height = 100;
	String type;
	
	Candy(String type)
	{
		this.type = type; 	// 초기화
		width = 100;
		height = 100;
	}
	
	public static void main(String[] args) {

		
		// 인스턴스 8개 생성시 -> 변수 24개 생성됨
		// 이런 경우는 인스턴스 변수를 static 변수(5,6Line)로 바꿔야 메모리 낭비를 줄일 수 있다.
		Candy c1 = new Candy("허브");
		Candy c2 = new Candy("딸기");
		Candy c3 = new Candy("포도");
		Candy c4 = new Candy("오렌지");
		Candy c5 = new Candy("샤인머스켓");
		Candy c6 = new Candy("초코");
		Candy c7 = new Candy("자두");
		Candy c8 = new Candy("메론");
	}
	
}
