package chapter07;

public class SmartPhoneMain2 {

	public static void main(String[] args) {
		AndroidPhone androidPhone = new AndroidPhone("000-0000-0000");
		IPhone iphone = new IPhone("111-1111-1111");
		GooglePhone googlePhone = new GooglePhone("222-2222-2222");

		callByPhone(androidPhone);
		callByPhone(iphone);
		callByPhone(googlePhone);
	}
	
	static void callByPhone(Phone phone) { // 이렇게 선언하면 아래 메소드들이 필요 없다.
		// 메소드의 매개변수
		// Phone phone = androidPhone;
		System.out.println(phone.phoneNumber);
		phone.call();
	}
		
//	// 구글폰 추가
//	static void callByPhone(GooglePhone phone) {
//		phone.call();
//	}
//
//	// 안드로이드 폰
//	static void callByPhone(AndroidPhone phone) {
//		phone.call();
//	}
//
//	// 아이폰
//	static void callByPhone(IPhone phone) {
//		phone.call();
//	}



}
