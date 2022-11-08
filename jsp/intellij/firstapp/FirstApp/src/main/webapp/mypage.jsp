<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-08
  Time: 오후 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
</head>
<body>

<%
    String loginId = (String) session.getAttribute("loginId");

    if (loginId == null){
        response.sendRedirect("login.html");
    }

%>

<h1>로그인 후 보여지는 페이지: 아이디=> <%= loginId %></h1>
<a href="logout.jsp">로그아웃</a>


</body>
</html>
