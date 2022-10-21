package dept.controller;

import java.util.List;

import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.SelectService;

//project DEPTManagerSK
public class SelectController implements Controller{
	
	SelectService service = new SelectService(new OracleDao());
	
	public void process() {
		
		// 사용자의 요청을 처리할 서비스 처리 요청
		// 부서 전체 리스트 출력
		// List<Dept>
		
		List<Dept> list = service.select();
		
		if (list != null && !list.isEmpty()) {
			
			System.out.println("===== 전체 리스트 출력 =====");
			System.out.printf("%5s %15s %15s \n", "부서번호", "부서명", "위치");
			
			for (Dept d : list) {
				//System.out.println(d);
				System.out.printf("%5d %15s %15s \n", d.getDeptno(), d.getDname(), d.getLoc());	
			}
			System.out.println("===== 출력 완료 =====");
		} else {
			System.out.println("검색 결과 없음!");
		}	
	}
}
