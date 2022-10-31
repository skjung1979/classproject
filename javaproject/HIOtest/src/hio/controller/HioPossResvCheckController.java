package hio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioPossResvCheckService;

//HIOtest 프로젝트
public class HioPossResvCheckController {
	
	HioPossResvCheckService service = new HioPossResvCheckService();
	
	

	public void possResvCheck() {

		HioMember hioMember = HioMain.hioMember;
		
		System.out.println("예약 가능 여부를 확인합니다.");
		
		
		
		List<HioMember> hallList = service.possResvCheck();
		
		for(HioMember h: hallList) {
			System.out.println("|\t" + h.getHallNo() + "홀\t|\t");
		}
		
		System.out.println("원하시는 홀 번호를 선택해주세요.");
		int hallNo = Integer.parseInt(HioMain.sc.nextLine());
		
		// hall테이블에서 입력한 홀번호의 예약시간시간, 예약종료시간 필드 리스트를 가져온다. 행이 하나이므로!
		HioMember hallListByHallNo = service.hallListByHallNo(hallNo);
		
		int sTime = hallListByHallNo.getHallsTime();
		int eTime = hallListByHallNo.getHalleTime();
		//int sTime = hioMember.getHallsTime();
		//int eTime = hioMember.getHalleTime();
		
		// 예약테이블에서 입력한 홀번호의 예약시간 필드 리스트를 가져온다.
		List<HioMember> resvList = service.resvList(hallNo);
		
		// sTime부터 eTime까지 반복문을 돌린다.
		for (int a=sTime; a<=eTime; a++) {
			
			// 예약 불가 및 예약 가능을 구분하기 위한 변수 선언
			boolean resv = false;
			
			// 예약 테이블의 홀번호와 예약시간 여러행 리스트
			for(HioMember h : resvList) {
			
					// 예약 테이블의 예약시간이 홀테이블의 예약시간과 같지 않으면 예약가능
					if (h.getReservTime() == a) {
						System.out.println(a + "시 : 예약불가");
						resv = true;
						break;
					}
				
			}
			if (!resv) { // h.getReservTime() == a 이 구문과 반대되는 상황이라서 resv를 사용한다.
			//if (h.getReservTime() != a) {
				System.out.println(a + "시 : 예약가능");
			}
		}
		
		
	}

}














