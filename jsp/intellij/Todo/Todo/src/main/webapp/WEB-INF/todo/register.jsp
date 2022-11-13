<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Todo Register</title>
</head>
<body>
<h1>Todo Register</h1>

<form method="post">

  <table>
    <Tr>
    <Td>할일: </Td>
      <Td><input type="text" name="todo"></Td>
    </Tr>
    <Tr>
      <Td>설명: </Td>
      <Td><textarea name="memo">필요하다면 자세한 설명을 입력해주세요.</textarea></Td>
    </Tr>
    <Tr>
      <Td>마감일:</Td>
      <Td><input type="date" name="dueDate"></Td>
    </Tr>
    <tr>
      <td></td>
      <td><input type="reset" value="초기화">
        <input type="submit" value="등록"></td>
    </tr>
  </table>

</form>


</body>
</body>
</html>
