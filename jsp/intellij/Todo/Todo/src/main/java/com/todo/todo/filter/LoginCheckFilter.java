package com.todo.todo.filter;

import com.todo.todo.domain.member.Member;
import com.todo.todo.mapper.LoginMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*, /mypage/*, /dept/*, /book/*, /orders/*"})
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*", "/mypage/*", "/dept/*", "/book/*", "/orders/*", "/index.jsp"})
@Log4j2
public class LoginCheckFilter implements Filter {

    // 아래 패턴은 Spring에서 사용하는 방식이라서 필터(서블릿방식)에서 처리하면 에러 발생함
//    private final TodoService todoService;
//
//    public LoginCheckFilter(TodoService todoService) {
//        this.todoService = todoService;
//    }
    //private TodoService service = new TodoService();

    @Autowired
    private LoginMapper loginMapper;

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        log.info("세션 확인 전 req.getCookies() => " + req.getCookies());

        if (session.getAttribute("loginInfo") == null) {

            Cookie cookie = findCookie(req.getCookies(), "uuid");

            log.info("쿠키 찾았나? => " + cookie);

            if (cookie != null) {

                String uuid = cookie.getValue();

                try {

                    Member member = null;
                    //@Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

                    member = loginMapper.selectByUUID(uuid);

                    if (member != null) {
                        log.info("uuid 값을 가지고 있는 회원의 정보로 로그인 처리. member => " + member);
                        session.setAttribute("loginInfo", member);

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                chain.doFilter(request, response);
                return;

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
