package dept.controller;

import dept.Main;
import dept.dao.OracleDao;
import dept.service.DeleteService;

//project DEPTManagerSK
public class DeleteController {

	DeleteService service = new DeleteService(new OracleDao());
	
	public void process() {
		
		System.out.println("삭제할 부서번호를 입력해주세요. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		int result = service.delete(deptno);
		
		if (result > 0) {
			System.out.println("삭제 완료!");
		} else {
			System.out.println("삭제 실패!");
		}		
	}
}
