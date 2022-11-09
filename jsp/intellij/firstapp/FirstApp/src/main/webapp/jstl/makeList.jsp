<%@ page import="com.firstcoding.firstapp.member.Member" %>
<%@ page import="java.sql.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-09
  Time: 오후 2:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%

  // 객체를 생성해서 세션 속성에 세팅을 했다.
  List<Member> members = new ArrayList<>();
  members.add(new Member("cool0", "1110", "COOL0"));
  members.add(new Member("cool1", "1111", null));
  members.add(new Member("cool2", "1112", "COOL2"));
  members.add(new Member("cool3", "1113", null));
  members.add(new Member("cool4", "1114", "COOL4"));
  members.add(new Member("cool5", "1115", null));
  members.add(new Member("cool6", "1116", "COOL6"));
  members.add(new Member("cool7", "1117", null));
  members.add(new Member("cool8", "1118", "COOL8"));
  members.add(new Member("cool9", "1119", "COOL8"));

  session.setAttribute("members", members);

%>

</body>
</html>
