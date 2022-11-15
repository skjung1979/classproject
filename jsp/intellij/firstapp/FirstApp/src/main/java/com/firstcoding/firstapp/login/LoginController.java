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

        // 현재 세션으로 객체 생성한다. <- 로그인 처리를 위한 기본 작업
        HttpSession session = request.getSession();

        // 로그인 처리
        // 아이디와 패스워드 비교 -> 실제로는... db에 저장되어 있는 회원 정보에서 id, pw가 일치하는지
        // 지금은 임시로 id, pw가 같으면 로그인 처리를 한다. -> session 속성에 회원의 정보를 저장
        if (userid.equals(pw)){
            session.setAttribute("loginInfo", "로그인 되었음!"); // 로그인 후 보여줄 메시지 속성을 세팅함
            response.sendRedirect("/app/index.jsp"); // 로그인 정보가 일치하면 메인 페이지로 이동함!
        } else {
            response.sendRedirect("/app/login"); // 로그인 정보 일치하지 않으면 다시 로그인 화면으로!
        }

    }
}
