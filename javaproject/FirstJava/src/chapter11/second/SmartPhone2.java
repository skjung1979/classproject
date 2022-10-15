package chapter11.second;

// HashSet 코딩한 클래스에서 이 클래스를 선언해서 사용하려 한다.
// Comparable<T>를 상속 받고,
// compareTo(), hashCode(), equals() 메소드를 오버라이딩해야한다.

public class SmartPhone2 implements Comparable<SmartPhone2>{
	
	private String name;
	private String phoneNumber;
	
	// 생성자
	public SmartPhone2(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// 게터
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// toString
	@Override
	public String toString() {
		return "SmartPhone2 [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}
	
	@Override
	public int compareTo(SmartPhone2 o) {
		return name.compareTo(o.getName()); // 뒤에 -1을 곱하면 역순 정렬이다!
	}

	@Override
	public int hashCode() {
		return phoneNumber.charAt(phoneNumber.length()-1);
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if (obj != null && obj instanceof SmartPhone2) {
			SmartPhone2 phone = (SmartPhone2) obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}
		return result;
		
	}
}














