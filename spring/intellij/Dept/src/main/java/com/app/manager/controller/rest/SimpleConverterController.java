package com.app.manager.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mc/simple")
@Log4j2
public class SimpleConverterController {

    @GetMapping
    public void form(){
       log.info("form...");

    }

    @PostMapping
    @ResponseBody
    public String simple(@RequestBody String body){// body의 모든 데이터를 문자타입으로 받아온다.

        log.info("body >>>>> " + body);

        return "body >>>>> " + body;
    }

}
