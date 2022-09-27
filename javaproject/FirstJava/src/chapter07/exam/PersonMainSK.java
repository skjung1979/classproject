package chapter07.exam;

public class PersonMainSK {

	public static void main(String[] args) {
		
		MaleSK m = new MaleSK("SON","971111-1011111","쏘니");
		FemaleSK f = new FemaleSK("King", "001204-4222222","축구",4);
		
		m.printInfo();
		m.hi();
		
		System.out.println("--------------");
		
		f.printInfo();
		System.out.println();
	

	}

}
