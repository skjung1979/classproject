package com.todo.todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRegisterController", value = "/TodoRegister")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/todo/register.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String todo = request.getParameter("todo");
        String inDate = request.getParameter("inDate");
        String memo = request.getParameter("memo");

        request.setAttribute("todo", todo);
        request.setAttribute("inDate", inDate);
        request.setAttribute("memo", memo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(request, response);

    }
}
