package dept.controller;

import java.sql.Connection;

import dept.Main;
import dept.dao.Dao;
import dept.dao.OracleDao;
import dept.domain.Dept;
import dept.service.InsertService;
import dept.util.ConnectionProvider;

public class InsertController implements Controller {
	
	InsertService service = new InsertService(new OracleDao());
	
	// 전달자
	public void process() {
	
		System.out.println("부서 정보 입력을 시작합니다.");
		System.out.println("부서 번호 >> ");
		int deptno = Integer.parseInt(Main.sc.nextLine());
		
		System.out.println("부서 이름 >> ");
		String dname = Main.sc.nextLine();
			
		System.out.println("위치 >> ");
		String loc = Main.sc.nextLine();

		int result = service.insert(new Dept(deptno, dname, loc));
		
		if (result>0) {
			System.out.println("입력되었습니다.");
		} else {
			System.out.println("입력 실패!!!");
		}	
	}
}
