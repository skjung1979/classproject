package com.todo.todo.controller.todo;

import com.todo.todo.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.*;

@Controller
@RequestMapping("/todo/TodoRead")
@Log4j2
public class TodoReadController {

    private final TodoService service;
    public TodoReadController(TodoService service){
        this.service = service;
    }

    @GetMapping
    public String getRead(
            @RequestParam("tno") int tno,
            HttpServletRequest request
    ) throws Exception {

        log.info("todo read 들어옴");

        // 사용자 요청 tno 받기
        //String tno = request.getParameter("tno"); => @RequestParam("tno") int tno 이것으로 대체

        // service 요청한 tno로 할일 목록을 검색해서 결과 -> TodoDTO로 반환
        //TodoDTO todo = new TodoDTO(1, "공부하기", "열심히 공부하기", "2022-11-26", false); // 받아왔다 치고 임시로 이 로직 삽입.
        
        log.info("요청 번호: " + tno);

        request.setAttribute("todo", service.selectBy(tno));

        return "todo/read";
    }
    


}
