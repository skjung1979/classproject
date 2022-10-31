package hio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioResvUpdateService;

//HIOtest 프로젝트
public class HioResvUpdateController {

	HioResvUpdateService service = new HioResvUpdateService();
	
	public void upateReserv() {

		System.out.println("예약 변경을 진행합니다.");

		List<HioMember> reservList = service.reservList();
		

		for(HioMember h : reservList) {
			System.out.println(h.getReservNo());		
		}

		System.out.println("리스트에서 변경하실 예약 번호를 입력해주세요. >>> ");
		int upReservNo = Integer.parseInt(HioMain.sc.nextLine());

		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();	
		
		int hallNo = 0;
		int reTime = 0;	
		
		for(HioMember h : reservList) {

			if (upReservNo == h.getReservNo()) {

				hm.put(h.getReservNo(), h.getReservTime());
				hallNo = h.getHallNo();
				reTime = h.getReservTime();
			}

		}
		List<HioMember> hallList = service.hallList(hallNo);
		
		int upReservTime = 0;
		
		while (true) {

			System.out.println("변경하실 예약 시간을 입력해주세요. (현재값: " + hm.values().toString().replace("[", "") + ") >> ");
			upReservTime = Integer.parseInt(HioMain.sc.nextLine());

			// hallList의 결과가 한개 행이므로 get(0)으로 비교함.
			if (!(upReservTime>=hallList.get(0).getHallsTime() && upReservTime<=hallList.get(0).getHalleTime() && upReservTime != reTime)) {

				// 입력한 주문번호의 홀번호를 기준으로 예약시간을 출력 -> 이 리스트의 값은 기존 값이라 입력하지 않도록 하려함.
				List<HioMember> curResvList = new ArrayList<>();
				
				curResvList = service.curResvList(hallNo, reTime);
				
				System.out.println(hallList.get(0).getHallsTime() + "시 부터 " + hallList.get(0).getHalleTime() + "시 사이의 시간을 입력해주시고,");
				System.out.println("아래 시간은 제외하고 입력해주세요.");
				for(HioMember h: curResvList) {
					System.out.print(h.getReservTime() + "시 \t");
				}
				System.out.println();

			} else {
				
				break;
			}

		}
		
		int result = service.updateResevtime(upReservNo, upReservTime);
		
		if (result > 0) {
			System.out.println("예약시간 변경 완료!");
		}
		
	}

}














