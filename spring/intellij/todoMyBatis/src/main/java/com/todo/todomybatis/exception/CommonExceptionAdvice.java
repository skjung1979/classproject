package com.todo.todomybatis.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {

    // 404코드에 대한 예외 처리
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // 응답 코드가 404(페이지가 없는데 접근할때)일때 처리되는 예외 => 예외에 대하여 특별 뷰 페이지를 커스터마이징하는 것이다.
    public String notFound(){

        return "custom404"; // custom404.jsp로 이동
    }


}
