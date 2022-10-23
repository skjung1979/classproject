package book.controller;

import book.MainSK2;
import book.dao.OracleDao;
import book.service.DeleteService;

public class DeleteController implements Controller {

	DeleteService service = new DeleteService(new OracleDao());
	
	@Override
	public void process() {
		int result = 0;
		
		System.out.println("도서 삭제를 시작합니다.");
		System.out.println("삭제할 도서ID를 입력하세요. >> ");
		int bookid = Integer.parseInt(MainSK2.sc.nextLine());
		
		result = service.delete(bookid);
		
		if (result > 0) {
			System.out.println("도서 삭제 완료!");
		} else {
			System.out.println("도서 삭제 실패!");
		}
		
		
		
	
	}
	
	

}
