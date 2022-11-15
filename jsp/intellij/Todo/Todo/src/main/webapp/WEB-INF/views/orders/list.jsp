<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-14
  Time: PM 2:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Orders List</title>
</head>
<body>
<h1>Orders List &lt;<a href="/">HOME</a>&gt;</h1>
<hr>
<%--${ordersList}--%>
<form method="post">
    고객별 조회:
    <select name="custid">
        <c:forEach var="cust" items="${custList}">
            <option value="${cust.custId}">${cust.custnm}</option>
        </c:forEach>
        <option value="0" selected>ALL</option>
    </select>
    <input type="submit" value="검색">
</form>
<table border="1">
    <tr>
        <th>순번</th>
        <th>주문번호</th>
        <th>고객ID</th>
        <th>고객이름</th>
        <th>도서코드</th>
        <th>도서명</th>
        <th>정가</th>
        <th>판매가</th>
        <th>판매일자</th>
        <th>합계</th>
    </tr>
    <c:if test="${reSelectList != null}">

        <c:forEach var="order" items="${reSelectList}" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${order.orderid}</td>
                <td>${order.custid}</td>
                <td>${order.custnm}</td>
                <td>${order.bookid}</td>
                <td>${order.booknm}</td>
                <td>${order.price}</td>
                <td>${order.saleprice}</td>
                <td>${order.orderdate}</td>
                <c:if test="${stat.count == 1}">
                    <td rowspan="50">${order.sumprice}</td>
                </c:if>
            </tr>
        </c:forEach>

    </c:if>

    <c:if test="${custList == null}">
        <c:forEach var="order" items="${ordersList}" varStatus="stat">
            <tr>
                <td>${stat.count}</td>
                <td>${order.orderid}</td>
                <td>${order.custid}</td>
                <td>${order.custnm}</td>
                <td>${order.bookid}</td>
                <td>${order.booknm}</td>
                <td>${order.price}</td>
                <td>${order.saleprice}</td>
                <td>${order.orderdate}</td>
                <c:if test="${stat.count == 1}">
                    <td rowspan="50">${order.sumprice}</td>
                </c:if>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
