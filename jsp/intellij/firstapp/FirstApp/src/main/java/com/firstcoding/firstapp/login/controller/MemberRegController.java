package com.firstcoding.firstapp.login.controller;

import com.firstcoding.firstapp.login.domain.Member;
import com.firstcoding.firstapp.login.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MemberRegController", value = "/member/register")
@Log4j2
public class MemberRegController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("회원 가입 폼 진입...");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/member/regform.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("회원 가입 처리 doPost() 진입");

        // 사용자 입력 데이터 받고,
        String uid = request.getParameter("uid");
        String pw = request.getParameter("pw");

        // 입력받은 uid와 pw만 갖는 객체를 생성한다. 빌더 패턴을 이용해도 좋고, 세터를 이용해도 좋다.
        Member member = Member.builder()
                .uid(uid)
                .pw(pw)
                .build();
        log.info(member);

        int result = 0;

        try {
            // 입력받은 uid와 pw가 담긴 member를 전달하며 MemberService의 insert()메소드를 호출한다. 싱글톤이라 객체는 생성하지 않고, getInstance()로 호출함
            result = MemberService.getInstance().insertMember(member);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        if (result > 0) {
            log.info("회원 가입 처리 성공!!");
        }

        response.sendRedirect("/app/index.jsp"); // 회원 가입 성공 후 index.jsp화면으로 이동.

    }
}
