package com.first.app.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Log4j2
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String index(){

        return "INDEX";
    }

}
