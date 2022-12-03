package com.bbs.springrestprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Locale locale, Model model) {
        return "JSONtest2";
    }

    @GetMapping("boards/register")
    public String register() {
        return "board/register";
    }

    @GetMapping("boards/list")
    public String list() {
        return "board/list";
    }

    @GetMapping("boards/read")
    public String listOne(){
        return "board/read";
    }

    @GetMapping("boards/edit")
    public String edit(){
        return "board/edit";
    }

    @GetMapping("members/register")
    public String regMem(){
        return "member/regform";
    }

    @GetMapping("members/mypage")
    public String mypage(){
        return "member/mypage";
    }

    @GetMapping("logins/login")
    public String login(){
        return "login/login";
    }

//    로그아웃은 여기가 아닌 LogoutController로 연결되어 로그아웃 됨

}
