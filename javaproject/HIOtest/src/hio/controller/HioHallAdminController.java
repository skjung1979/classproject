package hio.controller;

import java.util.ArrayList;
import java.util.List;

import hio.HioMain;
import hio.domain.HioMember;
import hio.service.HioHallAdminService;
import oracle.security.o5logon.d;

//HIOtest 프로젝트
public class HioHallAdminController implements HioHallAdminInterface{

	HioHallAdminService service = new HioHallAdminService();
	HioMember hioMem = HioMain.hioMember;

	@Override
	public void hallAdmin() {

		// 여기 현재 홀을 뿌려주고,
		List<HioMember> list = new ArrayList<>();

		list = service.allHallList();

		if (list != null && !list.isEmpty()) {
			for(HioMember h : list) {
				System.out.println(h.getHallNo() + " | " + h.getHallResvYN() + " | " + h.getHallsTime() + " | " + h.getHalleTime());
			}
		}

		hallMenu();

		// 1. 홀 추가
		// 2. 홀 변경 > 변경할 컬럼(YN / 시작시간 / 종료시간) 입력받기
		// 3. 홀 삭제

		System.out.println("원하시는 메뉴를 선택하세요. >>");
		int selHallMenu = Integer.parseInt(HioMain.sc.nextLine());

		switch (selHallMenu) {
		case 1: // 홀 추가

			System.out.println("--------- 홀 추가를 진행합니다.----------");

			while (true) {

				int bk = 1; // 메뉴 이동에 참고할 변수

				System.out.print("추가할 홀 번호를 입력하세요 >> ");
				int newHallNo = Integer.parseInt(HioMain.sc.nextLine());

				for (int i=0; i<list.size(); i++) {
					if (newHallNo == list.get(i).getHallNo()) {
						System.out.println("이미 존재하는 홀 번호 입니다. 다시 입력해주세요.");
						bk = 1 ;
						break;
					} else {
						hioMem.setHallNo(newHallNo);
						bk = 0;
					}
				}
				if (bk != 1) {
					break;
				}  
			}

			System.out.print("추가할 홀의 예약 가능 여부를 입력해주세요. (Y or N) >> ");
			String newHallYN = HioMain.sc.nextLine();

			System.out.print("추가할 홀의 예약 시작 시간을 입력해주세요. >> ");
			int newHallsTime = Integer.parseInt(HioMain.sc.nextLine());

			System.out.print("추가할 홀의 예약 종료 시간을 입력해주세요. >> ");
			int newHalleTime = Integer.parseInt(HioMain.sc.nextLine());

			hioMem.setHallResvYN(newHallYN);
			hioMem.setHallsTime(newHallsTime);
			hioMem.setHalleTime(newHalleTime);

			int result = service.insertHall(hioMem);

			if (result > 0) {
				System.out.println("홀이 추가 되었습니다.");
			} else {
				System.out.println("홀 추가 실패!");
			}

			break;
		case 2: // 홀 변경

			int index = 0;
			
			System.out.println("홀 변경을 진행합니다.");
			
			while (true) {

				System.out.print("변경할 홀을 선택해주세요. >> ");
				int selHall = Integer.parseInt(HioMain.sc.nextLine());
				int t = 0;
				
				
				for(int i=0; i<list.size(); i++) {

					if (selHall == list.get(i).getHallNo()) { // 홀번호를 리스트 중에 맞게 입력한 경우

						hioMem.setHallNo(selHall);
						t = 1;
						index = i;

					}
				}
				if (t == 1) {
					break;
				} else {
					System.out.println("존재하지 않는 홀번호 입니다. 다시 입력해주세요.");
					continue;
				}

			}
			System.out.println("변경할 항목을 선택해주세요. >> ");
			System.out.println("1. 예약가능여부 | 2. 시작시간 | 3. 종료시간");
			int selCat = Integer.parseInt(HioMain.sc.nextLine());

			switch (selCat) {
			case 1: // 예약 가능 여부
				System.out.print("예약가능여부 (현재값: " + list.get(index).getHallResvYN() +"): >>");
				String updRervYN = HioMain.sc.nextLine();

				hioMem.setHallResvYN(updRervYN);

				int resultRervY = service.updateRervYN(hioMem);
				
				if (resultRervY > 0) {
					System.out.println("변경 완료!");
				} else {
					System.out.println("변경 실패!");
				}

				break;
			case 2: // 시작 시간
			
				System.out.print("시작시간 (현재값: " + list.get(index).getHallsTime() + "): >>");
				int updHallsTime = Integer.parseInt(HioMain.sc.nextLine());
				
				hioMem.setHallsTime(updHallsTime);
				
				int resultHallsTime = service.updateHallsTime(hioMem);
				
				if (resultHallsTime > 0) {
					System.out.println("변경 완료!");
				} else {
					System.out.println("변경 실패!");
				}
				
				break;
			case 3: // 종료 시간

				System.out.print("시작시간 (현재값: " + list.get(index).getHallsTime() + "): >>");
				int updHalleTime = Integer.parseInt(HioMain.sc.nextLine());
				
				hioMem.setHalleTime(updHalleTime);
				
				int resultHalleTime = service.updateHalleTime(hioMem);
				
				if (resultHalleTime > 0) {
					System.out.println("변경 완료!");
				} else {
					System.out.println("변경 실패!");
				}
				
				break;
			}
			break;		
		case 3: // 홀 삭제
			
			while (true) {
			
				System.out.println("삭제할 홀번호를 입력해주세요. >> ");
				int delHallNo = Integer.parseInt(HioMain.sc.nextLine());
			
				hioMem.setHallNo(delHallNo);
				
				List<HioMember> reservNoList = new ArrayList<>();
							
				reservNoList = service.reservNoList(hioMem);
				
				if (reservNoList != null && !reservNoList.isEmpty()) {
					System.out.println("연관된 아래 주문 번호가 존재합니다. 다른 홀번호를 선택해 주세요.");
					System.out.print("예약 번호: >> ");
					//for(int i=0; i<reservNoList.size();i++) {
					//	System.out.printf(reservNoList.get(i).getReservNo()+"\t");
					//}
					for(HioMember h : reservNoList) {
						System.out.printf(h.getReservNo() + "\t");
					}
					System.out.println();
				
				} else if (!(reservNoList != null) || reservNoList.isEmpty()) {
					
					hioMem.setHallNo(delHallNo);
					
					result = service.delHallNo(hioMem);
					
					if (result > 0) {
						System.out.println("삭제 성공!");
						break;
					}
				}
			}	
		
			break;
		case 4:
			break;
		}
	}

	void hallMenu() {

		System.out.println("----- 홀 메뉴 -----");
		System.out.println("1. 홀 추가");
		System.out.println("2. 홀 변경");
		System.out.println("3. 홀 삭제");
		System.out.println("4. 홀 메뉴 종료");
		System.out.println("-----------------");

	}

}
