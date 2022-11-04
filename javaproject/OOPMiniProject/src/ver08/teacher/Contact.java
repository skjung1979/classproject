package ver08.teacher;

import java.io.Serializable;
import ver08.teacher.ShowData;

public abstract class Contact implements ShowData, Serializable {
	
	// 변수 선언
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String group;
	
	// 생성자
	public Contact(String name, String phoneNumber, String email, String address, String birthday, String group) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;
	}

	// 게터, 세터
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
		return "Contact [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}

	// 연락처 정보 출력 메소드
	public void printInfo() {
		System.out.println("===== 연락처 정보 출력 =====");
		System.out.println("이름: " + this.name);
		System.out.println("전화번호: " + this.phoneNumber);
		System.out.println("이메일: " + this.email);
		System.out.println("주소: " + this.address);
		System.out.println("생일: " + this.birthday);
		System.out.println("그룹: " + this.group);
	}
}
