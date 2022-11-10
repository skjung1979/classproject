<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-09
  Time: 오후 2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("now", new Date());
%>

${now}

<hr>

<fmt:formatDate value="${now}"/> <br>
<fmt:formatDate value="${now}" type="date" dateStyle="full"/><br>
<fmt:formatDate value="${now}" type="date" dateStyle="short"/>

<h3>시간</h3>

<fmt:formatDate value="${now}" type="time"/> <br>
<fmt:formatDate value="${now}" type="time" timeStyle="full"/> <br>
<fmt:formatDate value="${now}" type="time" timeStyle="short"/>

<h3>날짜/시간 같이</h3>

<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/>

<h3>원하는 패턴으로</h3>

<fmt:formatDate value="${now}" pattern="yyyy-MM-dd hh:mm"/> <br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm"/> <br>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a h:mm"/> <br>
<fmt:formatDate value="${now}" pattern="yyyy.MM.dd. HH:mm:ss"/> <br>

</body>
</html>














