<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>1~5까지 반복 출력</h2>
<c:forEach var="num" begin="1" end="5"> <%--end는 페이지의 개수--%>
    <h3>${num}</h3>
</c:forEach>


</body>
</html>














