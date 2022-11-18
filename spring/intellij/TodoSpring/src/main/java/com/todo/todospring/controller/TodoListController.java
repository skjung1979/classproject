package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class TodoListController {

    // 필요한 서비스에 대해 변수 선언!
    private final TodoService todoService;

    public TodoListController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/todo/list")
    public String getTodoList(
        Model model
    ) {

        // model에서 받은 매개변수를 서비스에 전달
        model.addAttribute("todoList", todoService.getTodoList());

        return "todo/list";
    }

}
