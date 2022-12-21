package com.jpa.board.controller.member;

import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/mypage")
@Log4j2
public class MemberMypageController {

    @GetMapping
    public void getMypage(){

    }

}
