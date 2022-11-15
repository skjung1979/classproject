package com.firstcoding.firstapp.filter;

import com.firstcoding.firstapp.login.domain.Member;
import com.firstcoding.firstapp.login.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/mypage/*"})
@Log4j2
public class LoginCheckFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        log.info("로그인 체크 필터 진입");
        
        // Session 객체에 loginInfo 속성이 존재하는지 체크 => 로그인 체크
        // 존재하지 않으면 -> 로그인 페이지로 이동!

        HttpServletRequest req = (HttpServletRequest) request; // 상위 변수가 하위 타입으로 들어가므로!!!
        HttpServletResponse res = (HttpServletResponse) response;

        // 현재 세션 구하기
        HttpSession session = req.getSession();

        if (session.getAttribute("loginInfo") == null){

            // 쿠키 체크: uuid . 생성한 findCookie메소드 이용
            Cookie cookie = findCookie(req.getCookies(), "uuid");

            if (cookie != null) {
                String uuid = cookie.getValue();

                log.info("uuid Cookie에 존재");

                // DB에서 uuide값(자동로그인을 위한 값)을 가지는 회원 데이터를 찾는다.
                try {
                    Member member = MemberService.getInstance().selectByUUID(uuid);

                    // 찾은 결과 member가 널이 아니면... 세션 loginInfo에 member.getUid()를 담는다.
                    if (member != null){
                        log.info("uuid 값을 가지고 있는 회원의 정보로 로그인 처리");
                        session.setAttribute("loginInfo", member.getUid());
                    }

                } catch (Exception e) {
                    //throw new RuntimeException(e);
                    e.printStackTrace();
                }

                // 여기까지 잘 오면, 아래는 가지 않고, 빠져 나가야한다.
                chain.doFilter(request, response);
                return;

            }

            log.info("비 로그인 상태 -> 로그인 페이지로 이동");
            res.sendRedirect("/app/login");
            return;
        }

        chain.doFilter(request, response);

    }
    // Cookie[]을 전달하고, 찾고자하는 Cookie 이름을 전달하면, 쿠키값을 반환해주는 메소드
    private Cookie findCookie(Cookie[] cookies, String name) {

        if (cookies == null || cookies.length == 0){
            return null;
        }

        Cookie cookie = null;

        // 찾기
        for (int i=0; i<cookies.length; i++){
            if (name.equals(cookies[i].getName())){
                cookie = cookies[i];
                break;
            }
        }
        return cookie;
    }

}















