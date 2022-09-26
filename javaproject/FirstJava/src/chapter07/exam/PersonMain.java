package chapter07.exam;

public class PersonMain {

	public static void main(String[] args) {

		Male m = new Male("SON", "971111-1011111","sonny");
		Female f = new Female("King", "00124-2222222","체육",3);
		
		m.printInfo();
		m.hi();
		
		System.out.println("------------");
		
		f.printInfo();
		
		System.out.println();
		f.printSchoolInfo();
		
		Person p1 = m;
		Person p2 = f;
		
		//p1.hi(); // hi()는 Person클래스의 멤버가 아니기 때문에 호출 불가
		
	}

}
