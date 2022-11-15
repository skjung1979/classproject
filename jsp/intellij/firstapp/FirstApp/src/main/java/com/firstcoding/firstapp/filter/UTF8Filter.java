package com.firstcoding.firstapp.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "UTF8Filter", urlPatterns = {"/*"}) // 모든 요청에 대해 필터를 적용한다.
@Log4j2
public class UTF8Filter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        log.info("UTF-8 필터 진입");

        // 요청 처리 전 처리해야할 코드
        HttpServletRequest req = (HttpServletRequest) request; // 필터링 전 사용해야할 기본 request객체
        req.setCharacterEncoding("UTF-8"); // UTF-8필터링 완료


        chain.doFilter(request, response);

        // 응답 처리 전 처리해야 할 코드

    }
}
