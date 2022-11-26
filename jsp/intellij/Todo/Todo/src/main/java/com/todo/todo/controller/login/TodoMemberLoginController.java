package com.todo.todo.controller.login;

import com.todo.todo.domain.member.Member;
import com.todo.todo.service.login.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Controller
@Log4j2
@RequestMapping("/login/loginTodoMember")
public class TodoMemberLoginController {

    private final LoginService loginService;

    public TodoMemberLoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String getLoginTodoMember (){

        return "views/login/login";
    }

    @PostMapping
    public String postLoginTodoMember (
            HttpServletRequest request,
            HttpServletResponse response,
            RedirectAttributes redirectAttributes // 필요한 쿼리스트링을 구성하기 위함
    ) {
        String userid = request.getParameter("userid");
        String userpw = request.getParameter("userpw");
        String idremember = request.getParameter("idremember");
        String keeplogin = request.getParameter("keeplogin");

        log.info("userid: " + userid);
        log.info("pw: " + userpw);
        log.info("idremember: " + idremember); // on 또는 null로 값이 넘어옴
        log.info("keeklogin: " + keeplogin); // on 또는 null로 값이 넘어옴

        // 아이디 저장에 대한 처리: 체크하면 reId 쿠키 생성 아니면 소멸
        if (idremember != null){
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(60*60*24*180);
            c.setPath("/");
            response.addCookie(c);
        } else {
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(0);
            c.setPath("/");
            response.addCookie(c);
        }

        // 로그인 처리를 위한 기본 작업 => 현재 세션으로 객체를 생성한다.
        HttpSession session = request.getSession(); // 로그인 처리를 위해 현재 세션 객체 생성

        // 입력받은 아이디와, 패스워드를 DTO에 저장한다.
        try {
            Member member = loginService.login(userid, userpw);

            if (member == null){

                redirectAttributes.addAttribute("type", "nf");

                //return "redirect:/member/loginTodoMember?error=nf";
                return "redirect:/login/loginTodoMember";
            }

            if (keeplogin != null && keeplogin.equals("on")){

                UUID uuid = UUID.randomUUID();
                Cookie c1 = new Cookie("uuid", uuid.toString());
                c1.setMaxAge(60*60*24*30);
                c1.setPath("/");
                response.addCookie(c1);

                loginService.updateUUID(member.getSeq(), uuid.toString());
                member.setUuid(uuid.toString());
            }

            session.setAttribute("loginInfo", member);
            log.info("로그인 처리 후 member => " + member);

            if (session.getAttribute("preUri") != null){
                String str = "redirect:" + session.getAttribute("preUri");
                return str;
            } else {
                return "redirect:/";
            }

        } catch (Exception e) {
            //throw new RuntimeException(e);

            redirectAttributes.addAttribute("type", "e");

            return "redirect:/login/loginTodoMember";
        }
    }
}
