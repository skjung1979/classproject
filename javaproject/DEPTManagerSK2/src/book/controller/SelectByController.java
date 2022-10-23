package book.controller;

import java.util.List;
import book.MainSK2;
import book.dao.OracleDao;
import book.domain.Book;
import book.service.SelectByService;

//project DEPTManagerSK2
public class SelectByController implements Controller {

	SelectByService service = new SelectByService(new OracleDao());
	
	@Override
	public void process() {
		
		System.out.println("도서 검색을 진행합니다.");
		System.out.println("검색할 도서명을 입력해주세요.");
		String searchBookname = MainSK2.sc.nextLine().trim();
		
		List<Book> searchlist = service.selectByBookname(searchBookname);
			
		if (searchlist != null && !searchlist.isEmpty()) {
			
			System.out.println("검색 결과 ======================");
			
			for (Book b : searchlist) {
				System.out.println(b);
			}		
//		if (book != null) {
//			System.out.println(book);
		} else {
			System.out.println("검색한 제목의 도서가 없습니다.");
		}	
	}
}
