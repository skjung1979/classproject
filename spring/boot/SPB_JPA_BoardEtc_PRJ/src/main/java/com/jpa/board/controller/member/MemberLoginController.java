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
import javax.servlet.http.HttpSession;
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
    public String postmemberLogin(
            @RequestParam("memid") String memid,
            @RequestParam("password") String password,
            HttpServletRequest request
    ) throws Exception {
        log.info("@Requestpara memid, password ==> " + memid + "/" + password);

        HttpSession session = request.getSession();

        Optional<Member> result = memberRepository.findByMemid(memid, password);

        if (result.isEmpty()) {
            throw new Exception("회원의 아이디 또는 비밀번호 확인!!!");
        }

        log.info("result............... ==> " + result.get());

        session.setAttribute("loginInfo", result.get());

        log.info("getSession...........==> " + session.getAttribute("loginInfo"));

        return "redirect:/member/mypage";
    }

}
