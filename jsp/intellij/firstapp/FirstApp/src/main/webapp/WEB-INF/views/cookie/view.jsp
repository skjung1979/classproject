<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: AM 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 값 확인</title>
</head>
<body>
<h1>쿠키 값 확인</h1>

userid: ${cookie.userid.value}
<br>
uuid: ${cookie.uuid.value}
<br>
<a href="/app/cookie/create">쿠키 생성</a> <%--절대경로--%>
<br>
<a href="search?cname=">쿠키 검색</a> <%--상대경로--%>
<br>
<a href="delete">userid 쿠키값을 삭제</a> <%--상대경로--%>

</body>
</html>
