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
		List<HioMember> reservList = new ArrayList<>();
		List<HioMember> memList = new ArrayList<>();
		
		hallList = service.possReservListHall();
		reservList = service.possReservListReserv();
		memList = service.possReservListMem();
		
		System.out.println("---------- 예약 가능한 홀 ----------");
		for(HioMember h : hallList) {
			System.out.print("|" + h.getHallNo() + "번 홀 |\t");
		}
		
		
		
		//if (reservListHall != null && !reservListHall.isEmpty()) {
		//	for(HioMember h : reservListHall) {
		//		System.out.println(h);
		//	}	
		//}
		
		
		
		
		return result;
	}
}
