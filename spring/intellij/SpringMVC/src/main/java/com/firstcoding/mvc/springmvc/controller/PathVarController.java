package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
public class PathVarController {

    // 경로의 일부를 변수처럼 사용한다. 특정 위치에 있는 자원을 가져온다!!

    // http://localhost:8080/member/1 <== 뒷 숫자는 변수(idx)처럼 사용하려고 한다.
    // http://localhost:8080/member/11 <== 뒷 숫자는 변수처럼 사용하려고 한다.
    // http://localhost:8080/member/30 <== 뒷 숫자는 변수처럼 사용하려고 한다.

    @RequestMapping("/members/{type}/{idx}") // 이렇게 경로를 전달 받을 수 있다.
    public String getMemberInfo(
            @PathVariable("type") String type,
            @PathVariable("idx") String idx, // 위에 있는 {idx}를 가리킴
            Model model
    ){
        log.info("idx => " + idx);
        log.info("type => " + type);

        model.addAttribute("idx", idx);
        model.addAttribute("type", type);

        return "info";
    }

}
