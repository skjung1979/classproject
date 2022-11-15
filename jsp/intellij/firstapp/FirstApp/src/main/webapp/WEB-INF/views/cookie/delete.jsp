<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: AM 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>쿠키 값 삭제</title>
</head>
<body>

userid: ${cookie.userid.value}
<br>
uuid: ${cookie.uuid.value}
<br>

<a href="view">쿠키 확인</a> <%--상대경로--%>

</body>
</html>
