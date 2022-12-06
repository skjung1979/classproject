package com.first.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class IndexController {

    @GetMapping("/")
    @ResponseBody // 이것을 넣으면 리턴값이 텍스트로 표시된다!!
    public String index(){

        log.info(">>> get | / ");

        return "INDEX";
    }

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("msg", "ddd안녕하세요~ Srping Boot!!!");

        return "hello"; // resources/templates/hello.html을 찾아간다!!!
        //return "test/hello"; // resources/templates/test/hello.html을 찾아간다!!!
    }


}
