package ver02;

class ContactSK // 패키지 내에서만 사용하기 위해 public 표기 안함
{
	// 변수 선언
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	// 생성자
	public ContactSK(String name, String phoneNumber, String email, String address, String birthday, String group)
	{
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	// getter, setter
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

	@Override
	public String toString() {
		return "ContactSK [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}	
	
	
	
	// 위 데이터를 출력하는 기능
	public void printInfo() {
		System.out.printf("이름 :%s", this.name+"\n");
		System.out.printf("전화번호 :%s", this.phoneNumber+"\n");
		System.out.printf("이메일 :%s", this.email+"\n");
		System.out.printf("주소 :%s", this.address+"\n");
		System.out.printf("생일 :%s", this.birthday+"\n");
		System.out.printf("그룹 :%s", this.group+"\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
