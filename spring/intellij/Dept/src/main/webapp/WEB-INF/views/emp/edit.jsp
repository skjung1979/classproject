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
    <title>Emp Edit</title>
    <style>
        table {
            width: 300px;
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

<h1>Emp Edit</h1>
<hr>
<br>

<a href="/emp/list">사원 리스트</a>

<br>
<%--empno	int	NO	PRI
ename	varchar(20)	YES
job	varchar(20)	YES
mgr	smallint	YES
hiredate	date	YES
sal	decimal(7,2)	YES
comm	decimal(7,2)	YES
deptno	int	YES	MUL--%>
${empListBy.empno}
${empListBy.ename}

<form method="post">
    <table>
        <tR>
            <th>사원번호</th>
            <tD><input type="number" name="empno" value="${empListBy.empno}" readonly></tD>
        </tR>
        <tR>
            <th>사원명</th>
            <tD><input type="text" name="ename" value="${empListBy.ename}"></tD>
        </tR>
        <tR>
            <th>직책</th>
            <tD>
                <select name="job">
                    <c:forEach var="job" items="${kindOfJob}">
                        <option ${job eq empListBy.job ? 'selected' : ''} value="${empListBy.job}">${job}</option>
                    </c:forEach>
                </select>
            </tD>
        </tR>
        <tR>
            <th>관리자</th>
            <tD>
                <select name="mgr">
                    <c:forEach var="mgr" items="${MgrList}">
                        <option value="${empListBy.mgr}" ${mgr.empno == empListBy.mgr ? 'selected' : ''}>${mgr.ename}</option>
                    </c:forEach>
                </select>
            </tD>
        </tR>
        <tR>
            <th>입사일자</th>
            <tD><input type="date" name="hiredate" value="${empListBy.hiredate}"></tD>
        </tR>
        <tR>
            <th>연봉($)</th>
            <tD><input type="number" name="sal" min="1500" value="${empListBy.sal}"></tD>
        </tR>
        <tR>
            <th>인센($)</th>
            <tD><input type="number" name="comm" min="0" value="${empListBy.comm}"></tD>
        </tR>
        <tR>
            <th>부서</th>
            <tD>
                <select name="deptno">
                    <c:forEach var="dept" items="${deptList}">
                        <option value="${empListBy.deptno}" ${dept.deptno == empListBy.deptno ? 'selected' : ''}>${dept.dname}</option>
                    </c:forEach>
                </select>
            </tD>
        </tR>
        <tR>
            <th></th>
            <tD><input type="submit" value="수정"></tD>
        </tR>
    </table>
</form>

</body>
</html>
