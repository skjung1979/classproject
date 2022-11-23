package com.firstcoding.mvc.springmvc.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    @ExceptionHandler(NumberFormatException.class) // Exception.class로 바꾸면 모든 예외를 다 받는다.
    @ResponseBody
    public String exceptionNumber(NumberFormatException exception){

        log.info("예외 발생!!! => " + exception.getMessage());

        return "NumberFormatException...";
    }

    @ExceptionHandler(NullPointerException.class) // Exception.class로 바꾸면 모든 예외를 다 받는다.
    @ResponseBody
    public String exceptionNumber(NullPointerException exception){

        log.info("예외 발생!!! => " + exception.getMessage());

        return "NullPointerException...";
    }


}
