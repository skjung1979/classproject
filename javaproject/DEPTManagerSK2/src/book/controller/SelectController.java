package book.controller;

import java.util.List;

import book.dao.OracleDao;
import book.domain.Book;
import book.service.SelectService;

//project DEPTManagerSK2
public class SelectController implements Controller{
	
	SelectService service = new SelectService(new OracleDao());
	
	public void process() {
		
		List<Book> list = service.select();
		
		if (list != null && !list.isEmpty()){
			
			for (Book b : list) {
				System.out.println(b);
			}
			
		} else {
			System.out.println("검색 결과 없습니다.");
		}
		
	}

}
