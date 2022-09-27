package chapter07.exam;

public class FemaleSK extends PersonSK {

	String major;
	int grade;
	
	public FemaleSK(String name, String personNumber, String major, int grade) {
		super(name, personNumber);
		this.major = major;
		this.grade = grade;
	}
	
	void printSchoolInfo() {
		System.out.printf("전공은 %s이고, %d학년 입니다.", this.major, this.grade);
	}

	@Override
	void printInfo() {
		super.printInfo();
		System.out.println();
		System.out.println("--이하는 오버라이딩해서 추가된것--");
		printSchoolInfo();
	}
	
	
	
}
