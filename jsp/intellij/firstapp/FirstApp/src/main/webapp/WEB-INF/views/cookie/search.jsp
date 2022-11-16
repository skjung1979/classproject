<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: AM 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 값 검색</title>
</head>
<body>

검색 쿠키 이름: ${param.cname}
<br>
쿠키 검색 결과: ${result}
<br>
<a href="/app/cookie/create">쿠키 생성</a> <%--절대경로--%>
<br>

</body>
</html>
