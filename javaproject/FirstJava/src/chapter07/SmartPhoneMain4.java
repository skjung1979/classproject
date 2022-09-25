package chapter07;

public class SmartPhoneMain4 {

	public static void main(String[] args) {

		// Phone 인스턴스 생성
		SmartPhone4 phone = new SmartPhone4("010-0000-0000","MyPhone");
		
		// 설치할 수 있는 애플리케이션 배열 생성과 초기화
		Application[] store = new Application[5];
		store[0] = new GameApp("지뢰찾기","microsoft",1000);
		store[1] = new GameApp("깨톡","카카5",1000);
		store[2] = new GameApp("프리쉘","microsoft",1000);
		store[3] = new GameApp("너튜브","국을",1000);
		store[4] = new GameApp("인별그램","얼굴책",1000);
		
		Application app = phone.getApplication(store, "너튜브");
		
		if(app != null) {
			phone.installApp(app);
		}else {
			System.out.println("스토어에 찾으시는 앱이 없습니다.");
		}
		
		Application installedApp = phone.getInstalledApp("너튜브");
		if(installedApp != null) {
			installedApp.displayAppInfo();
			installedApp.AppRun();
		}	
	}
}
