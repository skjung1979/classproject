package com.firstcoding.mvc.springmvc.interceptor;

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

        log.info(">>> 회원 로그인 여부 체크 >>>");

        // 회원 로그인 상태 체크
        HttpSession session = request.getSession(false);

        // 회원이 로그인 상태이다!!! => 세션이 null이 아니다. & loginInfo(로그인 후 이 세션은 null이 아닌것을 넣으므로!)가 null이 아니다.
        if (session != null && session.getAttribute("loginInfo") != null){

            log.info("로그인 상태!!!");
            return true; // Controller로 이동한다.
        }

        log.info("비로그인 상태!!!");
        response.sendRedirect("/login");
        return false; // => 다음 단계로 넘어가지 않으려면 return false이어야 한다.
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
