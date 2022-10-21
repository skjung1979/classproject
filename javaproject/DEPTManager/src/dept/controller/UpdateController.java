package dept.controller;

import dept.Main;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.UpdateService;

public class UpdateController implements Controller {
	
	UpdateService service = new UpdateService(new OracleDao());
	
	public void process() {
		
		// 사용자 데이터 요청
		System.out.println("부서 정보 수정을 시작합니다.");
		System.out.println("수정할 부서 번호를 입력하세요. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		System.out.println("새로운 부서 이름 >> ");
		String dname = Main.sc.nextLine().trim();
		
		System.out.println("새로운 부서 위치 >> ");
		String loc = Main.sc.nextLine().trim();
				
		// 수정 처리
		int result = service.update(new Dept(deptno, dname, loc));
		
		// 결과 출력
		if (result>0) {
			System.out.println("수정되었습니다!");
		} else {
			System.out.println("수정 실패!");
		}
		
	}

}
