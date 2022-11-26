<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-13
  Time: PM 7:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>부서리스트</title>
</head>
<body>
<h1>부서리스트 &lt;<a href="/">HOME</a>&gt;</h1>
<hr>
<table>
  <tr>
    <th>부서번호</th>
    <th>부서명</th>
    <th>부서위치</th>
  </tr>
  <c:forEach var="dept" items="${list}">
  <tr>
    <td>${dept.deptno}</td>
    <td>${dept.dname}</td>
    <td>${dept.loc}</td>
  </tr>
  </c:forEach>
</table>
</body>
</html>
