package ver02;

public class SmartPhoneMain {

	public static void main(String[] args) {
		
		SmartPhone smartPhone = SmartPhone.getInstance(); // 싱글톤이라 이렇게 생성.. new 사용 못함

		// 입력
		smartPhone.insertContact();
		System.out.println();
		
		// 전체 출력
		smartPhone.printAllData();
		System.out.println();
		
		// 이름 검색 후 결과 출력
//		smartPhone.searchInfoPrint();
//		System.out.println();
		
		// 이름 검색 후 정보 수정
		smartPhone.editContact();
		smartPhone.searchInfoPrint();
		smartPhone.printAllData();
		
		
		
		// 데이타가 없는 이름으로 검색 후 삭제
//		smartPhone.deleteContact();
//		smartPhone.searchInfoPrint();
//		smartPhone.printAllData();
//		System.out.println();
		
		// 데이타가 있는 이름으로 검색 후 삭제
//		smartPhone.deleteContact();
//		smartPhone.searchInfoPrint();
//		smartPhone.printAllData();
		
		
	}

}
