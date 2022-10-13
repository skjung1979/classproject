package ver04.third;

// Contact를 상속 받음
public class CompanyContact extends Contact {
	
// CompanyContact
//		회사, 거래처의 정보를 저장하는 하위 클래스를 정의한다.
//		- 회사명, 부서명, 직급 변수 추가
//		- 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
	
	// 회사명, 부서명, 직급 변수 추가
	private String company;
	private String division;
	private String manager;
	
	// 상위 생성자를 상속받고, 회사명, 부서명, 직급 생성자 추가
	public CompanyContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String company, String division, String manager) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.division = division;
		this.manager = manager;
	}

	// 게터, 세터
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
	public void showData() {
		// TODO Auto-generated method stub
		
	}

	// 정보를 출력하는 메소드를 오버라이딩 해서 추가된 정보를 추가해서 출력
//	@Override
//	public void printInfo() {
//		super.printInfo();
//		System.out.println("회사이름: " + this.company);
//		System.out.println("부서이름: " + this.division);
//		System.out.println("직급: " + this.manager);
//	}
//
//	@Override
//	public void showData() {
//		// TODO Auto-generated method stub
//		
//	}
}
