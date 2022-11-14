package com.todo.todo.controller;

import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/todo/TodoRemove")
@Log4j2
public class TodoRemoveController extends HttpServlet {

    TodoService service = new TodoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("todo remove 들어옴");

        // 삭제하고자 하는 todo의 tno값을 받는다.
        int tno = Integer.parseInt(request.getParameter("tno"));
        System.out.println("삭제할 tno: " + tno);
        
        // Serivice로 tno 전달 -> DAO해당 row 삭제
        int result = 0;

        try {
            result = service.deletTodo(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        log.info("도서 삭제 완료!!!");

        // 삭제후 로직이 중복으로 작동하지 않도록 리스트 페이지로 이동시킨다.
        response.sendRedirect("/todo/TodoList");

    }
}
