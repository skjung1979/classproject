<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forTokens items="손흥민,010-0000-1111,런던" delims="," var="str" varStatus="stat">
    <c:if test="${stat.index == 1}">
        ${str}<br>
    </c:if>
</c:forTokens>



<hr>

<table border="1">
    <tr>
        <th>index</th>
        <th>count</th>
        <th>아이디</th>
        <th>이름</th>
        <th>비밀번호</th>
    </tr>
    <c:forEach var="member" items="${members}" varStatus="stat">
        <tr>
            <td>${stat.index}</td>
            <td>${stat.count}</td>
            <td>${member.id}</td>
            <td>${member.name}</td>
            <td>${member.pw}</td>
        </tr>
    </c:forEach>
</table>


<c:forEach var="member" items="${members}">
    <h3>${member}</h3>
</c:forEach>



<h2>1~5까지 반복 출력</h2>
<c:forEach var="num" begin="1" end="5"> <%--end는 페이지의 개수--%>
    <h3>${num}</h3>
</c:forEach>


</body>
</html>














