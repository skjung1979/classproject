package com.jpa.board.controller.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member/logout")
@Log4j2
public class MemberLogoutController {

    @GetMapping
    public String getMemberLogout(HttpServletRequest request){

        HttpSession session = request.getSession();

        //session.invalidate();
        session.setAttribute("loginInfo", null); // 값만 없애는 방법으로 로그아웃 처리해도 된다.
        session.setAttribute("preUri", null);
        session.setAttribute("preQs", null);

        log.info("session.setAttribute(\"logingInfo\", null) 후 .................... ==> " + session.getAttribute("loginInfo"));

        return "redirect:/";
    }
}
