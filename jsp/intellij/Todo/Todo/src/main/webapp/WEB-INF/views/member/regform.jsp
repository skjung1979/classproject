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
    <title>회원 가입 페이지</title>
</head>
<body>
<h1>회원 가입 페이지</h1>
<hr>
<form>

  <table>
    <tr>
      <td>이름: </td>
      <td><input type="text" placeholder="이름을 입력하세요." name="username" id="username"></td>
    </tr>
    <tr>
      <td>ID: </td>
      <td><input type="text" placeholder="아이디를 입력하세요." name="userid" id="userid"></td>
    </tr>
    <tr>
      <td>PW: </td>
      <td><input type="password" placeholder="비밀번호를 입력하세요." name="userpw" id="userpw"></td>
    </tr>
    <tr>
      <td>전화번호: </td>
      <td><input type="tel" placeholder="전화번호를 입력하세요." name="userphone" id="userphone"></td>
    </tr>
    <tr>
      <td>이메일: </td>
      <td><input type="email" placeholder="이메일을 입력하세요." name="useremail" id="useremail"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="checkbox" name="idremember" id="idremember"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="email" name="keeplogin" id="keeplogin"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="email"  name="useremail" id="useremail"></td>
    </tr>
  </table>

</form>

</body>
</html>
