<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-13
  Time: PM 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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


<div>
    <form>
        <select name="searchType">
            <option value="bookname">도서명</option>
            <option value="publisher">출판사명</option>
            <option value="price">가격(이하)</option>
        </select>
        <input type="text" name="keyword">
        <input type="submit" value="검색">
    </form>
</div>

<table>
    <tr>
        <th>선택</th>
        <th>도서코드</th>
        <th>도서명</th>
        <th>출판사명</th>
        <th>가격</th>
     <%--   <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>--%>
    </tr>

    <form method="post" name="form">
    <c:forEach var="book" items="${list}">

        <tr>
            <td><input type="checkbox" name="chbk" value="${book.bookid}"></td>
            <td>${book.bookid}</td>
            <td><a href="/book/modify?bookid=${book.bookid}">${book.bookname}</a></td>
            <td>${book.publisher}</td>
            <td>${book.price}</td>
 <%--           <td>
&lt;%&ndash;                <form method="post" style="display: inline">&ndash;%&gt;
                    구매자:
                    <select style="display: inline" name="custid">
                        <c:forEach var="cust" items="${custList}">
                            <option value="${cust.custid}">${cust.name}</option>
                        </c:forEach>
                    </select>
                    <input type="hidden" name="bookid" value="${book.bookid}">
                    <input type="hidden" name="price" value="${book.price}">
                    <input type="submit" value="구매하기">
&lt;%&ndash;                </form>&ndash;%&gt;
            </td>--%>
        </tr>

    </c:forEach>
        <input type="submit" value="선택 삭제" onclick="javascript: form.action='/book/deleteCheckedBook';">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        구매자: <select style="display: inline" name="custid">
            <c:forEach var="cust" items="${custList}">
                <option value="${cust.custid}">${cust.name}</option>
            </c:forEach>
        </select>&nbsp;
        <input type="hidden" name="bookid" value="${book.bookid}">
        <input type="hidden" name="price" value="${book.price}">
        <input type="submit" value="구매하기" onclick="javascript: form.action='/book/list';">
    </form>
</table>
<a href="/book/register"><button>도서 등록</button></a>
</body>
</html>
