<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-08
  Time: 오후 3:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>페이지 카운트</title>
</head>
<body>

<%
    // application의 cnt(오브젝트 타입)를 속성을 가져와서 cntStr 변수에 형변환 후 담는다.
    String cntStr = (String)application.getAttribute("cnt");
    int cnt = cntStr == null ? 0 : Integer.parseInt(cntStr);

    out.print("페이지 방문 수: " + cnt);

//    application.setAttribute("cnt", String.valueOf(++cnt));

%>


</body>
</html>
