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

<h1>Dept List &lt;<A href="/">HOME</A>&gt;</h1>
<hr>
<br>

<a href="/dept/register">부서등록</a>
<br>

<div style="margin-top: 10px">
    <form>
        검색:
        <select name="searchType">
            <option value="dname">부서이름</option>
            <option value="loc">부서위치</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
</div>


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
            <Td><a href="/dept/edit?no=${dept.deptno}">수정</a> / <a onclick="deleteDept(${dept.deptno});" style="cursor: pointer">삭제</a></Td>
        </tr>

    </c:forEach>
</table>

<script>
    function deleteDept(no){
        if (confirm("삭제하시겠습니까?")){
            location.href = '/dept/delete?deptno='+no;
        }
    }
</script>


</body>
</html>
