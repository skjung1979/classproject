package com.app.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept/register")
public class DeptRegController {

    @GetMapping
    public void getRegForm(){

    }

    @PostMapping
    public String reg(){

        return "redirect:/dept/list";
    }

}
