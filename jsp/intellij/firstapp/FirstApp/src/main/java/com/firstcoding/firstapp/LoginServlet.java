package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/logins")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자가 login.html에서 입력한 데이터를 추출
        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");

        if (userid.equals(pw)){
            response.sendRedirect("mypage.jsp"); // 맞다면 마이페이지로!
        } else{
            response.sendRedirect("login.html"); // 틀리다면 다시 로그인 페이지로!
        }

 /*       response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head>");
        out.write("<title>로그인 데이터</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1> userid: " + userid + "</h1><br>");
        out.write("<h1> pw: " + pw + "</h1>");
        out.write("</body>");
        out.write("</html>");*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
