package com.todo.todo.controller;

import com.todo.todo.domain.TodoDTO;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoEditController", value = "/todo/TodoModify")
@Log4j2
public class TodoModifyController extends HttpServlet {

    TodoService service = new TodoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("modify get 들어옴");

        // 사용자 요청 tno 받기
        //String tno = request.getParameter("tno");

        // service 요청한 tno로 할일 목록을 검색해서 결과 -> TodoDTO로 반환
        //TodoDTO todo = new TodoDTO(1, "공부하기", "열심히 공부하기", "2022-11-26", false); // 받아왔다 치고 임시로 이 로직 삽입.

        int tno = Integer.parseInt(request.getParameter("tno"));
        log.info("요청 번호: " + tno);

        TodoDTO result = new TodoDTO();

        try {
            result = service.selectBy(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("todo", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("modify post 들어옴");

        // 사용자가 수정한 데이터를 업데이트 처리
        request.setCharacterEncoding("utf-8");
        String tno = request.getParameter("tno");
        String todo = request.getParameter("todo");
        String memo = request.getParameter("memo");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");

        log.info("수정 요청 받은 번호: " + tno);
        log.info("수정 요청 받은 할일: " + todo);
        log.info("수정 요청 받은 설명: " + memo);
        log.info("수정 요청 받은 기한: " + dueDate);
        log.info("수정 요청 받은 완료여부: " + finished);

        // Service로 보낼 DTO 생성 <- 사용자가 입력한 수정값으로 DTO객체를 생성해서 서비스로 보내는 것이다.
        TodoDTO dto = new TodoDTO(Long.parseLong(tno), todo, memo, dueDate, finished == null ? false : true);

        int result = 0;

        System.out.println(dto);

        try {
            result = service.updateTodo(dto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (result > 0){
            System.out.println("도서 변경 완료!!!!");
        }


        // Service로 전송하면 응답은 int로 온다. (insert, update, delete의 결과는 int로 오므로)

        // 수정되면 리스트로 보내야 중복 수정이 안된다.
        response.sendRedirect("/todo/TodoList");

    }
}
