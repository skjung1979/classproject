package com.todo.todo.controller;

import com.todo.todo.domain.MemberRegRequest;
import com.todo.todo.member.Member;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/member/regTodoMember")
@Log4j2
public class TodoMemberRegController {

    private final TodoService todoService;

    public TodoMemberRegController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public String regTodoMember(
            HttpServletRequest request,
            HttpServletResponse response
    ){

        return "views/member/regform";

    }

    @PostMapping
    public String reTodoMember(
            MemberRegRequest regRequest,
            HttpServletRequest request, // 파일의 실제 저장 경로를 찾기 위한 것
            HttpServletResponse response
    ) throws Exception {
        log.info("회원 가입 post 진입");

        // 이전 방식(MemberRegRequest DTO를 생성하기 전!
        // 사용자 데이터 전달 받기
//        String memname = request.getParameter("username");
//        String memid = request.getParameter("userid");
//        String mempw = request.getParameter("userpw");
//        String memphone = request.getParameter("userphone");
//        String mememail = request.getParameter("useremail");

//        Member member = Member.builder()
//                .membernm(memname)
//                .memberid(memid)
//                .memberpw(mempw)
//                .memberphone(memphone)
//                .memberemail(mememail)
//                .build();

        log.info(regRequest);

        todoService.insertTodoMember(regRequest, request);

        return "redirect:/member/loginTodoMember";
    }

}
