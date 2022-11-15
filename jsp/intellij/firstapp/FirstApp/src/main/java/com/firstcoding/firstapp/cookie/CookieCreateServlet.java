package com.firstcoding.firstapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "CookieCreateServlet", value = "/cookie/create")
@Log4j2
public class CookieCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 쿠키 사용자 생성
        Cookie cookie = new Cookie("userid", "cool");
        response.addCookie(cookie);
        cookie.setMaxAge(60*10); // 60초*10 -> 10분

        // 유니크한 식별 값 생성 / 파일 업로드 할때는 중복되는 경우가 있이니 이 파일명으로 업로드하게 하는 경우!!!
        UUID str = UUID.randomUUID();
        log.info("유니크한 식별 값 생성: " + str.toString());

        Cookie c = new Cookie("uuid", str.toString());
        c.setMaxAge(60*60*24*7); // 소멸 시간, 초단위 ex. 일주일

        c.setHttpOnly(true); // 자바스크립트에서 접속이 불가! 해킹 공격을 방어하기 위한 것

        response.addCookie(c);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/create.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
