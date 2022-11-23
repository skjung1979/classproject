package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @RequestMapping("/sample") // 첫번째 방법
    public ModelAndView getSamplePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample"); // => /WEB-INF/views/sample.jsp

        return mav;
    }

    @RequestMapping("/sample2") // 두번째 방법
    public String getStringPage(){
        
        return "sample2"; // => /WEB-INF/views/sample.jsp
    }
    @RequestMapping("/sample3") // 세번째 방법 => 이 경우는 리턴 경로가 없지만, => /WEB-INF/views/sample3.jsp 이 파일을 찾으려고 한다.
    public void getVoidPage(){

    }

    @RequestMapping("/sample4")
    @ResponseBody // 응답(return)을 반환타입 String(아래줄)으로 해주는 역할
    public String page(){
        return "String Response...";
    }

    @RequestMapping("/sample5")
    @ResponseBody
    public String page2(
            int num
    ){

        String str = null; // 예외 발생을 위한 코딩
        str.trim();

        return String.valueOf(num); // num를 url에서 파라미터로 받도록 함
    }
    
}
