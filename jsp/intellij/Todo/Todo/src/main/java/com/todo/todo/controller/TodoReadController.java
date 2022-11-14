package com.todo.todo.controller;

import com.sun.tools.javac.comp.Todo;
import com.todo.todo.domain.TodoDTO;
import com.todo.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoReadController", value = "/todo/TodoRead")
public class TodoReadController extends HttpServlet {

    TodoService service = new TodoService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println("todo read 들어옴");

        // 사용자 요청 tno 받기
        //String tno = request.getParameter("tno");


        // service 요청한 tno로 할일 목록을 검색해서 결과 -> TodoDTO로 반환
        //TodoDTO todo = new TodoDTO(1, "공부하기", "열심히 공부하기", "2022-11-26", false); // 받아왔다 치고 임시로 이 로직 삽입.

        int tno = Integer.parseInt(request.getParameter("tno"));
        System.out.println("요청 번호: " + tno);

        TodoDTO result = new TodoDTO();

        try {
            result = service.selectBy(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        request.setAttribute("todo", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        dispatcher.forward(request, response);

    }

}
