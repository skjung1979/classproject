package hio.controller;

import java.util.List;
import java.util.Scanner;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioReservInsertService;

public class HioHallReservChkController implements HioHallReservChkInterface{
	public void reservChkSelect() {
		
		HioMember hioMember = HioMain.hioMember;
		
		Scanner sc = new Scanner(System.in);
			
			System.out.println("------------------------------------------------");
			System.out.println("---------------- 예약 가능 여부 확인 ----------------");
			
			List<HioMember> hallList = new HioReservInsertService().selectHallList();
			System.out.println("------------------- 예약가능 홀 -------------------");
			
			for(HioMember hio : hallList) {
				System.out.print("| "+ hio.getHallNo() + "번 홀 |\t");
			}
			System.out.println();
			
			System.out.print("홀 번호를 입력해주세요. >>");
			int hallno = Integer.parseInt(sc.nextLine());
			
			HioMember selectHallTime = new HioReservInsertService().selectHallTime(hioMember, hallno);
			
			List<HioMember> resvTimeList =new HioReservInsertService().selectResvTimeList(hallno);
			
			int stime = hioMember.getHallsTime();
			int etime = hioMember.getHalleTime();
				System.out.println("------------------------------------------------");
			for(int a=stime; a<=etime; a++) {
				boolean resv = false;
				for(HioMember resvtime : resvTimeList) {
					if(resvtime.getReservTime() == a) {
						System.out.println("|----- "+a+"시 --------------------- 예약불가 -------|");
						resv = true;
						break;
					}
				}
				if(!resv) {
					System.out.println("|----- "+a+"시 --------------------- 예약가능 -------|");
				}
				
			}
				System.out.println("------------------------------------------------");
	
	}
}
