package hio.controller;

import java.util.List;
import java.util.Scanner;

import hio.domain.HioMember;
import service.HioHallAdminService;
import service.HioReservInsertService;

public class HioHallAdminController implements HioHallAdminInterface{

	public void hallAdmin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("-----------------------------------------");
		System.out.println("---------------- 타석 관리 ----------------");
		List<HioMember> hallList = new HioHallAdminService().hallAdmin();
		System.out.println("|\t홀 번호\t예약(Y/N)\t시작시간\t종료시간\t|");
		for(HioMember hall : hallList) {
			System.out.println("|\t"+hall.getHallNo()+"\t"+ hall.getHallResvYN()+
					"\t"+hall.getHallsTime()+"\t"+hall.getHalleTime()+"\t|");
		}
		System.out.println("-----------------------------------------");
		System.out.println(" 1. 홀 추가");
		System.out.println(" 2. 예약 가능 여부 변경");
		System.out.println(" 3. 이용 시간 변경");
		System.out.println(" 4. 홀 삭제");
		System.out.println(" 5. 뒤로가기");
		System.out.print(" 메뉴 선택 >> ");
		int selectNo = Integer.parseInt(sc.nextLine());
		switch(selectNo) {
		case 1:
			System.out.print("예약 가능 여부를 입력 Y 또는 N >> ");
			String YN = sc.nextLine();
			
			System.out.print("이용 시작 시간 >> ");
			int stime = Integer.parseInt(sc.nextLine());
			
			System.out.print("이용 종료 시간 >> ");
			int etime = Integer.parseInt(sc.nextLine());
			
			int result = new HioHallAdminService().hallInsert(YN, stime, etime);
			if(result>0) {
				System.out.println("추가가 완료되었습니다.");
			}
			else {
				System.out.println("추가실패");
			}
			break;
		case 2:
			System.out.print("변경할 홀 번호 입력 >> ");
			int hallno = Integer.parseInt(sc.nextLine());
			
			System.out.print("예약 가능 여부를 입력 Y 또는 N >> ");
			String YN2 = sc.nextLine();
			
			int result2 = new HioHallAdminService().hallYNUpdate(hallno, YN2);
			if(result2>0) {
				System.out.println("변경이 완료되었습니다.");
			}
			else {
				System.out.println("변경실패");
			}
			break;
		case 3:
			System.out.print("변경할 홀 번호 입력 >> ");
			int hallno2 = Integer.parseInt(sc.nextLine());
			
			System.out.print("변경할 이용 시작 시간 입력 >> ");
			int sTime2 = Integer.parseInt(sc.nextLine());
			
			System.out.print("변경할 이용 종료 시간 입력 >> ");
			int eTime2 = Integer.parseInt(sc.nextLine());
			
			int result3 = new HioHallAdminService().hallTimeUpdate(hallno2, sTime2, eTime2);
			if(result3>0) {
				System.out.println("변경이 완료되었습니다.");
			}
			else {
				System.out.println("변경실패");
			}
			break;
		case 4:
			System.out.print("삭제할 홀 번호 입력 >> ");
			int hallno3 = Integer.parseInt(sc.nextLine());
			
			int result4 = new HioHallAdminService().hallDelete(hallno3);
			
			if(result4>0) {
				System.out.println("삭제가 완료되었습니다.");
			}
			else {
				System.out.println("삭제실패");
			}
			break;
		case 5:
			break;
		}
		
	}
}
