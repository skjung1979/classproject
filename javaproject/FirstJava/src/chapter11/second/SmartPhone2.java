package chapter11.second;

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
		return name.compareTo(o.getName());
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














