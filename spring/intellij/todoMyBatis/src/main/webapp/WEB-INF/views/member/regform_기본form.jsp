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
    <title>회원 가입 페이지</title>
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

  </style>
</head>
<body>
<h1>Todo 회원 가입 페이지</h1>
<hr>

<form action="/member/regTodoMember2" method="post" enctype="multipart/form-data">
  <table>
    <tr>
      <td class="table-danger">이름: </td>
      <td class="table-danger">
        <input type="text" placeholder="이름을 입력하세요." name="username" id="username">
      </td>
    </tr>
    <tr>
      <td class="table-danger">ID: </td>
      <td class="table-danger">
        <input type="text" placeholder="아이디를 입력하세요." name="userid" id="userid">

      </td>
    </tr>
    <tr>
      <td class="table-danger">PW: </td>
      <td class="table-danger">
        <input type="password" placeholder="비밀번호를 입력하세요." name="userpw" id="userpw">

      </td>
    </tr>
    <tr>
      <td class="table-danger">전화번호: </td>
      <td class="table-danger"><input type="tel" placeholder="전화번호를 입력하세요." name="userphone" id="userphone"></td>
    </tr>
    <tr>
      <td class="table-danger">이메일: </td>
      <td class="table-danger">
        <input type="email" placeholder="이메일을 입력하세요." name="useremail" id="useremail">

      </td>
    </tr>
    <tr>
      <td class="table-danger">프로필 사진: </td>
      <td class="table-danger"><input type="file" name="userphoto" id="userphoto"></td>
    </tr>
    <tr id="regform">
      <Td class="table-danger"></Td>
      <td class="table-danger"><input type="submit" value="회원가입" ></td>
    </tr>
  </table>

</form>


</body>
</html>
