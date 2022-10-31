package hio.controller;

import java.util.ArrayList;
import java.util.List;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioReservInsertService;

//HIOtest 프로젝트
public class HioReservInsertController implements HioReservInsertInterface{

	HioReservInsertService service = new HioReservInsertService();

	public int insertReserv() {
		int result = 0;
		
		HioMember hioMember = HioMain.hioMember;
		
		System.out.println("타석 예약을 진행합니다.");		
		
		List<HioMember> hallList = new ArrayList<>();

		
		// hall테이블에서 예약 가능이라고 되어 있는 홀 번호 리스트를 반환 받는다.
		hallList = service.selectPossHall();
		
		System.out.println("---------- 예약 가능한 홀 ----------");
		for(HioMember h : hallList) {
			System.out.print("|" + h.getHallNo() + "번 홀 |\t");
		}
		System.out.println();
		
		System.out.println("예약하실 홀번호를 선택해주세요. >> ");
		int hallNo = Integer.parseInt(HioMain.sc.nextLine());
		
		// 홀 테이블에서 >>> hallsTime과 halletime을 한개 행으로 반환 받는다.
		HioMember selectHallTime = service.selectHallTime(hioMember, hallNo);
		
		// 예약 테이블에서 >>> 홀번호와 예약 타임을 여러 행으로 반환 받는다.
		List<HioMember> resvTimeList = service.selectResvTimeList(hallNo);
		
		// 예약시작시간, 예약종료시간 변수 선언
		int sTime = hioMember.getHallsTime(); // 10
		int eTime = hioMember.getHalleTime(); // 18
		
		System.out.println(sTime + " | " + eTime);
		System.out.println("---------------------------");
		
		// sTime부터 eTime까지 반복문을 돌린다.
		for (int a=sTime; a<=eTime; a++) {
			
			// 예약 불가 및 예약 가능을 위한 구분 변수 선언
			boolean resv = false;
			
			// 예약 테이블의 홀번호와 예약타임 여러행 리스트
			for (HioMember resvTime : resvTimeList) {
				
				// 예약테이블의 예약타임이 홀테이블의 예약시작시간과 같으면 예약불가
				if (resvTime.getReservTime() == a) {
					System.out.println("-----" + a + "시 -----예약불가-----");
					resv = true; // 예약된 상태값
					break;
				}
				
			}
			if (!resv) {
				System.out.println("-----" + a + "시 -----예약가능-----");
			}
			
		}
		System.out.println("---------------------------");
		
		//if (reservListHall != null && !reservListHall.isEmpty()) {
		//	for(HioMember h : reservListHall) {
		//		System.out.println(h);
		//	}	
		//}
		
		int hallTime = 0;
		boolean check = false;
		
		// 조건에 맞지 않으면 계속 입력을 권유하기 위해 while문으로 반복한다.
		while (true) {
			
			System.out.println("예약하실 시간을 입력해주세요.");
			
			hallTime = Integer.parseInt(HioMain.sc.nextLine());
			
			for (HioMember resvTime : resvTimeList) {
				
				if (resvTime.getReservTime() == hallTime) {
					System.out.println("이미 예약되었는 시간입니다. 다른 시간을 입력해주세요.");
					check = true;
					break;
				} else {
					check = false;
				}
				
			}
			if (!check) {
				break;
			}
			
		}
		// 입력받은 hallno를 hioMember에 세팅한다.
		hioMember.setHallNo(hallNo);
		
		// 입력받은 예약시간을 hioMember에 세팅한다.
		hioMember.setReservTime(hallTime);
		
		result = service.insertReserv(hioMember);
		
		if (result > 0) {
			System.out.println("예약 완료!");
		}
		
		// 예약 번호 안내: 회원정보로 예약된 내역을 보여준다.
		List<HioMember> selectResNo = service.selectResNo(hioMember);
		
		System.out.println("---------- 예약 번호 ----------");
		
		for (HioMember resvNoList : selectResNo) {
			System.out.println(resvNoList.getReservNo());
		}
		
		
		
		return result;
	}
}
