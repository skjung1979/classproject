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

        // 사용자 입력 데이터 받기
        String uid = request.getParameter("uid");
        String pw = request.getParameter("pw");

        // uid외 pw만 갖는 객체를 생성한다. DTO에서 @Builder 롬복을 추가했기 때문!
        Member member = Member.builder()
                .uid(uid)
                .pw(pw)
                .build();
        log.info(member);

        int result = 0;

        try {

            result = MemberService.getInstance().insertMember(member); // service가 싱글톤이라 이렇게 호출함

        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

        if (result > 0) {
            log.info("회원 가입 처리 성공!!");
        }

        response.sendRedirect("/app/index.jsp"); // 임시로 인덱스로 보냄.

    }
}
