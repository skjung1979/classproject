package hio.controller;

import java.util.List;

import hio.DAO.MySqlDao;
import hio.domain.HioMember;
import service.HioAllReservationService;

public class HioAllReservationController implements HioAllReservationInterface {
	
	HioAllReservationService service = new HioAllReservationService(new MySqlDao());
	
	public void allreservation() {
						
		List<HioMember> list = service.selectList();
		
		if(list != null && !list.isEmpty()) { 
			
			for(HioMember d : list) {
				System.out.println(d);
			}
		} else {
			System.out.println("예약 정보 없음");
		}
		
}
}


