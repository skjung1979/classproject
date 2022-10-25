package hio.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import hio.domain.HioMember;
import service.HioMemberDeleteService;

public class HioMemberDeleteController implements HioMemberDeleteInterface {

	Scanner sc = new Scanner(System.in);

	@Override
	public int memberDelete() {
				
		List<HioMember> allList = new HioMemberDeleteService().memberSelectToDelete();

		System.out.println("회원 삭제를 진행합니다. ==>> ");
		System.out.println("=============================== 현재 회원 리스트 ===============================");
		System.out.printf("회원번호\t|\t회원이름\t|\t전화번호\t\t|\t주소\t|\t아이디\n");
		System.out.println("----------------------------------------------------------------------------");
		
		if (allList != null && !allList.isEmpty()) {
			
			for (int i=0; i<allList.size(); i++) {
				System.out.printf(allList.get(i).getMemberNo() + "\t|\t" +allList.get(i).getMemberName() + "\t|\t" + allList.get(i).getMemberPhone() + "\t|\t" + allList.get(i).getMemberAddress() + "\t|\t" + allList.get(i).getMemberId());
				System.out.println();
			}
		}

		System.out.println("============================================================================");

		boolean check = false;

		while (true) {
			System.out.println("위 리스트에서 삭제할 회원 이름을 입력해주세요. (0:삭제 그만) >> ");
			String delName = sc.nextLine().trim();
			
			if (delName.equals("0")){
				return 0;
			}

			for (int i=0; i<allList.size(); i++) {

				if (delName.equals(allList.get(i).getMemberName())) {

					check = true;
					break;
				} 
			}

			if (check == true) {

				int result = new HioMemberDeleteService().memberDelete(delName);

				if (result > 0) {
					System.out.println("회원 삭제 완료! 삭제 결과 리스트!");

					List<HioMember> resultList = new HioMemberDeleteService().memberSelectToDeleteRes();
					
					if (resultList != null && !resultList.isEmpty()) {

						for (int i=0; i<resultList.size(); i++) {
							System.out.print(resultList.get(i).getMemberNo() + " | " +resultList.get(i).getMemberName() + " | " + resultList.get(i).getMemberPhone());
							System.out.println();
						}
						//continue;
					} else {
						System.out.println("회원 삭제 실패!");
					}
					break;
				} else {
					System.out.println("입력하신 회원이 존재하지 않습니다.");
				}		

			}
		}
		return 0;
	}
	
}






