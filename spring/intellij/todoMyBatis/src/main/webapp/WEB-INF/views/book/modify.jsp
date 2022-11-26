<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-14
  Time: AM 6:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>도서정보 수정</title>
</head>
<body>
<h1>도서 정보 수정</h1>
<hr>


<form method="post">
<table>
    <tr>
        <th>도서코드</th>
        <td><input type="text" name="bookid" value="${book.bookid}" readonly></td>
    </tr>
    <tr>
        <th>도서명</th>
        <td><input type="text" name="bookname" value="${book.bookname}"></td>
    </tr>
    <tr>
        <th>출판사</th>
        <td><input type="text" name="publisher" value="${book.publisher}"></td>
    </tr>
    <tr>
        <th>정가</th>
        <td><input type="text" name="price" value="${book.price}"></td>
    </tr>
</table>
    <input type="submit" value="도서변경">
</form>
</body>
</html>
