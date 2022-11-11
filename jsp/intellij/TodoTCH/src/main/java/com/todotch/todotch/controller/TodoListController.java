package com.todotch.todotch.controller;

import com.todotch.todotch.service.TodoService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("todo list...");

        // 출력 결과
        // String title = "Todo List";
        request.setAttribute("title", "Todo List");
        request.setAttribute("todoList", new TodoService().getTodoList());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(request, response);

    }

//    doPost()는 필요하지 않아 지움

}
