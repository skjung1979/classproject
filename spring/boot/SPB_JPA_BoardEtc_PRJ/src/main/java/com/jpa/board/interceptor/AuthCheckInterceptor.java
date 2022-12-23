package com.jpa.board.interceptor;

import com.jpa.board.service.member.MemberLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Component // spring boot에서는 이 어노테이션 설정을 해줘야 bean이 생성된다.
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberLoginService memberLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 로그인 후 접근했던 페이지로 바로 이동하게 하기 위한 세션 등록
        String uri = request.getRequestURI();
        String query = request.getQueryString();
        log.info("uri ==========> " + uri);
        log.info("query string ==========> " + query);
        HttpSession session = request.getSession();
        session.setAttribute("preUri", uri);
        session.setAttribute("preQs", query);

        // 회원 로그인 상태체크
        session = request.getSession();

        // 로그인된 세션이 없다면,
        if (session.getAttribute("loginInfo") == null){
            response.sendRedirect("/member/login");
            return false;
        }

        //return HandlerInterceptor.super.preHandle(request, response, handler);
        return true;
    }
}
