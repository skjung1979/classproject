package com.firstcoding.mvc.springmvc.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

//    @ExceptionHandler(NumberFormatException.class) // Exception.class로 바꾸면 모든 예외를 다 받는다.
//    @ResponseBody
//    public String exceptionNumber(NumberFormatException exception){
//
//        log.info("예외 발생!!! => " + exception.getMessage());
//
//        return "NumberFormatException...";
//    }
//
//    @ExceptionHandler(NullPointerException.class) // Exception.class로 바꾸면 모든 예외를 다 받는다.
//    @ResponseBody
//    public String exceptionNumber(NullPointerException exception){
//
//        log.info("예외 발생!!! => " + exception.getMessage());
//
//        return "NullPointerException...";
//    }

    @ExceptionHandler(Exception.class) // Exception.class로 바꾸면 모든 예외를 다 받는다.
    @ResponseBody
    public String exceptionNumber(Exception exception){

        log.info("예외 발생!!! => " + exception.getMessage());

        StackTraceElement[] stackTraceElements =  exception.getStackTrace();

        StringBuffer buffer = new StringBuffer("<h1>");
        buffer.append(exception.getMessage() + "</h1>");
        buffer.append("<hr>");

        for (StackTraceElement element : stackTraceElements){
            buffer.append("<div>" + element + "</div>");
        }

        return buffer.toString();
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 응답 코드가 404(페이지가 없는데 접근할때)일때 처리되는 예외 => 예외에 대하여 특별 뷰 페이지를 커스터마이징하는 것이다.
    public String notFound(){

        return "custom404"; // custom404.jsp로 이동
    }

}
