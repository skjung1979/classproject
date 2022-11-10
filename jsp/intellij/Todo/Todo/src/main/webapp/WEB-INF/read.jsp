<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-10
  Time: 오후 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Read</title>
</head>
<h1>Read 페이지</h1>
<h3>제목 : ${param.todo}</h3>
<h3>마감일 : ${param.inDate}</h3>
<h3>설명 : ${param.memo}</h3>

<a href="/TodoModify?todo=${param.todo}&inDate=${param.inDate}&memo=${param.memo}"><button>수정</button></a>
<a href="/TodoRemove"><button>삭제</button></a>

</body>
</html>
