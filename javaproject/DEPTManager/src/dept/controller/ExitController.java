package dept.controller;

public class ExitController implements Controller {
	
	public void process() {
		
		System.out.println("포그램을 종료합니다.");
		System.exit(0);
		
	}

}
