package com.todo.todo.controller;

import com.todo.todo.domain.TodoDTO;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@Log4j2
public class TodoListController{

    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo/TodoList")
    public String getTodoList(HttpServletRequest request){

        log.info("todo list 들어옴");

        // list.jsp에 ${title}로 사용함
        request.setAttribute("title", "Todo List");
        //request.setAttribute("todoList", new TodoService().getTodoList()); // TodoServie를 생성해서 변수에 담지 않았고, 바로 메소드를 호출한다.

        List<TodoDTO> list = new ArrayList<>();

        try {
           list = todoService.selectAll();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        request.setAttribute("list", list);

        return "todo/list";
    }

}