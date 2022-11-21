package com.todo.todo.controller;

import com.todo.todo.member.Member;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2
@RequestMapping("/member/loginTodoMember")
public class TodoMemberLoginController {

    private final TodoService todoService;

    public TodoMemberLoginController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public String getLoginTodoMember (){

        return "views/member/login";
    }

    @PostMapping
    public String postLoginTodoMember (
            HttpServletRequest request,
            HttpServletResponse response
    ){
        String userid = request.getParameter("userid");
        String userpw = request.getParameter("userpw");
        String idmember = request.getParameter("idremember");
        String keeplogin = request.getParameter("keeplogin");

        // 아이디 저장에 대한 처리: 체크하면 reId 쿠키 생성 아니면 소멸
        if (idmember != null){
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(60*60*24*180);
            c.setPath("/");
            response.addCookie(c);
        } else {
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(0);
            c.setPath("/");
            response.addCookie(c);
        }

        // 로그인 처리를 위한 기본 작업 => 현재 세션으로 객체를 생성한다.
        HttpSession session = request.getSession(); // 로그인 처리를 위해 현재 세션 객체 생성

        // 입력받은 아이디와, 패스워드를 DTO에 저장한다.
        Member member = todoService.login(userid, userpw);







        return null;
    }

}
