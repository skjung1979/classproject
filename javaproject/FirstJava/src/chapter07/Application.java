package chapter07;

public class Application {

	String type; // 어플리케이션 타입: 게임? 유틸? 등
	String appName; // 어플리케이셔 이름
	String company; // 앱 만든 회ㅏ
	int size;
	
	// 생성자
	public Application(String type, String appName, String company, int size) {
		this.type = type;
		this.appName = appName;
		this.company = company;
		this.size = size;
	}
	
	public void AppRun() {
		// 새로운 Application클래스에서 실행에 대한 정의할 예정
	}
	
	public void stop() {
		System.out.println(appName + " 앱을 종료합니다.");
	}
	
	public void displayAppInfo() {
		System.out.println("---------------");
		System.out.println("앱 종류: " + type);
		System.out.println("앱 이름: " + appName);
		System.out.println("앱 개발사: " + company);
		System.out.println("앱 사이즈: " + size);
		System.out.println("---------------");
	}

	@Override
	public String toString() {
		return "Application [type=" + type + ", appName=" + appName + ", company=" + company + ", size=" + size + "]";
	}
	
	

	
}
