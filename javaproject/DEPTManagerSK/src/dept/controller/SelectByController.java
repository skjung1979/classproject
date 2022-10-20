package dept.controller;

import dept.Main;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.SelectByService;

//project DEPTManagerSK
public class SelectByController {
	
	SelectByService service = new SelectByService(new OracleDao());

	public void process() {
		
		System.out.println("검색 부서 번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		Dept dept = service.selectByDeptno(deptno);
		
		System.out.println("검색 결과 ==============");
		System.out.printf("%5s %15s %15s \n", "부서번호", "부서명", "위치");
		if (dept != null) {
			//System.out.println(dept);
			System.out.printf("%5d %15s %15s \n", dept.getDeptno(), dept.getDname(), dept.getLoc());	
		} else {
			System.out.println("검색한 부서의 정보가 없습니다.");
		}
		
	}
	
}
