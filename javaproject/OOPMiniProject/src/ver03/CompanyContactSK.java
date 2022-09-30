package ver03;

public class CompanyContactSK extends ContactSK {

	private String company;
	private String division;
	private String manager;
	
	public CompanyContactSK(
			String name, String phoneNumber, String email, 
			String address, String birthday, String group,
			String company, String division, String manager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.division = division;
		this.manager = manager;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("회사이름: " + this.company);
		System.out.println("부서이름: " + this.division);
		System.out.println("직급: " + this.manager);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "CompanyContactSK [company=" + company + ", division=" + division + ", manager=" + manager + "]";
	}
}
