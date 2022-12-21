package com.jpa.board.controller.member;

import com.jpa.board.domain.MemberRegisterRequest;
import com.jpa.board.entity.member.Member;
import com.jpa.board.service.member.MemberRegisterService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member/register")
public class MemberRegisterController {

    @Autowired
    private MemberRegisterService memberRegisterService;

    @GetMapping
    public void getMemberRegister(){

    }

    @PostMapping
    public String postMemberRegister(
            MemberRegisterRequest memberRegisterRequest,
            HttpServletRequest request
    ){

        memberRegisterService.insertMember(memberRegisterRequest);

        return "redirect:/";
    }

}
