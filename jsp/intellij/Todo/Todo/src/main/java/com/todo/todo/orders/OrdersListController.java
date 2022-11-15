package com.todo.todo.orders;

import com.todo.todo.book.BookService;
import com.todo.todo.customer.Customer;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrdersListController", value = "/orders/list")
@Log4j2
public class OrdersListController extends HttpServlet {

    OrdersService service = new OrdersService();

    BookService service2 = new BookService(); // 회원정보 가져오는 메스드 사용을 위해

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("/orders/list 서블릿 진입");

        List<Orders> list = new ArrayList<>();

        List<Customer> custList = new ArrayList<>();

        try {

            list = service.ordersSelectAll();
            custList = service2.custSelectAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("custList", custList);
        request.setAttribute("ordersList", list);
        request.setAttribute("reSelectList", list);
        log.info("list 결과 결과");
        log.info(list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/orders/list.jsp");
        dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        log.info("OrdersListController.java doPost()진입 / 고객별 주문조회");

        int custid = Integer.parseInt(request.getParameter("custid"));

        List<Customer> custList = new ArrayList<>();

        Orders ord = new Orders();
        ord.setCustid(custid);

        List<Orders> list = new ArrayList<>();

        try {

            if (ord.getCustid() == 0){
                list = service.ordersSelectAll();
            } else {
                list = service.ordersSelectBy(ord.getCustid());
            }
            custList = service2.custSelectAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("custList", custList);
        request.setAttribute("reSelectList", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/orders/list.jsp");
        dispatcher.forward(request, response);

    }

}
