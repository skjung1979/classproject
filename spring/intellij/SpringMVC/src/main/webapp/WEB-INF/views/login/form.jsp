<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-17
  Time: PM 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 폼</title>
</head>
<body>
<h1>로그인 폼</h1>
<hr>
<p>${msg}</p>

<form method="post">
  <table>
    <Tr>
      <td>아이디</td>
      <td><input TYPE="text" name="uid" id="uid"> </td>
    </Tr>
    <Tr>
      <td>패스워드</td>
      <td><input TYPE="password" name="pw" id="pw"> </td>
    </Tr>
    <Tr>
      <td></td>
      <td><input TYPE="submit" value="전송"> </td>
    </Tr>

  </table>
</form>
</body>
</html>
