package com.firstcoding.firstapp.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDeleteServlet", value = "/cookie/delete")
public class CookieDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 삭제
        // 삭제 메소드는 없으므로, 똑같은 이름의 쿠키를 만들고, 소멸 시간을 0으로 세팅한다.
        Cookie cookie = new Cookie("userid", "");
        cookie.setMaxAge(0);

        response.addCookie(cookie);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/delete.jsp");
        dispatcher.forward(request, response);

    }

}
