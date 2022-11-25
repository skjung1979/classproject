package com.todo.todo.controller.login;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/login/logoutTodoMember")
public class TodoMemberLogoutController {

    @GetMapping
    public String logout (HttpServletResponse response, HttpServletRequest request){

        HttpSession session;
        session = request.getSession();

        session.invalidate();

        Cookie c = new Cookie("uuid", "");
        c.setMaxAge(0);
        c.setPath("/");
        response.addCookie(c);

        Cookie c1 = new Cookie("preUri", "/");
        c1.setMaxAge(60*60);
        c1.setPath("/");
        response.addCookie(c1);


        return "redirect:/";
    }
}
