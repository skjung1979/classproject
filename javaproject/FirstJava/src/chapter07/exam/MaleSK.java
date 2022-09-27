package chapter07.exam;

public class MaleSK extends PersonSK {

	String nickName;

	public MaleSK(String name, String personNumber, String nickName) {
		super(name, personNumber);
		this.nickName = nickName;
	}
	
	void hi() {
		System.out.println("반갑습니다~!!!");
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.println();
		System.out.println("--이하는 오버라이딩해서 추가된것--");
		System.out.printf("별명은 %s 입니다.", nickName);
	}
	
	
	
	
}
