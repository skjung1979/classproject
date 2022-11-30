package com.bbs.springrestprj.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "com.todo.todo.filter.UTF8Filter", urlPatterns = {"/*"})
@Log4j2
public class UTF8Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        log.info("UTF-8 필터 진입");

        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding("UTF-8");

        HttpSession session = ((HttpServletRequest) request).getSession();
        if (session.getAttribute("loginInfo") == null) {

            Cookie cookie = findCookie(req.getCookies(), "uuid");
            if (cookie != null){
                String uuid = cookie.getValue();
                session.setAttribute("existUUID",uuid);
            }

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
