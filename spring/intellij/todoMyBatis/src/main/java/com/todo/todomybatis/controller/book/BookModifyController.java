package com.todo.todomybatis.controller.book;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.service.book.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book/modify")
@Log4j2
public class BookModifyController {

    private final BookService bookService;

    public BookModifyController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBookmodify(
            HttpServletRequest request,
            @RequestParam("bookId") int bookId
    ) throws Exception {

//        int bookId = Integer.parseInt(request.getParameter("bookId"));
        log.info("도서코드 : " + bookId);

        request.setAttribute("book", bookService.selectBy(bookId));

        return "views/book/modify";
    }

    @PostMapping
    public String postBookModify(
            Book book
    ) throws Exception {

//        int bookId = Integer.parseInt(request.getParameter("bookId"));
//        String bookName = request.getParameter("bookName");
//        String publisher = request.getParameter("publisher");
//        int price = Integer.parseInt(request.getParameter("price"));
 //       Book book = new Book(bookId, bookName, publisher, price);

        bookService.updateBook(book);

        return "redirect:/book/list";
    }
}
