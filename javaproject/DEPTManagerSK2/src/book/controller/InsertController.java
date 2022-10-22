package book.controller;

import book.MainSK2;
import book.dao.OracleDao;
import book.domain.Book;
import book.service.InsertService;

public class InsertController implements Controller {

	InsertService service = new InsertService(new OracleDao());
	
	@Override
	public void process() {

		System.out.println("신규 도서를 등록 합니다.");
		System.out.println("도서ID를 입력해주세요. >> ");
		int bookid = Integer.parseInt(MainSK2.sc.nextLine());
		
		System.out.println("도서명을 입력해주세요. >> ");
		String bookname = MainSK2.sc.nextLine();
		
		System.out.println("출판사명을 입력해주세요. >> ");
		String publisher = MainSK2.sc.nextLine();
		
		System.out.println("도서명을 입력해주세요. >> ");
		int price = Integer.parseInt(MainSK2.sc.nextLine());

		int result = service.insert(new Book(bookid, bookname, publisher, price));

		if (result > 0) {
			System.out.println("신규 등록 완료!");
		} else {
			System.out.println("신규 등록 실패!");
		}
		
		
	}
}
