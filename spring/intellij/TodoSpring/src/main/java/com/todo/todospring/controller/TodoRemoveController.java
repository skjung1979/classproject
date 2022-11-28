package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class TodoRemoveController {

    @Autowired(required = false)
    private TodoService todoService;

    @PostMapping("/todo/remove")
    public String removeTodo(
            @RequestParam("tno") int tno
    ) throws SQLException {

        todoService.deleteBytno(tno);

        return "redirect: /todo/list";
    }
}
