package com.todo.todo.book.controller;

import com.todo.todo.book.domain.Book;
import com.todo.todo.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;

@Controller
@RequestMapping("/book/modify")

public class BookModifyController {

    private final BookService bookService;

    public BookModifyController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBookmodify(HttpServletRequest request, HttpServletResponse response){

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        System.out.println("도서코드 : " + bookId);

        Book result = new Book();

        try {
            result = bookService.selectBy(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("book", result);

        return "views/book/modify";
    }

    @PostMapping
    public String postBookModify(HttpServletRequest request, HttpServletResponse response){

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        Book book = new Book(bookId, bookName, publisher, price);

        int result = 0;

        try {
            result = bookService.updateBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/book/list";
    }
}
