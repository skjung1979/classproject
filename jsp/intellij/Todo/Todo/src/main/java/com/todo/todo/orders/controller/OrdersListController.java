package com.todo.todo.orders.controller;

import com.todo.todo.book.service.BookService;
import com.todo.todo.customer.Customer;
import com.todo.todo.orders.service.OrdersService;
import com.todo.todo.orders.domain.Orders;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders/list")
@Log4j2
public class OrdersListController {

    private final OrdersService ordersService;

   private final BookService bookService;

    public OrdersListController(OrdersService ordersService, BookService bookService) {
        this.ordersService = ordersService;
        this.bookService = bookService;
    }

    @GetMapping
    public String getOrdersList(HttpServletRequest request, HttpServletResponse response){

        log.info("/orders/list 서블릿 진입");

        List<Orders> list = new ArrayList<>();
        List<Customer> custList = new ArrayList<>();

        try {

            list = ordersService.ordersSelectAll();
            custList = bookService.custSelectAll();
            request.setAttribute("cId", 0);

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("custList", custList);
        request.setAttribute("ordersList", list);
        request.setAttribute("reSelectList", list);
        log.info("list 결과 결과");
        log.info(list);

        return "views/orders/list";
    }

    @PostMapping
    public String postOrdersList(HttpServletRequest request, HttpServletResponse response){

        log.info("OrdersListController.java doPost()진입 / 고객별 주문조회");

        int custid = Integer.parseInt(request.getParameter("custid"));

        List<Customer> custList = new ArrayList<>();

        Orders ord = new Orders();
        ord.setCustid(custid);

        List<Orders> list = new ArrayList<>();

        try {

            if (ord.getCustid() == 0){
                list = ordersService.ordersSelectAll();
                request.setAttribute("cId", 0);
            } else {
                list = ordersService.ordersSelectBy(ord.getCustid());
                request.setAttribute("cId", ord.getCustid());
            }
            custList = bookService.custSelectAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("custList", custList);
        request.setAttribute("reSelectList", list);

        return "views/orders/list";
    }
}
