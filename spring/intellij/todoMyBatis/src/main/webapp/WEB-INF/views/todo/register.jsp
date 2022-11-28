<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Todo Register</title>

    <style type="text/css">

        .table-column {
            text-align: center;
            font-size: 14px;
            background-color: #ddffaa;
        }
        .error {
            margin-left: 5px;
            color: red;
            font-size: 12px;
        }

    </style>
</head>
<body>
<h1>Todo Register</h1>
<hr>

<form:form action="/todo/TodoRegister" method="post" modelAttribute="todoDTO">
    <table border="1" width="500" cellpadding="5" cellspacing="0">
        <Tr>
            <Td class="table-danger">할일:</Td>
            <td class="table-danger">
                <input type="text" name="todo" value="${todo.todo}"/>
                <form:errors path="todo" cssClass="error" />
            </td>
        </Tr>
        <Tr>
            <Td class="table-danger">설명:</Td>
            <td class="table-danger">
                <textarea name="memo" placeholder="자세한 설명을 입력하세요." value="${todo.memo}"></textarea>
            </td>
        </Tr>
        <Tr>
            <Td class="table-danger">마감일:</Td>
            <td class="table-danger">
                <input type="date" name="dueDates" value="${todo.dueDates}"/>
                <form:errors path="dueDates" cssClass="error" />
            </td>
        </Tr>
        <tr>
            <td class="table-danger"></td>
            <td class="table-danger"><input type="reset" value="초기화">
                <input type="submit" value="등록"> <a href="/todo/TodoList">TodoList</a></td>
        </tr>
    </table>

</form:form>



</body>

</html>
