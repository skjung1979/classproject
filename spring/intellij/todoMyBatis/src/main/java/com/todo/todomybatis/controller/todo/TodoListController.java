package com.todo.todomybatis.controller.todo;

import com.todo.todomybatis.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class TodoListController{

    @Autowired(required = false)
    private TodoService todoService;

    @GetMapping("/todo/TodoList")
    public String getTodoList(HttpServletRequest request, Model model) throws Exception {

        log.info("todo list 들어옴");

        // list.jsp에 ${title}로 사용함
        request.setAttribute("title", "Todo List");

        model.addAttribute("list", todoService.selectAll());
        log.info(todoService.selectAll());

        return "views/todo/list";
    }

}