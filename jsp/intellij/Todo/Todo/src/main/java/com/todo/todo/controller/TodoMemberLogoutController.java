package com.todo.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/logoutTodoMember")
public class TodoMemberLogoutController {

    @GetMapping
    public String logout (HttpSession session, HttpServletResponse response){



//        String uuid = cookie.getValue();

        Cookie c = new Cookie("uuid", "");
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);

        session.invalidate();

        return "redirect:/";
    }
}
