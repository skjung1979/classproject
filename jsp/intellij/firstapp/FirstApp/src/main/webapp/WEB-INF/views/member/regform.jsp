<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-15
  Time: PM 3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 가입 폼</title>
</head>
<body>
<h1>회원 가입</h1>
<hr>

<%--idx	int	NO	PRI		auto_increment
uid	varchar(45)	NO	UNI
pw	varchar(45)	NO
uuid	varchar(45)	YES--%>

<form method="post">

    <table>
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" id="uid"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="pw" id="pw"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="회원가입"></td>
        </tr>

    </table>
</form>

</body>
</html>
