package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("/view")
    public String viewCookie(
            @CookieValue("userName") String userName,
            @CookieValue(name = "auth" ,defaultValue = "ok") String auth,
            Model model,
            @RequestHeader("Referer") String referer
    ){

        log.info("Referer => " + referer);
        log.info("auth => " + auth);
        log.info("cookie/view userName 로그 => " + userName);

        model.addAttribute("cookieName", "userName");
        model.addAttribute("cookieValue", userName);

        return "cookie/view";
    }


    @GetMapping("/make") // /cookie 뒤쪽으로 들어감
    public String makeCookie(
            HttpServletResponse response
    ){
        Cookie cookie = new Cookie("userName", "son");
        cookie.setPath("/");
        cookie.setMaxAge(60*60); // 1시간

        response.addCookie(cookie);

        return "cookie/make";
    }

}
