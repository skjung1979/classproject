package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get.Parameter()호출하기 전에 이것을 해줘야 POST방식으로 한글 입력 전달 받아도 깨지지 않는다.
        request.setCharacterEncoding("utf-8");

        String id = request.getParameter("userid");
        String pw = request.getParameter("userpw");
        String name = request.getParameter("username");
        String memo = request.getParameter("memo");
        String gender = request.getParameter("gender");
        //String lang = request.getParameter("lang"); // 넘겨 받는 data가 여러개 인 경우배열로 가져와야 한다.
        String[] langs = request.getParameterValues("lang");
        String year = request.getParameter("year");

        // charset=UTF-8을 추가해줘야 아래 .write()메소드로 표현한 한글이 깨지지 않는다.
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head>");
        out.write("<title>signup</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h2>your ID : " + id + "</h2>");
        out.write("<h2>your PW : " + pw + "</h2>");
        out.write("<h2>your NAME : " + name + "</h2>");
        out.write("<h2>your MEMO : " + memo + "</h2>");
        out.write("<h2>your GENDER : " + gender + "</h2>");
        out.write("<h2>your Language : </h2>");
        if (langs != null) {
            for (String lang : langs) {
                out.write("<h2>" + lang + "</h2>");
            }
        }
        out.write("<h2>your YEAR : " + year + "</h2>");
        out.write("</body>");
        out.write("</html>");

    }
}
