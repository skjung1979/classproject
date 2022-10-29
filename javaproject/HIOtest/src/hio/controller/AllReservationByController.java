package hio.controller;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.AllReservationByService;

public class AllReservationByController implements HioAllReservationInterface{

	
	AllReservationByService service = new AllReservationByService();
	
	public void allreservation() {
		
		System.out.println("검색할 예약 번호를 입력해주세요 >> ");
		int reservNo = Integer.parseInt(HioMain.sc.nextLine());
		
		HioMember hiomember = service.selectByreservNo(reservNo);
		
		System.out.println("=============== 검색 결과 ===============");
		if(hiomember != null) {
			System.out.println(hiomember);
		} else {
			System.out.println("검색한 예약 정보가 없습니다.");
		}
		
		
		
	}

}

