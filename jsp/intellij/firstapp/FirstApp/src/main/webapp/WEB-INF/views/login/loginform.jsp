<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: AM 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>로그인</h1>
<hr>
<form method="post">
  <table>
    <tr>
      <td>ID</td>
      <td><input type="text" name="userid"></td>
    </tr>
    <tr>
      <td>PW</td>
      <td><input type="password" name="pw"></td>
    </tr>
    <tr>
      <td></td>
      <td>아이디 저장하기 <input type="checkbox" name="idremember"></td>
    </tr>
    <tr>
      <td></td>
      <td>remember_me<input type="checkbox" name="rememberme"></td>
    </tr>
    <tr>
      <td></td>
      <td><input type="submit" value="로그인"></td>
    </tr>

  </table>
</form>

</body>
</html>
