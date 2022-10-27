package hio.controller;

import java.util.ArrayList;
import java.util.List;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioHallAdminService;

//HIOtest 프로젝트
public class HioHallAdminController implements HioHallAdminInterface{

	HioHallAdminService service = new HioHallAdminService();
	HioMember hioMem = HioMain.hioMember;
	
	@Override
	public void hallAdmin() {

		while (true) {
		// 여기 현재 홀을 뿌려주고,
		List<HioMember> list = new ArrayList<>();
		
		list = service.allHallList();
		
		if (list != null && !list.isEmpty()) {
			for(HioMember h : list) {
				System.out.println(h.getHallNo() + " | " + h.getHallResvYN() + " | " + h.getHallsTime() + " | " + h.getHalleTime());
			}
		}
		
		hallMenu();
		
		// 1. 홀 추가
		// 2. 홀 변경 > 변경할 컬럼(YN / 시작시간 / 종료시간) 입력받기
		// 3. 홀 삭제
				
		System.out.println("원하시는 메뉴를 선택하세요. >>");
		int selHallMenu = Integer.parseInt(HioMain.sc.nextLine());
		
		switch (selHallMenu) {
		case 1: // 홀 추가
			break;
		case 2: // 홀 변경
			break;
		case 3: // 홀 삭제
			break;
		}
		
		
		
		
		}
	}
	
	void hallMenu() {
		
		System.out.println("----- 홀 메뉴 -----");
		System.out.println("1. 홀 추가");
		System.out.println("2. 홀 변경");
		System.out.println("3. 홀 삭제");
		System.out.println("-----------------");
				
	}
	
}
