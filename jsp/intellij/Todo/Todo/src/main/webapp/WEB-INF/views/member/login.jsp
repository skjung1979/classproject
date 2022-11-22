<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-16
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Todo 회원 로그인 페이지</title>
  <style>
    table {
      padding: 5px;
    }
    td{
      padding: 5px;
    }
  </style>
</head>
<body>
<h1>Todo 회원 로그인 페이지</h1>
<hr>
<form method="post">

  <table>
    <tr>
      <td>ID: </td>
      <td><input type="text" placeholder="아이디를 입력하세요." name="userid" id="userid" value="${cookie.reId.value}"></td>
    </tr>
    <tr>
      <td>PW: </td>
      <td><input type="password" placeholder="비밀번호를 입력하세요." name="userpw" id="userpw"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="checkbox" name="idrememeber" id="idremember" ${cookie.reId.value ne null ? 'checked' : ''}> 아이디 저장</td>
    </tr>
    <tr>
      <td></td>
      <td><input type="checkbox" name="keeplogin" id="keeplogin"> 로그인 유지</td>
    </tr>
    <tr id="loginTdo">
      <Td></Td>
      <td><input type="submit" value="로그인" ></td>
    </tr>
  </table>

</form>

<c:if test="${param.error eq 'e'}">
  <script>
    alert('오류발생!!');
  </script>
</c:if>

<c:if test="${param.error eq 'nf'}">
  <script>
    alert('아이디 또는 비밀번호가 틀립니다.');
  </script>
</c:if>

</body>
</html>
