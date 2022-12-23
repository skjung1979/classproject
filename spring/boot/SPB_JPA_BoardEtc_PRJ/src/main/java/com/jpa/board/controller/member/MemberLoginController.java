package com.jpa.board.controller.member;

import com.jpa.board.entity.member.Member;
import com.jpa.board.repository.MemberRepository;
import com.jpa.board.service.member.MemberLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Optional;

@Controller
@RequestMapping("/member/login")
@Log4j2
public class MemberLoginController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberLoginService memberLoginService;

    @GetMapping
    public void getMemberLogin(){

    }

    @PostMapping
    public String postMemberLogin(
            @RequestParam("memid") String memid,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ) throws Exception {
        log.info("@Requestpara memid, password ==> " + memid + "/" + password);

        HttpSession session = request.getSession();

        Member result = memberLoginService.selectByIdPw(memid, password);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (result == null) {
            out.println("<script charset=\"utf-8\"> alert('아이디 또는 비밀번호가 틀립니다.');");
            out.println("history.go(-1); </script>");
            out.close();
            throw new Exception("회원의 아이디 또는 비밀번호 확인!!!");
        }

        log.info("result............... ==> " + result);

        session.setAttribute("loginInfo", result);
        session.setMaxInactiveInterval(60*60);

        log.info("getSession...........==> " + session.getAttribute("loginInfo"));

        if (session.getAttribute("preUri") != null){

            String uri = (String) session.getAttribute("preUri");
            String qs = (String) session.getAttribute("preQs");

            return "redirect:" + uri + "?" + qs;
        }

        return "redirect:/member/mypage";
    }

}
