package ver02;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		SmartPhone smartPhone = SmartPhone.getInstance(); // 싱글톤이라 이렇게 생성.. new 사용 못함

		// 입력
		smartPhone.insertContact();
		
		// 전체 출력
		smartPhone.printAllData();
		
		// 이름 검색 후 결과 출력
		smartPhone.searchInfoPrint();

		
		
		
	}

}
