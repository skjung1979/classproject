<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Todo Modify</title>
</head>
<body>
<h1>Todo Modify</h1>
<hr>
<form:form action="/todo/TodoModify" method="post" modelAttribute="todoDTO" style="display:inline;">
    번호: <input type="text" name="tno" value="${todo.tno}" readonly><br>
    할일: <input type="text" name="todo" value="${todo.todo}"> <form:errors path="todo" cssClass="error"/><br>
    설명: <textarea name="memo">${todo.memo}</textarea><br>
    마감일: <input type="date" name="dueDates" value="${todo.dueDates}">
    <form:errors path="dueDates" cssClass="error"/><br>
    완료여부: <input type="checkbox" <%--value="${todo.finished ? '0' : '1'}"--%> ${todo.finished ? 'checked' : ''}
                 name="finished"> <%--수정화면에서 check를 안하면 finished는 null표현됨--%>
    <br><br>
    <input type="reset">
    <input type="submit" value="수정">
</form:form>

<%--삭제 버튼은 따로 Form으로 묶는다.--%>
<form action="/todo/TodoRemove" method="post" style="display:inline;">
    <input type="hidden" name="tno" value="${todo.tno}">
    <input type="submit" value="삭제">
</form>
<a href="/todo/TodoList">Todo List</a>
</body>
</html>
