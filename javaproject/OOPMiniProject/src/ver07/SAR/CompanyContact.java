package ver07.SAR;

class CompanyContact extends Contact {
	private String company;
	private String department;
	private String position;

	public CompanyContact(String name, String phoneNumber, String eMail, String address, String birth, String group,
			String company, String department, String position) {
		super(name, phoneNumber, eMail, address, birth, group);
		this.company = company;
		this.department = department;
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

		System.out.println("******* 회사 정보");

		System.out.println("회사: " + company);
		System.out.println("부서: " + department);
		System.out.println("직책: " + position);
	}
}