<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-21
  Time: PM 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    게시물 검색
    <select>
        <c:forEach items="${searchType}" var="type">
            <option>${type}</option>
        </c:forEach>
    </select>
  <input type="text">
  <input type="submit" value="검색">
</div>
List 출력

</body>
</html>
