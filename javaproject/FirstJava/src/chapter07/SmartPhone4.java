package chapter07;

public class SmartPhone4 extends Phone {

	String model;
//	GameApp[] gameApps;
//	UtilApp[] utilApps;
// 위 처럼 하지말고,,, 상속했으니 상위 클래스 타입의 배열 하나만 정의한다.
	Application[] installedApps;
	
//	int gameAppCnt = 0;
//	int utilAppCnt = 0;
// 위 변수들도 2개를 선언하지 않아도 된다.
	int cntOfApps;
	
	public SmartPhone4(String phoneNumber, String model) {
		super(phoneNumber);
		this.model = model;
//		gameApps = new GameApp[100];
//		utilApps = new UtilApp[100];
		installedApps = new Application[100];
		cntOfApps=0;
	}
	
//	void installApp(GameApp app) {
//		gameApps[gameAppCnt++] = app;
//		System.out.println(app.appName + " 앱을 설치했습니다.");
//	}
//	
//	void installApp(UtilApp app) {
//		utilApps[utilAppCnt++] = app;
//		System.out.println(app.appName + " 앱을 설치했습니다.");
//	}
// 위 처럼 앱마다 메소드를 만들지 않아도 아래 처럼 매개변수에 상위클래서의 변수를 입력한다.
	void installApp(Application app) {
		installedApps[cntOfApps++] = app;
		System.out.println(app.appName + " 앱을 설치했습니다.");
	}
	
	Application getApplication(Application[] storeApps, String name) {
		Application app = null;
		for(int i=0; i<storeApps.length; i++) {
			if(storeApps[i].appName.equals(name)) {
				app = storeApps[i];
			}
		}
		return app;
	}
	Application getInstalledApp(String name) {
		Application app = null;
		for(int i=0; i<cntOfApps; i++) {
			if(installedApps[i].appName.equals(name)) {
				app = installedApps[i];
			}
		}
		return app;
	}
	
	
	@Override
	void call() {
		super.call(); // super 키워드는 상위클래스를 가르키는 키워드
		System.out.println("이어팟을 이용해서 통화를 합니다.");
	}
}
