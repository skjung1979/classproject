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
    <title>Todo Modify</title>
</head>
<body>
<h1>Todo Modify</h1>
<form method="post">
<table>
    <tr>
        <td>번호</td>
<%--        임시로 param으로 수정함--%>
        <td><input type="text" name="tno" value="${param.tno}" readonly></td>
    </tr>
    <tr>
        <td>할일</td>
        <td><input type="text" name="todo" value="${todo.todo}"></td>
    </tr>
    <tr>
        <td>기한</td>
        <td><input type="date" name="dueDate" value="${todo.dueDate}"></td>
    </tr>
    <tr>
        <td>상태</td>
        <td><input type="checkbox" name="finished" value="${todo.finished ? '완료' : '진행중'}"></td>
    </tr>
    <tr>
        <td></td>
<%--        초기화 버튼은 수정하기 전 데이타로 돌린다.--%>
        <td><input type="reset"> <input type="submit" value="modify"></td>
    </tr>
</table>
</form>


<a href="/todo/list">Todo List</a>

</body>
</html>
