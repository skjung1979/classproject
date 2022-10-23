package book.controller;

public class ExitController implements Controller{

	@Override
	public void process() {

		System.exit(0);
		
	}
}
