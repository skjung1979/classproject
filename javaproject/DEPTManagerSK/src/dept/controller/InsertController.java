package dept.controller;

import dept.Main;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.InsertService;

//project DEPTManagerSK
public class InsertController implements Controller{
	
	InsertService service = new InsertService(new OracleDao());
	
	public void process() {
		
		System.out.println("부서 데이터 입력을 시작합니다.");
		System.out.println("부서 번호를 입력해 주세요. >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		System.out.println("부서 이름을 입력해 주세요. >> ");
		String dname = Main.sc.nextLine().trim();
		
		System.out.println("부서 위치를 입력해 주세요. >> ");
		String loc = Main.sc.nextLine().trim();
		
		int result = service.insert(new Dept(deptno, dname, loc));
		
		if (result > 0) {
			System.out.println("데이터 입력 완료!");
		} else {
			System.out.println("데이터 입력 실패!");
		}	
	}
}
