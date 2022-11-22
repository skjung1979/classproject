package com.todo.todospring.controller;

import com.todo.todospring.domain.Member;
import com.todo.todospring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping
    public String loginForm(){

        return "loginForm";
    }

    @PostMapping
    public String login(
            @RequestParam("uid") String uid,
            @RequestParam("pw") String pw,
            HttpServletRequest request
    ) throws Exception {

        Member member = loginService.login(uid, pw);

        if (member != null) {
            // 로그인 처리
            HttpSession session = request.getSession(); // 세션(사이트 접속하면 자동 생성) 객체를 받아 와야 한다.
            session.setAttribute("loginInfo", member.toLoginInfo()); // LoginInfo 클래스 생성하여 로그인 후의 정보(id,이름,파일명 등)를 담는다.
        }

        return "redirect:/index.jsp";
    }
}
