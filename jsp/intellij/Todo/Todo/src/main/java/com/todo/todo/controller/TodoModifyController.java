package com.todo.todo.controller;

import com.todo.todo.domain.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoEditController", value = "/todo/TodoModify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("modify get 들어옴");

        // 사용자가 입력했던 데이터를 기본값으로 가지는 입력 폼 화면
        String tno = request.getParameter("tno");
        System.out.println("사용자 요청 번호: " + tno);

        // 수정할 할일의 번호(사용자가 입력한 번호)를 받아서 Service에게 전달하여 TodoDTO를 set하게 한 후 다시 받는다.
        TodoDTO todo = new TodoDTO(1, "공부하기", "열심히 공부하기 열심히 공부하기", "2022-12-25", false); // 받아왔다 치고 임시 값 생성

        // 받아온 값을 setAttribute한다.
        request.setAttribute("todo", todo);

        // sendRedirect하지 않는 이유는 여기서 값을 입력받아야 하므로.
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("modify post 들어옴");

        // 사용자가 수정한 데이터를 업데이트 처리
        request.setCharacterEncoding("utf-8");
        String tno = request.getParameter("tno");
        String todo = request.getParameter("todo");
        String memo = request.getParameter("memo");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");

        System.out.println("수정 요청 받은 번호: " + tno);
        System.out.println("수정 요청 받은 할일: " + todo);
        System.out.println("수정 요청 받은 설명: " + memo);
        System.out.println("수정 요청 받은 기한: " + dueDate);
        System.out.println("수정 요청 받은 완료여부: " + finished);

        // Service로 보낼 DTO 생성 <- 사용자가 입력한 수정값으로 DTO객체를 생성해서 서비스로 보내는 것이다.
        TodoDTO dto = new TodoDTO(Long.parseLong(tno), todo, memo, dueDate, finished == null ? false : true);

        System.out.println(dto);

        // Service로 전송하면 응답은 int로 온다. (insert, update, delete의 결과는 int로 오므로)

        // 수정되면 리스트로 보내야 중복 수정이 안된다.
        response.sendRedirect("/todo/TodoList");

    }
}
