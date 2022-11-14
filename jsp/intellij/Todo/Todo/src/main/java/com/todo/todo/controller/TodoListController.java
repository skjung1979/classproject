package com.todo.todo.controller;

import com.todo.todo.domain.TodoDTO;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TodoListController", value = "/todo/TodoList")
@Log4j2
public class TodoListController extends HttpServlet {

    TodoService service = new TodoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("todo list 들어옴");

        // list.jsp에 ${title}로 사용함
        request.setAttribute("title", "Todo List");
        //request.setAttribute("todoList", new TodoService().getTodoList()); // TodoServie를 생성해서 변수에 담지 않았고, 바로 메소드를 호출한다.

        List<TodoDTO> list = new ArrayList<>();

        try {
            list = service.selectAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");

        dispatcher.forward(request, response);

    }

}