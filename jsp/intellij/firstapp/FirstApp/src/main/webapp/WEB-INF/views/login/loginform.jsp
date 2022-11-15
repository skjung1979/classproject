<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: AM 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <td><input type="text" name="userid" value="${cookie.reId.value}"></td>
    </tr>
    <tr>
      <td>PW</td>
      <td><input type="password" name="pw"></td>
    </tr>
    <tr>
      <td></td>
      <td>아이디 저장하기 <input type="checkbox" name="idremember" ${cookie.reId.value ne vull ? 'checked' : ''}></td>
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

<c:if test="${param.error eq 'e'}">
  <script>
    alert('오류발생');
  </script>
</c:if>

<c:if test="${param.error eq 'nf'}">
  <script>
    alert('아이디 또는 비밀번호가 틀립니다.');
  </script>
</c:if>

</body>
</html>
