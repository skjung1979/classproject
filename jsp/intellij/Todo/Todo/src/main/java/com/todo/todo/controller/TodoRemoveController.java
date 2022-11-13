package com.todo.todo.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/todo/TodoRemove")
public class TodoRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("todo remove 들어옴");

        // 삭제하고자 하는 todo의 tno값을 받는다.
        String tno = request.getParameter("tno");
        System.out.println("삭제할 tno: " + tno);
        
        // Serivice로 tno 전달 -> DAO해당 row 삭제

        // 삭제후 로직이 중복으로 작동하지 않도록 리스트 페이지로 이동시킨다.
        response.sendRedirect("/todo/TodoList");

    }
}
