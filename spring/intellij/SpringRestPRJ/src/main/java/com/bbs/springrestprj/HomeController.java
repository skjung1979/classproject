package com.bbs.springrestprj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home(Locale locale, Model model){
        return "JSONTest2";
    }

}
