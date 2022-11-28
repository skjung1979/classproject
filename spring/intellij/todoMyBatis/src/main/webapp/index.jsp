<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Todo - MyBatis</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br>
<A href="/todo/TodoList">todo list</A>
<br>
<A href="/dept/list">dept list</A>
<br>
<A href="/book/list">book list & order</A>
<br>
<A href="/orders/list">orders list</A>
<br>
<c:if test="${existUUID == null && loginInfo == null}">
    <A href="/member/regTodoMember">register for todo member</A>
    <br>
    <A href="/login/loginTodoMember">login for todo member</A>
</c:if>
<c:if test="${existUUID != null || loginInfo != null}">
    <A href="/mypage">mypage</A>
    <br>
    <A href="/login/logoutTodoMember">logout</A>
</c:if>
${loginInfo}
</body>
</html>
