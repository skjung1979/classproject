package dept.controller;

import java.util.List;

import dept.Main;
import dept.domain.Dept;
import dept.service.SelectByService;
import dept.service.SelectService;

public class SelectByController implements Controller {
	
	SelectByService service = new SelectByService();
	
	public void process() {
		
		System.out.println("검색 부서 번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		Dept dept = service.selectByDeptno(deptno);
		
		System.out.println("검색 결과 ================");
		if (dept != null) {
			System.out.println(dept);
		} else {
			System.out.println("검색한 부서의 정보가 없습니다.");
		}
	
	}
}
