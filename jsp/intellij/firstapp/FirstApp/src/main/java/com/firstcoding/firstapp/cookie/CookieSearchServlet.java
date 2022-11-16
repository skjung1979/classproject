package com.firstcoding.firstapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieSearchServlet", value = "/cookie/search")
@Log4j2
public class CookieSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 쿠키 서치
        // 쿠키 이름을 가겨온다.
        String cookieName = request.getParameter("cname");
        log.info(cookieName);
        String value = "";
        Cookie[] cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++){
            Cookie c = cookies[i];
            if (cookieName.equals(c.getName())){
                value = c.getValue();
                break;
            }
        }
        log.info(value);

        request.setAttribute("result", value);
        // cname은 파라미터로 뷰에서 받음.

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/search.jsp");
        dispatcher.forward(request, response);

    }
}
