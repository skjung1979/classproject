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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    ) {
        return "views/member/regform";
    }

    @PostMapping
    public String reTodoMember(
            MemberRegRequest memberRegRequest,
            //@Valid MemberRegRequest memberRegRequest, // @valid 기능을 제대로 못함
            HttpServletRequest request, // 파일의 실제 저장 경로를 찾기 위한 것
            //BindingResult bindingResult,
            Model model
    ) throws Exception {

//        log.info("회원 가입 post 진입 >>>>>>>>>>>>  "+bindingResult.hasErrors());
//        if (bindingResult.hasErrors()){
//
//            model.addAttribute("regmem", memberRegRequest);
//
//            log.info("bindingResult.hasErrors() 진입");
//
//            return "views/member/regform";
//        }

        if (memberRegRequest.getUsername().equals("") || memberRegRequest.getUserid().equals("") || memberRegRequest.getUserpw().equals("")) {
            model.addAttribute("regmem", memberRegRequest);
            model.addAttribute("msg2", "회원명, ID, PW는 빈칸이 허용 안됩니다.");

            log.info("memberRegRequest => " + memberRegRequest);

//            return "redirect:/member/regTodoMember";
            return "views/member/regform";
        }


        log.info(memberRegRequest);

        memberRegService.insertTodoMember(memberRegRequest, request);

        return "redirect:/login/loginTodoMember";
    }

}
