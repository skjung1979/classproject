package com.todo.todospring.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class IndexController {

    @RequestMapping("/index")
    public String getIndex(){



        return "index";
    }

}
