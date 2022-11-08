package com.firstcoding.firstapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SampleServlet", value = "/sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(">>>>>>>>> doGet() 실행");
        
        response.setContentType("text/html");
                
        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<head>");
        print.println("</head>");
        print.println("<body>");
        print.println("<h1>doGet() 실행 execute</h1>");
        print.println("</body>");
        print.println("</html>");
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(">>>>>>>>> doPost() 실행");

        response.setContentType("text/html");

        PrintWriter print = response.getWriter();
        print.println("<html>");
        print.println("<head>");
        print.println("</head>");
        print.println("<body>");
        print.println("<h1>doPost() 실행</h1>");
        print.println("</body>");
        print.println("</html>");

    }

    @Override
    public void destroy() {

        System.out.println(">>>>>>>>> destroy() 실행");


    }

    @Override
    public void init() throws ServletException {
        System.out.println(">>>>>>>>> init() 실행");


    }
}

