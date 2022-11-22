package com.todo.todospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm(){

        return "loginForm";
    }

    @PostMapping
    public String login(
            @RequestParam("uid") String uid,
            @RequestParam("pw") String pw
    ){
        return "login";
    }


}
