package com.todo.todo.controller;

import com.todo.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoListController", value = "/todo/TodoList")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("todo list 들어옴");

        // list.jsp에 ${title}로 사용함
        request.setAttribute("title", "Todo List");
        request.setAttribute("todoList", new TodoService().getTodoList()); // TodoServie를 생성해서 변수에 담지 않았고, 바로 메소드를 호출한다.
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");

        dispatcher.forward(request, response);

    }

}