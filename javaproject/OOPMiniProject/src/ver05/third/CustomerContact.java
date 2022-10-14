package ver05.third;

public class CustomerContact extends Contact {

//	② CustomerContact
//	회사, 거래처의 정보를 저장하는 하위 클래스를 정의합니다.
//	- 거래처회사이름, 거래품목, 직급 변수 추가
//	- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
	
	// 추가 변수 선언
	private String company;
	private String product;
	private String manager;
	
	// 생성자
	public CustomerContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String company, String product, String manager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.product = product;
		this.manager = manager;
	}

	// 게터, 세터
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

	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println("거래처명: " + this.company);
		System.out.println("품목명: " + this.product);
		System.out.println("담당자명: " + this.manager);
	}
		
	@Override
	public void showDate() {
		// 어떤 정보를 출력할까?
		
	}	
}
