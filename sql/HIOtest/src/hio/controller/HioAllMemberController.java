package hio.controller;

import java.util.List;

import hio.HioMain;
import hio.DAO.MySqlDao;
import hio.domain.HioMember;
import service.HioAllMemberService;

//HIOtest 프로젝트
public class HioAllMemberController implements HioAllMemberInterface{

	HioAllMemberService service = new HioAllMemberService();

	public void allMemberList() {

		List<HioMember> list = service.allMemberList();

		if(list != null && !list.isEmpty()) { 

			System.out.println("----------------------------");
			System.out.println("----------------------- 전체 회원 리스트 -----------------------------");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("회원번호\t|\t회원명\t|\t회원주소\t|\t회원전화번호\t|\t아이디");
			System.out.println("-----------------------------------------------------------------");
		
			
			for(HioMember h : list) {
				System.out.println(h.getMemberNo() + "\t|\t" + h.getMemberName() + "\t|\t" + h.getMemberAddress() + "\t|\t" + h.getMemberPhone() + "\t|\t" + h.getMemberId());
			}
		} else {
			System.out.println("검색 결과 없음!");
		}

	}
}









