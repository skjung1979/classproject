
<%@ page import="com.firstcoding.firstapp.product.Product" %>
<%@ page import="com.firstcoding.firstapp.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-09
  Time: 오후 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

  // scope을 생략하면 request > session > application 순서로 찾는다.

  request.setAttribute("name", "손흥민");
  session.setAttribute("name", "이강인");

  Member member = new Member();
  member.setId("cool");
  member.setPw("1234");
  member.setName("COOL");

  // 위에서 Member객체를 생성해서 넣은 것!
  session.setAttribute("member", member);

  // 아래에서 바로 Product객체를 생성 한 것!
  session.setAttribute("product", new Product());

%>

<html>
<head>
  <title>Title</title>
</head>
<body>

<h4>표현식: <%= request.getAttribute("name") %></h4>
<h4>표현언어: ${requestScope.name}</h4>

<h4>표현식: <%= request.getAttribute("id") %></h4>
<h4>표현언어: ${requestScope.id}</h4>

<h4> param (code): ${param.code}</h4>

<h4>pageContext(URL): ${pageContext.request.requestURL}</h4>
<h4>pageContext(URI): ${pageContext.request.requestURI}</h4>
<%-- 경로를 만들때 contextPath를 붙여서 만들어야 한다. 클라이언트의 경로가 다르므로--%>
<h4>pageContext(contextPath): ${pageContext.request.contextPath}</h4>

<h4>sessionScope (name): ${sessionScope.name}</h4>
<%--// scope을 생략하면 request > session > application 순서로 찾는다.--%>
<h4>(name): ${name}</h4>

<hr>

${true} / ${false} / ${100} / ${1.2} / ${'손흥민'} / ${null}

<hr>

<h4>${sessionScope.member}</h4>
<h4>${member} / ${member.id} / ${member.pw} / ${member.name}</h4>

<hr>

<h4>첫번째 상품: ${product.list[0]}, 가격 ${product.price}</h4>

</body>
</html>






