<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-13
  Time: PM 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
  <style>
    table {
      text-align: center;
      width: 500px;
    }
    th {
      border-top: 1px;
      border-bottom: 1px;
    }
    td {
      padding: 5px;
    }


  </style>
</head>
<body>
<h1>Book List &lt;<a href="/">HOME</a>&gt;</h1>
<hr>
<table>
  <tr>
    <th>도서코드</th>
    <th>도서명</th>
    <th>출판사명</th>
    <th>가격</th>
    <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
  </tr>
<c:forEach var="book" items="${list}">
  <tr>
    <td>${book.bookid}</td>
    <td><a href="/book/modify?bookid=${book.bookid}">${book.bookname}</a></td>
    <td>${book.publisher}</td>
    <td>${book.price}</td>
   <td>
      <form method="post" style="display: inline">
        구매자:
      <select style="display: inline" name="custId">
        <c:forEach var="cust" items="${custList}">
        <option value="${cust.custid}">${cust.name}</option>
        </c:forEach>
      </select>
      <input type="hidden" name="bookid" value="${book.bookid}">
      <input type="hidden" name="price" value="${book.price}">
          <input type="submit" value="구매하기">
      </form>
    </td>
  </tr>
</c:forEach>

</table>
</body>
</html>
