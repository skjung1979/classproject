<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-08
  Time: 오후 2:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>페이지 모듈화</title>
  <style>
    header, nav {
      text-align: center;
      font-weight: bold;
    }

    table {
      width: 100%;
    }



  </style>

</head>
<body>

<%@ include file="top.jsp" %>
<%@ include file="nav.jsp" %>

<table>
  <tr>
    <td><%@ include file="news.jsp" %></td>
    <td><%@ include file="shopping.jsp" %></td>
  </tr>
</table>




</body>
</html>
