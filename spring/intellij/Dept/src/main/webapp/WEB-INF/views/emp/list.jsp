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
    <title>Emp List</title>
    <style>
        table{
            width: 850px;
            padding: 15px;
        }
        tr {
            background-color: #ecebeb;
        }
        #cen {
            text-align: center;
        }
    </style>
</head>
<body>

<h1>Emp List &lt;<A href="/">HOME</A>&gt;</h1>
<hr>
<br>

<a href="/emp/register">직원 등록</a>


<%--empno	int	NO	PRI
ename	varchar(20)	YES
job	varchar(20)	YES
mgr	smallint	YES
hiredate	date	YES
sal	decimal(7,2)	YES
comm	decimal(7,2)	YES
deptno	int	YES	MUL--%>

<table>
<tR>
    <th id="cen">사원번호</th>
    <th id="cen">이름</th>
    <th id="cen">직책</th>
    <th id="cen">관리자번호</th>
    <th id="cen">입사일자</th>
    <th id="cen">연봉($)</th>
    <th id="cen">인센($)</th>
    <th id="cen">부서번호</th>
    <th id="cen">관리</th>
</tR>

    <c:forEach var="emp" items="${empList}">

        <tr>
            <td id="cen">${emp.empno}</td>
            <td>${emp.ename}</td>
            <td>${emp.job}</td>
            <td id="cen">${emp.mgr}</td>
            <td id="cen">${emp.hiredate}</td>
            <td>${emp.sal}</td>
            <td>${emp.comm}</td>
            <td id="cen">${emp.deptno}</td>
            <Td id="cen"><a href="/emp/edit?no=${emp.empno}">수정</a> / <a onclick="deleteEmp(${emp.empno});" style="cursor: pointer">삭제</a></Td>
        </tr>

    </c:forEach>
</table>

<script>
    function deleteEmp(no){
        if (confirm("삭제하시겠습니까?")){
            location.href = '/emp/delete?empno='+no;
        }
    }
</script>


</body>
</html>
