<%--
Created by IntelliJ IDEA.
User: skjung_gram
Date: 2022-11-10
Time: 오후 9:27
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
    <style>
        table {
            text-align: center;
            width: 500px;
        }

        td {
            padding: 5px;
        }


    </style>
</head>
<body>
<h1>${title}</h1> <%--리스트 서블릿에서 불어왔음--%>
<hr>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>마감일자</th>
        <th>완료여부</th>
    </tr>

    <c:forEach var="todo" items="${list}"> <%--리스트 서블릿에서 불러옴 <- 먼저 service에서 처리한 내용을 리스트 서블릿에서 setAttribute --%>
        <tr>
                <%--            제목을 클릭했을 때 상세페이지(read)페이지에 들어가도록 구현함--%>
            <td>${todo.tno}</td>
            <td>${todo.todo}</a></td>
            <td>${todo.dueDate}</td>
            <td>${todo.finished ? '완료' : '진행중'}</td>
            <td><a href="/todo/TodoRead?tno=${todo.tno}"><button>보기</button></td>
        </tr>
    </c:forEach>

</table>
<a href="/todo/TodoRegister"><button>등록</button></a>
</body>
</html>
