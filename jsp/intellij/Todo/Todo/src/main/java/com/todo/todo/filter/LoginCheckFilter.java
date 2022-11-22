package com.todo.todo.filter;

import com.todo.todo.member.Member;
import com.todo.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/todo/*")
@Log4j2
public class LoginCheckFilter implements Filter {

    private final TodoService todoService;

    public LoginCheckFilter(TodoService todoService) {
        this.todoService = todoService;
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if (session.getAttribute("loginInfo") == null){
            Cookie cookie = findCookie(req.getCookies(), "uuid");

            if (cookie != null){
                String uuid = cookie.getValue();

                try {
                    Member member = todoService.selectByUUID(uuid);

                    if (member != null) {
                        log.info("uuid 값을 가지고 있는 회원의 정보롤 로그인 처리");
                        session.setAttribute("loginInfo", member.getMemberid());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

                chain.doFilter(request, response);
                return;

            }

            log.info("비 로그인 상태 -> 로그인 페이지로 이동");
            res.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }

    private Cookie findCookie(Cookie[] cookies, String name){
        if (cookies == null || cookies.length == 0){
            return null;
        }

        Cookie cookie = null;

        for (int i=0; i<cookies.length; i++){
            if (name.equals(cookies[i].getName())){
                cookie = cookies[i];
                break;
            }
        }
        return cookie;
    }

}
