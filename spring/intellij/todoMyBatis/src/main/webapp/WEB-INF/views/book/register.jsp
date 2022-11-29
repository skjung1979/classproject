<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-16
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>도서 등록 페이지</title>
  <style type="text/css">

    .table-column {
      text-align: center;
      font-size: 14px;
      background-color: #ddffaa;
    }
    .error {
      margin-left: 5px;
      color: red;
      font-size: 12px;
    }
    .msg{
      color: red;
      padding: 15px;
    }

  </style>
</head>
<body>
<h1>도서 등록 페이지</h1>
<hr>
<%--<span class="msg">${msg2}</span>--%>
<%--<form:form action="/member/regTodoMember" method="post" modelAttribute="memberRegRequest" enctype="multipart/form-data">--%>
<form method="post">
  <table>
    <tr>
      <td class="table-danger">도서코드: </td>
      <td class="table-danger">
        <input type="text" name="bookid" id="bookid">
<%--        <form:errors path="username" cssClass="error" />--%>
      </td>
    </tr>
    <tr>
      <td class="table-danger">도서명: </td>
      <td class="table-danger">
        <input type="text" name="bookname" id="bookname">
<%--        <form:errors path="userid" cssClass="error" />--%>
      </td>
    </tr>
    <tr>
      <td class="table-danger">출판사명: </td>
      <td class="table-danger">
        <input type="text" name="publisher" id="publisher">
<%--        <form:errors path="userpw" cssClass="error" />--%>
      </td>
    </tr>
    <tr>
      <td class="table-danger">정가: </td>
      <td class="table-danger"><input type="number" min="0" name="price" id="price"></td>
    </tr>
<%--    <tr>--%>
<%--      <td class="table-danger">이메일: </td>--%>
<%--      <td class="table-danger">--%>
<%--        <input type="email" placeholder="이메일을 입력하세요." name="useremail" id="useremail" value="${regmem.useremail}">--%>
<%--&lt;%&ndash;        <form:errors path="useremail" cssClass="error" />&ndash;%&gt;--%>
<%--      </td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--      <td class="table-danger">프로필 사진: </td>--%>
<%--      <td class="table-danger"><input type="file" name="userphoto" id="userphoto"></td>--%>
<%--    </tr>--%>
    <tr id="regform">
      <Td class="table-danger"></Td>
      <td class="table-danger"><input type="submit" value="도서등록" ></td>
    </tr>
  </table>
</form>
<%--</form:form>--%>


</body>
</html>
