<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %><%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-07
  Time: 오후 3:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
    <h1>로그인 페이지</h1>
        <%

            String userid = request.getParameter("userid");
            String pw = request.getParameter("pw");

            // 테스트를 위해 아이디와 패스워드가 같으면 로그인되는 것으로 설정함
            if (userid.equals(pw)){
                session.setAttribute("loginId", userid);
                response.sendRedirect("mypage.jsp");
            } else {
                response.sendRedirect("login.html");
            }

            LocalDate now = LocalDate.now();
            LocalTime time = LocalTime.now();

        %>

    <%=now%> <%=time%>


</body>
</html>
