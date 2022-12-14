package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.UserRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Controller
@RequestMapping("/date")
@Log4j2
public class DateConverterController {

    @RequestMapping(method = RequestMethod.GET)
    public String getDateForm(){

        return "dateForm";
    }

    @PostMapping
    public String date(
            LocalDate date,
            UserRequest userRequest, // 커맨드 방식
            Model model
    ){

        model.addAttribute("date", date);

        return "date";
    }

}
