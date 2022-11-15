package com.firstcoding.firstapp.login;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
@Log4j2
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 폼 화면

        log.info("로그인 폼 페이지 진입");






        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/loginform.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 입력 받은 데이터 처리

        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String idremember = request.getParameter("idremember");
        String rememberMe = request.getParameter("rememberme");

        log.info("userid: " + userid);
        log.info("pw: " + pw);
        log.info("idremember: " + idremember); // on 또는 null로 값이 넘어옴
        log.info("rememberme: " + rememberMe); // on 또는 null로 값이 넘어옴

        // idremember가 null이 아니면 userid를 쿠키에 저장
        if (idremember != null){
            // idremember를 위한 쿠키 생성
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(60*60*24*180); // 사용기간 설정 ex) 6개월
            response.addCookie(c); // 생성한 쿠키 객체를 저장한다.
        } else {
            // 아이디 저장 체크를 해제하는 경우
            Cookie c = new Cookie("reId", userid);
            c.setMaxAge(0); // 사용기간을 0으로 하면 쿠키를 삭제하는 것이므로.
            response.addCookie(c);
        }

    }
}
