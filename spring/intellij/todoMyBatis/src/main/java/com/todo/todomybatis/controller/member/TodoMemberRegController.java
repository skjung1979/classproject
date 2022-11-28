package com.todo.todomybatis.controller.member;

import com.todo.todomybatis.domain.member.MemberRegRequest;
import com.todo.todomybatis.service.member.MemberRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/member/regTodoMember")
@Log4j2
public class TodoMemberRegController {

    @Autowired(required = false)
    private MemberRegService memberRegService;

    @GetMapping
    public String regTodoMember(
            HttpServletRequest request,
            HttpServletResponse response,
            Model model
    ){
        return "views/member/regform";
    }

    @PostMapping
    public String reTodoMember(
            @Valid MemberRegRequest regRequest,
            HttpServletRequest request, // 파일의 실제 저장 경로를 찾기 위한 것
            BindingResult bindingResult,
            Model model
    ) throws Exception {
        log.info("회원 가입 post 진입 >>>>>>>>>>>>  "+bindingResult.hasErrors());

        if (bindingResult.hasErrors()){

            model.addAttribute("regmem", regRequest);

            log.info("bindingResult.hasErrors() 진입");

            return "views/member/regform";
        }

        log.info(regRequest);

        memberRegService.insertTodoMember(regRequest, request);

        return "redirect:/login/loginTodoMember";
    }

}
