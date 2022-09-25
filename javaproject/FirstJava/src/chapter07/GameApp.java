package chapter07;

public class GameApp extends Application{

	public GameApp(String appName, String company, int size) {
		super("GAME", appName, company, size);
	}

	@Override
	public void AppRun() {
		System.out.println(">>>>>>>>>>> " + appName + " 게임을 시작합니다.");
	}
	
	
	
}
