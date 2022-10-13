package ver04.second;

// Contact 클래스의 용도 -> 데이터 저장
// 인스턴스 생성 -> 변수의 메모리 생성 -> 데이터 저장(출력은 안하고 저장만 한다?)
// 클래스는 하나의 역할만 담당하도록 설계한다.
abstract class Contact implements ShowData {
	
	private String name; 		// 친구 이름
	private String phoneNumber; // - 폰번호
	private String email; 		// - 이메일
	private String address; 	// - 주소
	private String birthday; 	// 생일
	private String group; 		// - 그룹
	
	// 생성자
	public Contact() {
	
	}
	
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}


	// 케터, 세터
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	// 위 데이터를 출력하는 기능
	public void printInfo() {
		System.out.println("===== 친구 정보 =====");
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("이메일: " + this.email);
		System.out.println("주소: " + this.address);
		System.out.println("생일: " + this.birthday);
		System.out.println("그룹: " + this.group);
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}
}


















