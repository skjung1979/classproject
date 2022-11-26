package com.todo.todomybatis.controller.todo;

import com.todo.todomybatis.domain.todo.TodoDTO;
import com.todo.todomybatis.service.todo.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/todo/TodoModify")
@Log4j2
public class TodoModifyController {

    @Autowired(required = false)
    private TodoService service;

    @GetMapping
    public String putModify(
            HttpServletRequest request,
            Model model,
            @RequestParam("tno") int tno
    ) throws Exception {

        System.out.println("modify get 들어옴");

        // 사용자 요청 tno 받기
        //String tno = request.getParameter("tno");
        // service 요청한 tno로 할일 목록을 검색해서 결과 -> TodoDTO로 반환
        //TodoDTO todo = new TodoDTO(1, "공부하기", "열심히 공부하기", "2022-11-26", false); // 받아왔다 치고 임시로 이 로직 삽입.
        //int tno = Integer.parseInt(request.getParameter("tno")); 
        // 이상 주석 => @RequestParam으로 대체함
        
        log.info("요청 번호: " + tno);

    /*    TodoDTO result = new TodoDTO();
        try {
            result = service.selectBy(tno);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("todo", result);*/
        // 이상 주석 => model.addAttribute("todo", service.selectBy(tno)); 로 대체함

        model.addAttribute("todo", service.selectBy(tno));

        return "views/todo/modify";

    }


    @PostMapping
    public String postModify(
//            HttpServletRequest request,
//            HttpServletResponse response
            TodoDTO todoDTO
    ) throws Exception {

        log.info("modify post 들어옴");

        // 사용자가 수정한 데이터를 업데이트 처리
//        String tno = request.getParameter("tno");
//        String todo = request.getParameter("todo");
//        String memo = request.getParameter("memo");
//        String dueDate = request.getParameter("dueDate");
//        String finished = request.getParameter("finished");
        // 이상 주석 => TodoDTO로 대체함

        log.info("수정 요청 받은 번호: " + todoDTO.getTno());
        log.info("수정 요청 받은 할일: " + todoDTO.getTodo());
        log.info("수정 요청 받은 설명: " + todoDTO.getMemo());
        log.info("수정 요청 받은 기한: " + todoDTO.getDueDate());
        log.info("수정 요청 받은 완료여부: " + todoDTO.isFinished());

        // Service로 보낼 DTO 생성 <- 사용자가 입력한 수정값으로 DTO객체를 생성해서 서비스로 보내는 것이다.
        //TodoDTO dto = new TodoDTO(Long.parseLong(tno), todo, memo, dueDate, finished == null ? false : true);

        log.info(todoDTO);

        service.updateTodo(todoDTO);

        if (service.updateTodo(todoDTO) > 0) {
            log.info("변경 사항 DB적용 완료!!!!");
        }

        // 수정되면 리스트로 보낸다.
        return "redirect:/todo/TodoList";
    }
}
