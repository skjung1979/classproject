package com.firstcoding.firstapp.mypage;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyPageController", value = "/mypage/mypage")
@Log4j2
public class MyPageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Mypage 진입");

        // 필터 처리 했으므로 모두 주석 처리함
        // 현재 로그인 상태인지 확인해야 함
       /* HttpSession session = request.getSession();
*/
     /*   if (session.isNew()){ // 세션이 새로 생성되었다면
            log.info("비 로그인 상태 ...");
            response.sendRedirect("/app/login");
            return; // 아래 dispatcher로 접근하지 않도록 함.
        }*/

       /* if (session.getAttribute("loginInfo") == null){
            log.info("비 로그인 상태 ...");
            response.sendRedirect("/app/login");
            return; // 아래 dispatcher로 접근하지 않도록 함.
        }
*/

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mypage/mypage.jsp");
        dispatcher.forward(request, response);

    }
}
