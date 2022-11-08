<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-08
  Time: 오후 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  session.invalidate(); // 세션을 종료 시킴
  response.sendRedirect("login.html"); // 처음 페이지로 보냄!
%>
