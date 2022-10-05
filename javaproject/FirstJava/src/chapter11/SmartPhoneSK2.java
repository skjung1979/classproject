package chapter11;

public class SmartPhoneSK2 implements Comparable<SmartPhoneSK2>{
	private String name;
	private String phoneNumber;
	
	public SmartPhoneSK2(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// HashSet에서 중복 저장을 하지 않는다.
	// hashCode 참조 -> equals메소드로 비교	
	
	@Override
	public int hashCode() {
		return phoneNumber.charAt(phoneNumber.length()-1); // 0~9 값이 나옴
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		
		if(obj != null && obj instanceof SmartPhoneSK2) {
			SmartPhoneSK2 phone = (SmartPhoneSK2)obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}
		
		return result;
	}
	
	@Override
	public int compareTo(SmartPhoneSK2 o) {
		
		
		
		return name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		return "SmartPhoneSK2 [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
}
