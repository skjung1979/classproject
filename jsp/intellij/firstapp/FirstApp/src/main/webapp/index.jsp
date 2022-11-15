<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a><br>
<a href="my">My Servlet</a>
<hr>
<c:if test="${loginInfo eq null}">
    <a href="login">로그인</a>
</c:if>
<br><br>
회원 정보: ${loginInfo}
<br><br>
<c:if test="${loginInfo ne null}">
    <a href="/app/mypage/mypage">마이페이지</a>
    <br>
    <a href="/app/logout">로그아웃</a>
</c:if>
</body>
</html>