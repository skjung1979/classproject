package com.todo.todomybatis.controller.book;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.service.book.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired(required = false)
    private BookService bookService;

    @GetMapping
    public String getBookmodify(
            HttpServletRequest request,
            @RequestParam("bookid") int bookid
    ) throws Exception {

//        int bookId = Integer.parseInt(request.getParameter("bookId"));
        log.info("도서코드 : " + bookid);

        request.setAttribute("book", bookService.selectBy(bookid));

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
