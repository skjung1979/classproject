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
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>

<table>
    <tr>
        <th>번호</th>
        <th>할일</th>
        <th>마감일</th>
        <th>완료여부</th>
    </tr>
    <c:forEach var="todo" items="${todoList}">
        <tr>
            <td>${todo.tno}</td>
            <td><a href="/todo/read?tno=${todo.tno}">${todo.todo}</a></td>
            <td>${todo.dueDate}</td>
            <td>${todo.finished ? '완료' : '진행중'}</td>
        </tr>
    </c:forEach>
</table>

<a href="/todo/register">Todo 등록하기</a>

</body>
</html>
