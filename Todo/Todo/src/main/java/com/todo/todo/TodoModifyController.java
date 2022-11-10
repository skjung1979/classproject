package com.todo.todo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoEditController", value = "/TodoModify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");

        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.sendRedirect("/TodoList");

    }
}
