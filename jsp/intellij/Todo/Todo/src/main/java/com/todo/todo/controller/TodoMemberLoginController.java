package com.todo.todo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@RequestMapping("/member/loginTodoMember")
public class TodoMemberLoginController {

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







        return null;
    }

}
