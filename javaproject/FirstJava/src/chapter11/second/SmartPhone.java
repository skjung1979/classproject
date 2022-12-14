package chapter11.second;

//HashSet 코딩한 클래스에서 이 클래스를 선언해서 사용하려 한다.
//Comparable<T>를 상속 받고,
//compareTo(), hashCode(), equals() 메소드를 오버라이딩해야한다.

public class SmartPhone implements Comparable<SmartPhone>{

	private String name;
	private String phoneNumber;
	
	public SmartPhone(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	// 읽기 전용: 게터만 정의
	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	// HashSet에서 중복 저장하지 않는다면!...
	// hashCode값 참조 -> equals 메소드로 비교
	
	@Override
	public String toString() {
		return "SmartPhone [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		// 0~9 사이의 값
		return phoneNumber.charAt(phoneNumber.length()-1);
	}

	@Override
	public boolean equals(Object obj) {

		boolean result = false;
		
		if(obj != null && obj instanceof SmartPhone) {
			SmartPhone phone = (SmartPhone) obj;
			result = phoneNumber.equals(phone.getPhoneNumber());
		}	
		return result;
	}

	@Override
	public int compareTo(SmartPhone o) {
	
		return name.compareTo(o.getName())*-1; // 뒤에 -1을 곱하면 역순 정렬이다!
		
	}
	
	
	
	
	
	
}
