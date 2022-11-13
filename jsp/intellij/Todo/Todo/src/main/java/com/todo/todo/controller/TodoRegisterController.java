package com.todo.todo.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRegisterController", value = "/todo/TodoRegister")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 사용자가 입력할 수 있는 폼 화면

        System.out.println("register get 들어옴");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // 사용자가 입력한 데이터를 받아서 처리하는 로직

        System.out.println("register post 들어옴");

        // 한글처리: 사용자가 입력한 내용들이 한글 처리 되도록
        request.setCharacterEncoding("UTF-8");

        String todo = request.getParameter("todo");
        String dueDate = request.getParameter("dueDate");
        String memo = request.getParameter("memo");

        request.setAttribute("todo", todo);
        request.setAttribute("dueDate", dueDate);
        request.setAttribute("memo", memo);

        response.sendRedirect("/todo/TodoList");


    }
}
