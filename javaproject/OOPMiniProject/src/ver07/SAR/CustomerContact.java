package ver07.SAR;

class CustomerContact extends Contact {
	private String company;
	private String item;
	private String position;

	public CustomerContact(String name, String phoneNumber, String eMail, String address, String birth, String group,
			String company, String item, String position) {
		super(name, phoneNumber, eMail, address, birth, group);
		this.company = company;
		this.item = item;
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return item;
	}

	public void setDepartment(String item) {
		this.item = item;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public void showData() {
		System.out.println("******* 연락처 정보");

		System.out.println("이름: " + super.getName());
		System.out.println("전화번호: " + super.getPhoneNumber());
		System.out.println("e-mail: " + super.getEmail());
		System.out.println("생일: " + super.getBirth());
		System.out.println("주소: " + super.getAddress());
		System.out.println("그룹: " + super.getGroup());

		System.out.println("******* 거래처 정보");

		System.out.println("거래처: " + company);
		System.out.println("거래 물품: " + item);
		System.out.println("직책: " + position);
	}

}