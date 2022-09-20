package chapter05.modifier;

public class Singletno {

	// 아래코딩의 목적은!!
	// 외부에서 무분별한 인스턴스 생성(new.. new.. )을 막고,
	// 사용할 수 있는 인스턴스 하나를 만들어서 제공하는 것이다.
	
	// 외부에서 인스턴스 생성을 하지 못하도록 private 처리했다.
	private Singletno(){
		
	}
	
	// 2. 사용할 수 있는 인스턴스 생성
	// static으로 시작 시점에 인스턴스 생성
	// 외부에서 참조 변수 s에 직접 참조하지 못하도록 private 입력
	private static Singletno s = new Singletno();
	
	// 3. 외부에서 사용할수 있는 참조값을 반환해주는 메소드를 제공해야한다.
	public static Singletno getInstance()
	{
		if(s==null) {
			s = new Singletno();
		}
		return s;
	}
	
}
