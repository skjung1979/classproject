package com.bbs.springrestprj.interceptor;

import com.bbs.springrestprj.domain.member.Member;
import com.bbs.springrestprj.service.login.LoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private LoginService loginService;

    @Override
    // preHandle() : 컨트롤러보다 먼저 수행되는 메서드
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(">>> 자동 로그인 체크 <<< ");

        /*로그인 후 접근했던 페이지로 바로 이동하게 하기 위한 세션 등록*/
        String uri = request.getRequestURI();
        log.info("uri ====> " + uri);
        HttpSession session = request.getSession();
        session.setAttribute("preUri", uri);

        // 회원 로그인 상태 체크
        session = request.getSession(false);

        // 로그인된 세션이 없다면,
        if (session.getAttribute("loginInfo") == null) {

            // 쿠키에 로그인 유지 체크 하면 생성된 uuid가 존재하는지 찾는다.
            Cookie cookie = findCookie(request.getCookies(), "uuid");

            // uuid라는 이름의 쿠키가 있니? 없니?
            log.info("로그인 세션은 null / 쿠키 찾았나? => " + cookie);

            // uuid 쿠키가 존재하는 경우
            if (cookie != null){

                // uuid 쿠키의 value을 uuid변수에 담는다.
                String uuid = cookie.getValue();

                log.info("loginService.selectByUUID(uuid) 실행 직전 / 쿠키의 uuid는? => " + uuid);

                // uuid를 DB에서 검색해서 결과를 member에 담는다.
                Member member = loginService.selectByUUID(uuid); // DB에서 해당 uuid를 조회한다.

                log.info("인터셉터 진입 / selectByUUID의 결과 member =>  " + loginService.selectByUUID(uuid));

                if (member != null){
                    log.info("uuid 값을 가지고 있는 회원의 정보로 로그인 처리. member => " + member);
                    // member는 세션에 담으면 자동 로그인 처리가 된다.
                    session.setAttribute("loginInfo", member);

                    if (session.getAttribute("preUri") != null){

                        response.sendRedirect(session.getAttribute("preUri").toString());
                        return true;
                    }

                    return false;
                }
            }
            // 여기는 로그인도 안되있고, 쿠키도 존재하지 않은 경우이므로,
            // 다시 로그인 폼으로 돌려보낸다.
            response.sendRedirect("/logins/login");
            return false;


        }
        // preHandel의 return은 컨트롤러 요청 URI로 가도 되는지 안되는지 허가하는 의미임.
        // 따라서 true로하면 컨트롤러 URI로 가게 됨.
        return true;
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
