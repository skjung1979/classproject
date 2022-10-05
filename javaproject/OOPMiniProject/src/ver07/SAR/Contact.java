package ver07.SAR;

public abstract class Contact implements ShowData{

	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birth;
	private String group;
		
	public Contact(String name, String phoneNumber, String email, String address, String birth, String group) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}
		
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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
				+ ", birth=" + birth + ", group=" + group + "]";
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if(o != null && o instanceof Contact) {
			Contact data = (Contact)o;
			if(this.name.equals(data.getName()) && this.phoneNumber.equals(data.getPhoneNumber())) {
				return true;
			}
		}
		return false;
	}
}
