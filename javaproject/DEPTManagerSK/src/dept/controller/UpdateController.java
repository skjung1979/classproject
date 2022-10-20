package dept.controller;

import dept.Main;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.UpdateService;

//project DEPTManagerSK
public class UpdateController {
	
	UpdateService service = new UpdateService(new OracleDao());
	
	public void process() {
		
		System.out.println("수정할 부서 번호를 입력해주세요. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		System.out.println("수정할 부서 이름을 입력해주세요. >> ");
		String dname = Main.sc.nextLine();

		System.out.println("수정할 부서 위치를 입력해주세요. >> ");
		String loc = Main.sc.nextLine();
		
		int result = service.update(new Dept(deptno, dname, loc));
		
		if (result > 0) {
			System.out.println("수정 완료!");
		} else {
			System.out.println("수정 실패!");
		}
		
		
		
		
	}

}
