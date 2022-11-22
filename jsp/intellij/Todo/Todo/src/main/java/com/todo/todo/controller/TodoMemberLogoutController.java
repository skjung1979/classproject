package com.todo.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/logoutTodoMember")
public class TodoMemberLogoutController {

    @GetMapping
    public String logout (HttpSession session){

        session.invalidate();

        return "redirect:/";
    }
}
