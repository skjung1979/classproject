<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <style>
        table {
            text-align: center;
            width: 400px;
        }

    </style>
</head>
<body>

<h1>Todo List</h1>

<table>
    <tr>
        <th>제목</th>
        <th>마감일자</th>
        <th>설명</th>
    </tr>
    <tr>
        <td>${todo}</td>
        <td>${inDate}</td>
        <td><a href="/TodoRead?todo=${todo}&inDate=${inDate}&memo=${memo}"><button>보기</button></a></td>
    </tr>

</table>

<a href="/TodoRegister"><button>등록</button></a>

</body>
</html>
