package hio.controller;

import java.util.List;
import java.util.Scanner;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioHallDeleteService;

public class HioHallDeleteController implements HioHallDeleteInterface {


	HioHallDeleteService service = new HioHallDeleteService();

	@Override
	public void hallDelete() {

		List<HioMember> allList = service.getReservationList();

		System.out.println("예약된 타석을 취소합니다.");
		System.out.println("현재 예약된 타석 리스트");

		if (allList != null && !allList.isEmpty()) {
			
			System.out.println("-------------------- 예약번호 --------------------");
			for (int i = 0; i < allList.size(); i++) {
				System.out.print(allList.get(i).getReservNo()+"\t");
			}
			System.out.println("\n------------------------------------------------");

			System.out.print("취소할 타석 번호를 입력해주세요. >> ");
			int reservNo = Integer.parseInt(HioMain.sc.nextLine().trim()) ;

			System.out.println(reservNo);

//			HioMember hioMember = service.hallSelectToDelete(reservNo);

			int result = 0;
			
//			if (hioMember != null) {
				result = new HioHallDeleteService().hallDelete(reservNo);

//			} else {
//				System.out.println("예약된 타석이 없음");
//			}

		}
	}

}
