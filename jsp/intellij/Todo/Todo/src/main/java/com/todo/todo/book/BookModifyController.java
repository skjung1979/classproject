package com.todo.todo.book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BookModifyController", value = "/book/modify")
public class BookModifyController extends HttpServlet {

    BookService service = new BookService();
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        System.out.println("도서코드 : " + bookId);

        Book result = new Book();

        try {
            result = service.selectBy(bookId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("book", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/book/modify.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        Book book = new Book(bookId, bookName, publisher, price);

        int result = 0;

        try {
            result = service.updateBook(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("/book/list");
    }
}
