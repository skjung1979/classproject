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
		System.out.println("원하시는 검색 항목을 선택해주세요.");
		System.out.println("1. BookID | 2. BookName | 3. Publisher | 4. 가격");
		int select = Integer.parseInt(MainSK2.sc.nextLine());
		
		List<Book> searchlist = null;
		
		switch (select) {
		case 1:
			System.out.println("BookID를 입력하세요. >> ");
			int searchId = Integer.parseInt(MainSK2.sc.nextLine());
			
			Book bookid = new Book(searchId, null, null, 0);
			
			searchlist = service.selectByBookname(bookid, 0);
			break;
		case 2:
			System.out.println("BookName를 입력하세요. >> ");
			String searchName = MainSK2.sc.nextLine();
			
			Book bookname = new Book(0, searchName, null, 0);
			
			searchlist = service.selectByBookname(bookname, 0);
			break;
		case 3:
			System.out.println("Publisher를 입력하세요. >> ");
			String searchPublisher = MainSK2.sc.nextLine();
			
			Book publisher = new Book(0, null, searchPublisher, 0);
			
			searchlist = service.selectByBookname(publisher, 0);
			break;
		case 4:
			System.out.print("시작 가격: >> ");
			int startPrice = Integer.parseInt(MainSK2.sc.nextLine());
			System.out.print("종료 가격: >> ");
			int endPrice = Integer.parseInt(MainSK2.sc.nextLine());
			
			Book price = new Book(0, null, null, startPrice);
			
			searchlist = service.selectByBookname(price, endPrice);
			break;
		}
		
		
		
		//System.out.println("검색할 도서명을 입력해주세요.");
		//String searchBookname = MainSK2.sc.nextLine().trim();
		
		//List<Book> searchlist = service.selectByBookname(searchBookname);
			
		if (searchlist != null && !searchlist.isEmpty()) {
			
			System.out.println("검색 결과 ======================");
			
			for (Book b : searchlist) {
				System.out.println(b);
			}		
//		if (book != null) {
//			System.out.println(book);
		} else {
			System.out.println("검색한 항목의 도서가 없습니다.");
		}	
	}
}
