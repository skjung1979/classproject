package hio.controller;

import java.util.List;
import java.util.regex.Pattern;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioReservInsertService;
import service.HioUpdateService;

public class HioUpdateController implements HioUpdateInterface {

	HioUpdateService service = new HioUpdateService();
	private HioMember[] hiomember;
	
	public void memberUpdate() {
		
		HioMember hioMember = HioMain.hioMember;
		
		System.out.println("예약변경을 시작합니다.");
		
		List<HioMember> selectResvNo = new HioReservInsertService().selectResvNo(hioMember);
		
		System.out.println("-------------------- 예약번호 --------------------");
		for(HioMember resvNoList : selectResvNo) {
			
			System.out.print(resvNoList.getReservNo()+"\t");
		}
		System.out.println();
		System.out.println("------------------------------------------------");
		
		System.out.println("예약번호를 입력해주세요. >> ");
		int reservNo = Integer.parseInt(getreservNo());

		System.out.println("변경하실 예약시간을 입력해주세요 >> ");
		
		int reservTime = Integer.parseInt(getreservTime());
		if(!(reservTime>=10 && reservTime<=18)) {
			System.out.println("10시부터 18시까지만 예약가능합니다.");
			
		} else {

			int result = service.memberUpdate(new HioMember(reservNo, reservTime));
	
			if (result > 0) {
				
				System.out.println("예약이 변경되었습니다.");
				
			} else {
				
				System.out.println("예약번호 및 예약가능 시간대를 다시 확인해주세요.");
				
			} 
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
				
				else if(!Pattern.matches("^[0-9]*$", reservNo)) {
					throw new Exception("숫자만 입력가능합니다.\n 다시 입력해주세요 >> ");
				}
				
				else {
					break;
				}
					
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return reservNo;
	}

	private String getreservTime() {
		
		String reservTime = null;
		int num = 0;
		
		while(true) {
			
			try {
				
				reservTime = HioMain.sc.nextLine();
				
				if(!(reservTime != null && reservTime.trim().length()!=0)) {
					throw new Exception("공백사용이 불가합니다.\n다시 입력해주세요 >> ");
				}
				
				else if(!Pattern.matches("^[0-9]*$", reservTime)) {
					throw new Exception("숫자만 입력가능합니다.\n다시 입력해주세요 >> ");
				} 
				
				else {
					break;
				}
					
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		return reservTime;
	}
	
}
