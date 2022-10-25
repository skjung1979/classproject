package hio.controller;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioUpdateService;

public class HioUpdateController implements HioUpdateInterface {

	HioUpdateService service = new HioUpdateService();

	public void memberUpdate() {

		System.out.println("예약변경을 시작합니다.");

		System.out.println("예약번호를 입력해주세요. >> ");
		int reservNo = Integer.parseInt(HioMain.sc.nextLine());

		System.out.println("변경하실 예약일자를 입력해주세요 >> ");
		int hallNo = Integer.parseInt(HioMain.sc.nextLine());

		System.out.println("변경하실 예약시간을 입력해주세요 >> ");
		int reservTime = Integer.parseInt(HioMain.sc.nextLine());

		int result = service.memberUpdate(new HioMember(reservNo, hallNo, reservTime));

		if (result > 0) {
			System.out.println("예약이 변경되었습니다.");
		} else {
			System.out.println("변경가능한 시간대를 다시 확인해주세요.");
		}

	}


}
