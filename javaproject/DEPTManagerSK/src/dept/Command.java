package dept;

import java.util.HashMap;
import java.util.Map;
import dept.controller.Controller;
import dept.controller.DeleteController;
import dept.controller.ExitController;
import dept.controller.InsertController;
import dept.controller.SelectByController;
import dept.controller.SelectController;
import dept.controller.UpdateController;

//project DEPTManagerSK
public class Command {
	
	public Map<Integer, Controller> comm;
	
	// 생성자
	public Command() {
		comm = new HashMap<>();
		comm.put(1, new SelectController());
		comm.put(2, new SelectByController());
		comm.put(3, new InsertController());
		comm.put(4, new UpdateController());
		comm.put(5, new DeleteController());
		comm.put(6, new ExitController());
	}
}
