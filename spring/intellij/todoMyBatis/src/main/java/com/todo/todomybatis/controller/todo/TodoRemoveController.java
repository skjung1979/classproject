package com.todo.todomybatis.controller.todo;

import com.todo.todomybatis.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/todo/TodoRemove")
@Log4j2
public class TodoRemoveController {


    private final TodoService todoService;

    public TodoRemoveController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public String removedTodo(
            @RequestParam("tno") int tno
    ){

        log.info("todo remove 들어옴");

        // 삭제하고자 하는 todo의 tno값을 받는다.

        log.info("삭제할 tno: " + tno);

        // Serivice로 tno 전달 -> DAO해당 row 삭제
        int result = 0;

        try {
            result = todoService.deletTodo(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        log.info("도서 삭제 완료!!!");

        // 삭제후 로직이 중복으로 작동하지 않도록 redirect로 리스트 페이지로 이동시킨다.
        return "redirect:/todo/TodoList";
    }


}
