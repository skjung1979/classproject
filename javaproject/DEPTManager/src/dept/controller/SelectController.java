package dept.controller;

import java.util.List;

import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.SelectService;

public class SelectController implements Controller {
	
	SelectService service = new SelectService(new OracleDao());	// SelectServie에서 생성자에 dao를 넣었기 때문에 여기에 매개변수로 필수한 dao를 넣으면 된다.(의존성을 낮춘 코딩!)
 	// 위 처럼 해야 서비스 별로 dao를 다르게 가져갈 수 있다.
	
	public void process() {
		
		// 사용자의 요청을 처리할 서비스로 처리 요청
		// 부서 전체 리스트를 출력
		// List<Dept>
		
		List<Dept> list = service.select();
		
		if (list != null && !list.isEmpty()) {
			
			for (Dept d : list) {
				System.out.println(d);
			}
			
		} else {
			System.out.println("검색 결과 없음!");
		}
		
	}
}
