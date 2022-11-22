package com.todo.todospring.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {

        log.info("회원 로그인 여부 체크...");

        // 세션 확인
        HttpSession session = request.getSession(false); // => false 의미: 세션이 만약에 없다면 null을 반환해준다. 혹 비워 두거나, true로 두면 isNew()메소드로 새롭게 만든 것인지에 대한 것을 물어봐야 한다.

        // 세션에 로그인 정보가 있으면 정상 처리 하고 return true 처리
        if (session != null && session.getAttribute("loginInfo") != null){
            log.info("로그인 상태!!!! ...");
            return true;
        }

        // 세션에 로그인 정보가 없으면 redirect("/login") return false 처리
        log.info("비 로그인 상태!!");
        response.sendRedirect("/login");
        // 그리고 다른 곳으로 가면 안되므로, 정상 흐름(마이페이지)으로 가면 안되므로 return false
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