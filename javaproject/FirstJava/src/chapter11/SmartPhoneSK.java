package chapter11;

public class SmartPhoneSK implements Comparable<SmartPhoneSK>{
	
	private String name;
	private String phoneNumber;
	
	public SmartPhoneSK(String name, String phoneNumber) {
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
	
	// HashSet에서는 중복 저장을 하지 않는다.
	// hasCode 참조 -> equals메소드로 비교
	

	
	@Override
	public int hashCode() {
		// 0~9사이의 값이 나온다.
		return phoneNumber.charAt(phoneNumber.length()-1);
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		
		if(obj != null && obj instanceof SmartPhoneSK) {
			SmartPhoneSK phone = (SmartPhoneSK)obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}
		return result;
	}
	
	@Override
	public int compareTo(SmartPhoneSK o) {
		
		return name.compareTo(o.getName())*-1;
	}

	
	@Override
	public String toString() {
		return "SmartPhoneSK [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	
	

}
