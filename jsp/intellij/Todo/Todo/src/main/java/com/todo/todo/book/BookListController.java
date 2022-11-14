package com.todo.todo.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "BookListController", value = "/book/list")
public class BookListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //log.info("booklistcontroller 로그 테스트");
        
        BookService service = new BookService();

        List<Book> list = new ArrayList<>();

        try {

            list = service.selectAll();

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("list", list);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book/list.jsp");
        dispatcher.forward(request, response);

    }

}
