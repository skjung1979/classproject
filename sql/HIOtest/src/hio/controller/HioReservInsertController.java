package hio.controller;

import java.util.List;
import java.util.Scanner;

import hio.HioMain;
import hio.domain.HioMember;
import service.HioMemberInsertService;
import service.HioReservInsertService;

public class HioReservInsertController implements HioReservInsertInterface{

	public int reservInsert() {
		
		int result = -1;
		
		HioMember hioMember = HioMain.hioMember;
		
		Scanner sc = new Scanner(System.in);
			
			System.out.println("------------------------------------------------");
			System.out.println("-------------------- 타석예약 --------------------");
			
			System.out.println(hioMember.getMemberGrade());
			System.out.println(hioMember.getMemberNo());
			
			List<HioMember> hallList = new HioReservInsertService().selectHallList();
			System.out.println("------------------- 예약가능 홀 -------------------");
			
			for(HioMember hio : hallList) {
				System.out.print("| "+ hio.getHallNo() + "번 홀 |\t");
			}
			System.out.println();
			
			System.out.print("예약하실 홀 번호를 입력해주세요 >>");
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
			
			int halltime = 0;
			boolean chk = false;
			while(true) {
				System.out.print("예약하실 시간을 입력해주세요 >>");
				halltime = Integer.parseInt(sc.nextLine());
				
				for(HioMember resvTime : resvTimeList) {
					if(resvTime.getReservTime() == halltime) {
						chk = true;
						System.out.println("이미 예약되어있는 시간입니다.");
						break;
					}
					else {
						chk = false;
					}
				}
				if(!chk) {
					break;
				}
			}
			
			hioMember.setHallNo(hallno);
			hioMember.setReservTime(halltime);
			
			result = new HioReservInsertService().reservInsert(hioMember);

		
			return result;
		}
}
