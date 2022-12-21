package com.jpa.board.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/logout")
public class MemberLogoutController {

    @GetMapping
    public String getMemberLogout(HttpServletRequest request){

        HttpSession session = request.getSession();

        session.invalidate();

        return "redirect:/";
    }
}
