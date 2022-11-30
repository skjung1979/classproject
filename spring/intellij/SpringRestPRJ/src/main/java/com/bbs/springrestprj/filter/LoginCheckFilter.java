package com.bbs.springrestprj.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*", "/mypage/*", "/dept/*", "/book/*", "/orders/*"})
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {""})
@Log4j2
public class LoginCheckFilter implements Filter {

    // 아래 패턴은 Spring에서 사용하는 방식이라서 필터(서블릿방식)에서 처리하면 에러 발생함
//    private final TodoService todoService;
//
//    public LoginCheckFilter(TodoService todoService) {
//        this.todoService = todoService;
//    }
    //private TodoService service = new TodoService();

/* 필터에서는 서비스를 주입 받을 수 없다.
   @Autowired
    private LoginService loginService;*/

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        log.info("로그인 체크 필터 진입");
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        /*로그인 후 접근했던 페이지로 바로 이동하게 하기 위한 세션 등록*/
        String uri = req.getRequestURI();
        log.info("uri ====> " + uri);
        session = req.getSession();
        session.setAttribute("preUri", uri);

        log.info("세션 확인 전 req.getCookies() => " + req.getCookies());


        if (session.getAttribute("loginInfo") == null) {

            Cookie cookie = findCookie(req.getCookies(), "uuid");
            if (cookie != null){
                String uuid = cookie.getValue();
                session.setAttribute("existUUID",uuid);
            }

            log.info("비 로그인 상태 -> 로그인 페이지로 이동");

            res.sendRedirect("/login/loginTodoMember");
            return ;

        }

        chain.doFilter(request, response);

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
