package com.todo.todo.book;

import com.todo.todo.customer.Customer;
import com.todo.todo.orders.Orders;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "BookListController", value = "/book/list")
@Log4j2
public class BookListController extends HttpServlet {

    BookService service = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //log.info("booklistcontroller 로그 테스트");

        List<Book> list = new ArrayList<>();

        List<Customer> custList = new ArrayList<>();

        try {

            list = service.selectAll();
            custList = service.custSelectAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);
        request.setAttribute("custList", custList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book/list.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse respons)throws ServletException, IOException {

        log.info("BookListController.java doPost()진입 / 구매하기 처리");

        int custid = Integer.parseInt(request.getParameter("custId"));
        int bookid = Integer.parseInt(request.getParameter("bookId"));
        int price = Integer.parseInt(request.getParameter("price"));

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

        int result = 0;

        try {
            result = service.ordersInsert(ord);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (result > 0){
            log.info("구매하기 DB처리완료!!!!");
        }

        respons.sendRedirect("/orders/list");

    }

}
