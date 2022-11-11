<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-11
  Time: AM 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo Read</title>
</head>
<body>
<h1>Todo Read</h1>

<table>
    <tr>
        <td>번호</td>
        <td><input type="text" name="tno" value="${todo.tno}" readonly></td>
    </tr>
    <tr>
        <td>할일</td>
        <td><input type="text" name="todo" value="${todo.todo}" readonly></td>
    </tr>
    <tr>
        <td>기한</td>
        <td><input type="date" name="dueDate" value="${todo.dueDate}" readonly></td>
    </tr>
    <tr>
        <td>상태</td>
        <td><input type="checkbox" name="finished" value="${todo.finished ? '완료' : '진행중'}" readonly></td>
    </tr>
</table>
<a href="/todo/modify?tno=${param.tno}">Modify / Remove</a> <a href="/todo/list">Todo List</a>

</body>
</html>
