package com.todo.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/member/loginTodoMember")
public class TodoMemberLoginController {

    @GetMapping
    public String getLoginTodoMember (){

        return "views/member/login";
    }

    @PostMapping
    public String postLoginTodoMember (){


        return null;
    }

}
