package ver09.teacher;

public class CustomerContact extends Contact{

	// 추가 변수 선언
	private String company;
	private String product;
	private String job;
	
	// 생성자
	public CustomerContact(String name, String phoneNumber, String email, String address, String birthday, String group,
			String company, String product, String job) {
		super(name, phoneNumber, email, address, birthday, group);
		this.company = company;
		this.product = product;
		this.job = job;
	}
	
	// printInfo()메소드 오버라이딩
	public void printInfo() {
		super.printInfo();
		System.out.println("거래처이름 : " + this.company);
		System.out.println("거래품목 : " + this.product);
		System.out.println("직급 : " + this.job);
	}
	
	@Override
	public void showDate() {
		System.out.println("이름: " + getName());
		System.out.println("전화번호: " + getPhoneNumber());	
	}	
}
