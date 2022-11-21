package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.datatransfer.DataFlavor;
import java.util.Map;

@Controller
@RequestMapping("/login") // 이번에는 클래스 선언부에서 메소드에는 GET/POST 설정해야하므로
@Log4j2
public class LoginController {

    // @RequestMapping(method = RequestMethod.GET) 예전 방식
    @GetMapping // 요즘 방식
    public String getLoginForm(Model model){
        // /login으로 들어올때 처음 보여지는 화면의 내용을 위한 코딩들

        model.addAttribute("msg", "아이디와 패스워드를 반드시 입력하세요.");

        return "login/form"; // => /WEN-INF/views/login/form.jsp를 찾으라고 보낸다.
    }

    // @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String login(
            String uid, // 이렇게 사용하면 안됨 보안 위험, 비추
            String pw, // 이렇게 사용하면 안됨 보안 위험, 비추
            @RequestParam(value = "p", defaultValue = "1") String page, // RequestParam으로 받아와야 안전하게 받아올수 있다.
            HttpServletRequest request, // 이렇게 해도 파라미터 받을 수 있다.
            HttpServletResponse response,
            LoginRequest loginRequest, // 모델(domain)에 객체(변수가 파라미터와 일치하도록)를 만들어서 매개변수를 받아온다.
            // 파라미터로 들어온 LoginRequest는 jsp에서 보여질때는 별도로 이름 지정하지 않아도 맨앞자만 소문자로 해서 사용할 수 있다.
            // ex) ${loginRequest}
            // 하지만 이름을 지정 할 수도 있다. 아래처럼
            @ModelAttribute("req") LoginRequest loginRequest2, // => jsp에서 공유하면 ${req}로 사용하면 된다. (객체 방식 유용!!!)
            @RequestParam Map paraMap   // Map 형태로 받는다. (String, String)으로 받아온다.
    ){ // <- 매개변수에 받아오는 파라미터를 담아오는 여러가지 방법들

        String uId2 = request.getParameter("uid");  // 위 매개변수에서 request를 받았다.
        String pw2 = request.getParameter("pw");    // 위 매개변수에서 request를 받았다.

        log.info("uid => " + uid);
        log.info("pw => " + pw);
        log.info("p => " + page);
        log.info("uId2 => " + uId2);
        log.info("pw2 => " + pw2);
        log.info("loginRequest => " + loginRequest);
        log.info("paraMap => " + paraMap);


        request.getSession().setAttribute("loginInfo", uid); // 로그인 됐다는 설정을 세션에 해 주었음

        //return "login/login"; // redirect:/index 이렇게 하면 sendRedirect() 효과가 있다.
        return "redirect:/mypage/mypage1";
    }

    @GetMapping("/info") // http://localhost:8080/login/info
    public String info(){
        return "login/info";
    }
}
