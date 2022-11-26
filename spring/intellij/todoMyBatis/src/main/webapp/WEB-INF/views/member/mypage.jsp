<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-22
  Time: PM 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo Mypage</title>
</head>
<body>
<h1>Todo Mypage</h1>
<hr>
<table>
  <tr>
    <td>이름</td>
    <td>${loginInfo.membernm}</td>
  </tr>
  <tr>
    <td>회원코드</td>
    <td>${loginInfo.seq}</td>
  </tr>
  <tr>
    <td>아이디</td>
    <td>${loginInfo.memberid}</td>
  </tr>
  <tr>
    <td>이메일</td>
    <td>${loginInfo.memberemail}</td>
  </tr>
  <tr>
    <td>사진</td>
    <td><img src="/uploadfile/member/${loginInfo.uphoto}"></td>
  </tr>
</table>
<a href="/">going to Main Page</a>

</body>
</html>
