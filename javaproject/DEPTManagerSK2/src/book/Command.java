package book;

import java.util.HashMap;
import java.util.Map;
import book.controller.Controller;
import book.controller.SelectByController;
import book.controller.SelectController;

//project DEPTManagerSK2
public class Command {

	public Map<Integer, Controller> comm;
	
	public Command() {
		
		comm = new HashMap<>();
		comm.put(1, new SelectController());
		comm.put(2, new SelectByController());
		//comm.put(3, new InsertController());
		//comm.put(4, new UpdateController());
		//comm.put(5, new DeleteController());
		//comm.put(6, new ExitController());
			
	}
	
}
