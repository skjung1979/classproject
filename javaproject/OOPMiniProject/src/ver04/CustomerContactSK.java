package ver04;

public class CustomerContactSK extends ContactSK {

	private String company;
	private String product;
	private String manager;
	
	public CustomerContactSK(
			String name, String phoneNumber, String email, 
			String address, String birthday, String group,
			String company, String product, String manager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.product = product;
		this.manager = manager;
	}

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("거래처이름: " + this.company);
		System.out.println("거래품목: " + this.product);
		System.out.println("담당자: " + this.manager);
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}
