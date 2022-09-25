package chapter07;

public class UtilApp extends Application {

	public UtilApp(String appName, String company, int size) {
		super("UTIL",appName,company,size);
	}
	
	@Override
	public void AppRun() {
		System.out.println(">>>>>>>>>>> " + appName + " 유틸을 실행해서 사진을 편집합니다.");
	}
	
	
}
