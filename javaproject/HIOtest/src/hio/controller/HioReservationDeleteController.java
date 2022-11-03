package hio.controller;

import java.util.List;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioReservationDeleteService;

//HIOtest 프로젝트
public class HioReservationDeleteController {

	HioReservationDeleteService service = new HioReservationDeleteService();
	
	public void deleteReserv(HioMember hioMember) {

		System.out.println("예약된 타석을 취소합니다.");
		System.out.println("현재 예약리스트의 예약번호 입니다.");
//		System.out.println(hioMember.getMemberNo());
		List<HioMember> allList = service.selectReservation(hioMember);

		if (allList != null && !allList.isEmpty()) {
			
//			for (HioMember h : allList) {
			for (int i=0; i<allList.size(); i++) {
				
				System.out.print(allList.get(i).getReservNo()+ "\t");
				if (i%4==0 && i != 0) {
					System.out.println();
				}
			}
			System.out.println();
			
		}
		
		System.out.println("취소하실 예약 번호를 입력해주세요. >> ");
		int delResv = Integer.parseInt(HioMain.sc.nextLine());
		
		int result = service.deleteReservation(hioMember, delResv);
		
	}

}




















