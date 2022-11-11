package com.todotch.todotch.controller;

import com.todotch.todotch.domain.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoModifyController", value = "/todo/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("modify get...");

        // 사용자가 입력했던 데이터를 기본값으로 가지는 입력 폼 화면 구성

        String tno = request.getParameter("tno");
        System.out.println("사용자 요청 번호: " + tno);

        // 수정할 할일의 번호를 받아서, service에게 전달 후 TodoDTO를 받는다.
        TodoDTO todo = new TodoDTO(1, "숙제", "2022-10-30", false);
        request.setAttribute("todo", todo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자가 새롭게 입력한 데이터 변경 적용
        System.out.println("modify post...");

        // 사용자가 입력한 데이터 모두 받기
        request.setCharacterEncoding("utf-8");
        String tno = request.getParameter("tno");
        String todo = request.getParameter("todo");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");

        System.out.println("tno :" + tno);
        System.out.println("todo :" + todo);
        System.out.println("dueDate :" + dueDate);
        System.out.println("finished :" + finished);

        // Service로 보낼 DTO 생성
        TodoDTO dto = new TodoDTO(Long.parseLong(tno), todo, dueDate, finished == null ? false : true);
        System.out.println(dto);

        // Service로 전송 -> 응답 int
        response.sendRedirect("/todo/list");
    }
}
