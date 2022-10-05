package ver07;

	// ============ 강사님 문제 풀이 ================

	// 스마트폰의 연락처 정보
	// contact 클래스의 용도는? -> 데이터 저장
	// 인스턴스 생성 -> 변수의 메모리 생성 -> 데이터 저장

//public 지우면 패키지에서만 사용됨
abstract class Contact implements ShowData {

	/*
		저장 정보
			이름
			전화번호
			이메일
			주소
			생일
			그룹
		변수들은 직접 참조를 막아 캡슐화 처리를 하도록 합니다. 
	*/
	private String name;	// 친구 이름
	private String phoneNumber;	//
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	// 생성자
	public Contact() {

	}

	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {	
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	// 메소드 getter / setter
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
		System.out.println("이름: "+ this.name);
		System.out.println("전화번호: "+ this.phoneNumber);
		System.out.println("이메일: "+ this.email);
		System.out.println("주소: "+ this.address);
		System.out.println("생일: "+ this.birthday);
		System.out.println("그룹: "+ this.group);
	}

	// 단축키로 생성
	@Override
	public String toString() {
		return "contact_t [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}	
}
























