package com.firstcoding.firstapp.login;

import com.firstcoding.firstapp.login.domain.Member;
import com.firstcoding.firstapp.login.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

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

        // 입력 받은 데이터를 변수에 담는다.
        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String idremember = request.getParameter("idremember");
        String rememberMe = request.getParameter("rememberme");

        log.info("userid: " + userid);
        log.info("pw: " + pw);
        log.info("idremember: " + idremember); // on 또는 null로 값이 넘어옴
        log.info("rememberme: " + rememberMe); // on 또는 null로 값이 넘어옴

        // idremember(아이디저장)가 null이 아니면 userid를 쿠키에 저장
        if (idremember != null) { // 아이디 저장이 체크 되었다면,
            Cookie c = new Cookie("reId", userid); // 아이디 저장을 위한 쿠키 객체 생성
            c.setMaxAge(60 * 60 * 24 * 180); // 사용기간 6개월로 설정
            c.setPath("/app"); // contextPath를 별도로 설정했다면 경로 세팅해야 한다.
            response.addCookie(c); // 생성한 쿠키 객체를 브라우저의 쿠키에 추가한다.
            log.info("아이디 저장 체크 상태 : " + c.getValue());
        } else { // 아이디 저장을 체크하지 않았다면,
            Cookie c = new Cookie("reId", userid); // 아이디 저장 체크 되지 않은 상태라도 쿠키 객체를 생성
            c.setMaxAge(0); // 사용기간을 0으로 하면 쿠키를 삭제하는 효과가 나타남
            c.setPath("/app"); // contextPath를 별도로 설정했다면 경로 세팅해야 한다.
            response.addCookie(c);
            log.info("아이디 저장 체크 해제 상태 : " + c.getValue());
        }

        // 현재 세션으로 객체 생성한다. <- 로그인 처리를 위한 기본 작업
        HttpSession session = request.getSession(); // 로그인 처리를 위해 현재 세션 객체 생성

        // 아이디와 패스워드 비교 -> db에 저장되어 있는 회원 정보에서 id, pw가 일치하는지 -> 일치하면 로그인 성공
        try {
            Member member = MemberService.getInstance().login(userid, pw); // 입력 받은 userid와 pw로 로그인 진행

            if (member == null) { // 만약 로그인 진행 결과 반환값이 null이면 아이디와 패스워드가 일치하는 정보가 없는 것
                response.sendRedirect("/app/login?error=nf"); // 파라미터를 login.jspt로 보내서 아이디,패스워드 경고창이 뜨도록 작성한다.
                return;
            }
            // 로그인이 성공적으로 된 상태인 이곳에서
            // 로그인 유지를 체크(rememberme 값이 on)하면 -> member테이블의 uuid 컬럼에 난수 발생시킨 uuid를 업데이트한다.
            if (rememberMe != null && rememberMe.equals("on")) { // 로그인 유지 체크(rememberMe 체크가 null이 아니거나 on인 상태)했다면

                // Cookie에 저장, DB 업데이트
                UUID uuid = UUID.randomUUID(); // uuid난수를 발생하여 uuid 변수에 담고,
                Cookie c1 = new Cookie("uuid", uuid.toString()); // 난수uudid의 스트링 값을 uuid에 담아  쿠키 객체를 생성한다.
                c1.setMaxAge(60 * 60 * 24 * 30); // 한달
                response.addCookie(c1); // 쿠키 객체를 쿠키에 추가

                // 로그인한 사용자의 정보로 uuid 업데이트 진행!!!
                MemberService.getInstance().updateUUID(member.getIdx(), uuid.toString()); // 그리고 idx와 uuid를 매개 변수로 넘겨 member테이블의 uuid컬럼을 업데이트한다.
            }

            // 아이디와 비번이 일치하는 회원이 존재 -> 로그인 처리
            session.setAttribute("loginInfo", member.getUid()); // 필요한 정보를 logInfo에 담는다.
            response.sendRedirect("/app/index.jsp");

        } catch (Exception e) {
            //throw new RuntimeException(e);
            response.sendRedirect("/app/login?error=e");

        }


    }
}
