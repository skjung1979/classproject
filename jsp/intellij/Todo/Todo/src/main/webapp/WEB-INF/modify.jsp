<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>수정</title>
</head>
<body>
<h1>수정 페이지</h1>

<form method="post">
  <input type="text" name="todo" value="${param.todo}"><br>
  <input type="date" name="inDate" value="${param.inDate}"><br>
  <textarea name="memo">${param.memo}</textarea><br>
  <button>입력완료</button>
</form>

</body>
</html>
