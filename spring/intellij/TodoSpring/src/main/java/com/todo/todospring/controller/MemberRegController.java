package com.todo.todospring.controller;

import com.todo.todospring.domain.MemberRegRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
@RequestMapping("/member/register")
public class MemberRegController {

    @GetMapping
    public String getRegForm(){
        return "member/regForm";
    }

    @PostMapping
    public String reg(
            MemberRegRequest regRequest,
            HttpServletRequest request // 실제 저장 경로를 찾기 위해
    ){

        log.info(regRequest);
        log.info(regRequest.toMember());


        return "redirect:/index.jsp";
    }

}
