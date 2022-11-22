<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-22
  Time: AM 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>

<h1>회원가입</h1>
<hr>
<form method="post">

    <table>
        <tr>
            <Td>아이디</Td>
            <Td><input type="text" name="uid"></Td>
        </tr>
        <tr>
            <Td>비밀번호</Td>
            <Td><input type="password" name="pw"></Td>
        </tr>
        <tr>
            <Td>이름</Td>
            <Td><input type="text" name="uname"></Td>
        </tr>
        <tr>
            <Td>사진</Td>
            <Td><input type="file" name="uphoto"></Td>
        </tr>
        <tr>
            <Td></Td>
            <Td><input type="submit" value="회원가입"></Td>
        </tr>
    </table>
</form>


</body>
</html>
