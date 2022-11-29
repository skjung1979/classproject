package com.todo.todomybatis.controller.book;

import com.todo.todomybatis.service.book.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@Log4j2
@RequestMapping("/book/deleteCheckedBook")
public class BookCheckedDeleteController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String deleteCheckedBook(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("chbk") String[] chbk
    ){

        log.info("/book/deleteCheckedBook POST 진입...");
        for (String b : chbk) {
            log.info("선택한 bookid : " + b);
        }

        List<Integer> list = new ArrayList<>();

        for (String b : chbk) {
            list.add(Integer.parseInt(b));
        }

        bookService.deleteByBookids(list);

        return "redirect:/book/list";
    }
}
