package com.todo.todospring.controller;

import com.todo.todospring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class TodoReadController {

    @Autowired(required = false)
    private TodoService todoService;

    @GetMapping("/todo/read")
    public void readTodo(Model model, @RequestParam("tno") int tno) throws SQLException {

        model.addAttribute("todo", todoService.getTodo(tno));

        // return "todo/read"; // 경로가 같으므로 선언부를 String이 아닌 void로 변경함
    }

}
