package com.todo.todo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(">>> 회원 로그인 여부 체크 <<< ");

        String uri = request.getRequestURI();
        log.info("uri ====> " + uri);

        HttpSession session = request.getSession();

        session.setAttribute("preUri", uri);

        // 회원 로그인 상태 체크
        session = request.getSession(false);

        // 회원이 로그인 상태이다!
        if (session != null && session.getAttribute("loginInfo") != null){
            log.info("회원 로그인 상태!!!");
            return true;
        }

        log.info("회원 비로그인 상태!!!");

      response.sendRedirect("/member/loginTodoMember");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
