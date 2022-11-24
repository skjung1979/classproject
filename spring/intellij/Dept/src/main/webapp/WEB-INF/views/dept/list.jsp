<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-24
  Time: PM 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Dept List</h1>
<hr>
<br>

<a href="/dept/register">부서등록</a>

<table>
<tR>
    <th>부서번호</th>
    <th>부서이름</th>
    <th>부서위치</th>
    <th>관리</th>
</tR>

    <c:forEach var="dept" items="${deptList}">

        <tr>
            <Td>${dept.deptno}</Td>
            <Td>${dept.dname}</Td>
            <Td>${dept.loc}</Td>
            <Td>수정 / 삭제</Td>
        </tr>

    </c:forEach>



</table>

</body>
</html>
