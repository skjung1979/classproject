package chapter09.exam;

public class PersonT {

	String name;
	String personNumber;
	
	public PersonT(String name, String personNumber) {
		super();
		this.name = name;
		this.personNumber = personNumber;
	}

	// 주민번호가 같은 같은 인스턴스로 판별하는 프로그램을 만들어봅시다.
	// 가전: "000000-0000000"
	@Override
	public boolean equals(Object obj) {

		boolean result = false;

		// 매개변수로 전달받은 객체와 비교: 주민번호
		if(obj != null && obj instanceof PersonT) {
			PersonT person = (PersonT)obj;
			result = this.personNumber.equals(person.personNumber);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		PersonT p1 = new PersonT("SON","000000-1111111");
		PersonT p2 = new PersonT("Park","111111-1111111");
		PersonT p3 = new PersonT("Hwang","000000-1111111");
		
		System.out.println("p1과 p2는 같은 사람인가? => "+ p1.equals(p2));
		System.out.println("p1과 p3는 같은 사람인가? => "+ p1.equals(p3));
		
	}
	

	
}
