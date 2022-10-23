package book.controller;

import book.MainSK2;
import book.dao.OracleDao;
import book.domain.Book;
import book.service.UpdateService;

public class UpdateController implements Controller {
	
	UpdateService service = new UpdateService(new OracleDao());

	@Override
	public void process() {

		System.out.println("도서 변경을 진행합니다.");
		System.out.println("변경을 원하시는 bookid를 입력해주세요. >> ");
		int bookid = Integer.parseInt(MainSK2.sc.nextLine());
		
		System.out.println("변경할 도서명을 입력해주세요. >> ");
		String bookname = MainSK2.sc.nextLine().trim();

		System.out.println("변경할 출판사명을 입력해주세요. >> ");
		String publisher = MainSK2.sc.nextLine().trim();
		
		System.out.println("변경할 가격을 입력해주세요. >> ");
		int price = Integer.parseInt(MainSK2.sc.nextLine());
		
		Book book = new Book(bookid, bookname, publisher, price);
		
		int result = service.update(book);
		
		if (result > 0) {
			System.out.println("도서 수정 완료!");
		} else {
			System.out.println("도서 수정 실패!");
		}
			
	}
}
