package hio.controller;

import java.util.regex.Pattern;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioUpdateService;

public class HioUpdateController implements HioUpdateInterface {

	HioUpdateService service = new HioUpdateService();
	private HioMember[] hiomember;
	
	public void memberUpdate() {

		System.out.println("예약변경을 시작합니다.");

		System.out.println("예약번호를 입력해주세요. >> ");
		int reservNo = Integer.parseInt(getreservNo());
		
		System.out.println("변경하실 홀번호를 입력해주세요 >> ");
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
	
	private String getreservNo() {
		
		String reservNo = null;
		int num = 0;
		
		while(true) {
			
			try {
				
				reservNo = HioMain.sc.nextLine();
				
				if(!(reservNo != null && reservNo.trim().length()!=0)) {
					throw new Exception("공백사용이 불가합니다.\n다시 입력해주세요 >> ");
				}
				
				if(!Pattern.matches("^[0-9]*$", reservNo)) {
					throw new Exception("숫자만 입력가능합니다.\n 다시 입력해주세요 >> ");
				}
				
				boolean chk = false;
				
				for(int i=0; i<num; i++) {
					
					if(reservNo.equals(hiomember[i].getReservNo())) {
						chk = true;
						break;
					}
				} 
				
				if(!chk) {
					System.out.println("등록된 예약번호가 없습니다.\n다시 입력해주세요 >> ");
					
				} else {
					break;
				}
					
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return reservNo;
	}

}
