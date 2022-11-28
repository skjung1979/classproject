package com.todo.todomybatis.interceptor;

import com.todo.todomybatis.domain.member.Member;
import com.todo.todomybatis.service.login.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor_ori implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        log.info(">>> 회원 로그인 여부 체크 <<< ");
        log.info(">>> 자동 로그인 체크 <<< ");

        HttpSession session = request.getSession();

        // 회원 로그인 상태 체크
        session = request.getSession(false);


        if (session.getAttribute("loginInfo") == null) {

            Cookie cookie = findCookie(request.getCookies(), "uuid");

            // uuid라는 이름의 쿠키가 있니? 없니?
            log.info("로그인 세션은 null / 쿠키 찾았나? => " + cookie);

            if (cookie != null){
                // uuid 쿠키가 있는 경우

                String uuid = cookie.getValue(); // 쿠키의 value를 uuid에 넣는다.

                log.info("loginService.selectByUUID(uuid) 실행 직전 / 쿠키의 uuid는? => " + uuid);

                Member member = loginService.selectByUUID(uuid); // DB에서 해당 uuid를 조회한다.

                log.info("인터셉터 진입 / selectByUUID의 결과 member =>  " + loginService.selectByUUID(uuid));

                if (member != null){
                    log.info("uuid 값을 가지고 있는 회원의 정보로 로그인 처리. member => " + member);
                    session.setAttribute("loginInfo", member);
                }

            }


        } else if (session != null && session.getAttribute("loginInfo") != null){
            log.info("회원 로그인 상태!!!");
            return true;
        }



        // 회원이 로그인 상태이다!
/*        if (session != null && session.getAttribute("loginInfo") != null) {
            log.info("회원 로그인 상태!!!");
            return true;
        }*/

        log.info("회원 비로그인 상태!!!");

        response.sendRedirect("/login/loginTodoMember");
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

    private Cookie findCookie(Cookie[] cookies, String name) {

        if (cookies == null || cookies.length == 0) {
            return null;
        }

        Cookie cookie = null;

        for (int i = 0; i < cookies.length; i++) {
            if (name.equals(cookies[i].getName())) {
                cookie = cookies[i];
                break;
            }
        }
        return cookie;
    }
}
