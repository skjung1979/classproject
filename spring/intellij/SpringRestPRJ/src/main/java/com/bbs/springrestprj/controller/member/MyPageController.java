package com.bbs.springrestprj.controller.member;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@Log4j2
public class MyPageController {

    @GetMapping
    public String getMypage(){

        return "member/mypage";
    }

}