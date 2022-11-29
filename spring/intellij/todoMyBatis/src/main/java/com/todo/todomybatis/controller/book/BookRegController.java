package com.todo.todomybatis.controller.book;

import com.todo.todomybatis.domain.book.Book;
import com.todo.todomybatis.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book/register")
public class BookRegController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getRegBook(){

        return "views/book/register";
    }

    @PostMapping
    public String postRegBook(Book book){

        bookService.insertBook(book);


        return "redirect:/book/list";
    }


}
