package com.todo.todo.controller.book;

import com.todo.todo.service.book.BookService;
import com.todo.todo.domain.orders.Orders;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/book/list")
@Log4j2
public class BookListController {

    private final BookService bookService;

    public BookListController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBooklist(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.info("booklistcontroller 로그 테스트");

        request.setAttribute("list", bookService.selectAll());
        request.setAttribute("custList", bookService.custSelectAll());

        return "views/book/list";
    }

    @PostMapping
    public String postBookList(
//            HttpServletRequest request,
//            HttpServletResponse response
            @RequestParam("custId") int custid,
            @RequestParam("bookId") int bookid,
            @RequestParam("price") int price
    ) throws Exception {

        log.info("BookListController.java doPost()진입 / 구매하기 처리");

//        int custid = Integer.parseInt(request.getParameter("custId"));
//        int bookid = Integer.parseInt(request.getParameter("bookId"));
//        int price = Integer.parseInt(request.getParameter("price"));

        log.info("전달받은 고객아이디: " + custid);
        log.info("전달받은 도서코드: " + bookid);
        log.info("전달받은 가격: " + price);

        LocalDate curDate = LocalDate.now();

        Orders ord = new Orders();
        ord.setCustid(custid);
        ord.setBookid(bookid);
        ord.setSaleprice(price);
        ord.setOrderdate(String.valueOf(curDate));

        log.info("setSaleprice 후 getSaleprice " + ord.getSaleprice());

        bookService.ordersInsert(ord);

        if (bookService.ordersInsert(ord) > 0){
            log.info("구매하기 DB처리완료!!!!");
        }

        return "redirect:/orders/list";
    }
}
