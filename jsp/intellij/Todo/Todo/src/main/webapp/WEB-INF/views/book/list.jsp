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
<h1>Book List</h1>
<hr>
<table>
  <tr>
    <th>도서코드</th>
    <th>도서명</th>
    <th>출판사명</th>
    <th>가격</th>
  </tr>
<c:forEach var="book" items="${list}">
  <tr>
    <td>${book.bookId}</td>
    <td><a href="/book/modify?bookId=${book.bookId}">${book.bookName}</a></td>
    <td>${book.publisher}</td>
    <td>${book.price}</td>
  </tr>
</c:forEach>

</table>
</body>
</html>
