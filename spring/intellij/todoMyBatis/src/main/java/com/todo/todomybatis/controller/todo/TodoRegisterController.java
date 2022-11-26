package com.todo.todomybatis.controller.todo;

import com.todo.todomybatis.domain.todo.TodoDTO;
import com.todo.todomybatis.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/todo/TodoRegister")
@Log4j2
public class TodoRegisterController {

    private final TodoService service;

    public TodoRegisterController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public String getReg(
            HttpServletRequest request,
            HttpServletResponse response
    ){
        log.info("register get 들어옴");

        return "views/todo/register";

    }
    @PostMapping
    public String postReg(
            TodoDTO todoDTO
    ){

        // 사용자가 입력한 데이터를 받아서 처리하는 로직
        log.info("register post 들어옴");

       /* String todo = request.getParameter("todo");
        String memo = request.getParameter("memo");
        String dueDate = request.getParameter("dueDate");
        boolean finished = false;
*/
        //TodoDTO todoDTO = new TodoDTO(todo, memo, dueDate, finished);

        try {
            int result = service.insertTodo(todoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/todo/TodoList";

    }

}
