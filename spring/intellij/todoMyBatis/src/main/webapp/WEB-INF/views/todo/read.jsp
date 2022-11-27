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
  <title>Todo Read</title>
</head>
<h1>Todo Read</h1>
<hr>
<h3>번호 : <input type="text" name="tno" readonly value="${todo.tno}"></h3>
<h3>제목 : <input type="text" name="todo" readonly value="${todo.todo}"></h3>
<h3>설명 : <textarea name="memo" readonly>${todo.memo}</textarea></h3>
<h3>마감일 : <input type="date" name="dueDates" readonly value="${todo.dueDates}"></h3>
<h3>완료여부 : <input type="checkbox" name="finished" readonly ${todo.finished ? 'checked' : ''}"></h3>

<a href="/todo/TodoModify?tno=${todo.tno}"><button>수정</button></a> <%--임시로 param.tno를 넣었음
--%>
<form action="/todo/TodoRemove" method="post" style="display: inline">
<input type="hidden" name="tno" value="${todo.tno}">
<button>삭제</button></a>
</form>
<a href="/todo/TodoList"><button>전체목록</button></a>

</body>
</html>
