<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>등록</title>
</head>
<body>
<h1>할일 등록 페이지</h1>

<form method="post">

제목: <input type="text" name="todo" placeholder="할일은?" key="${stat.index}"><br>
마감일: <input type="date" name="inDate" key="${stat.index}"><br>
설명:    <textarea name="memo" key="${stat.index}">자세한 설명</textarea><br>

<input type="reset" value="초기화">
    <button>등록</button>
</form>


</body>
</body>
</html>

