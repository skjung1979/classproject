<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-12-01
  Time: AM 1:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            $("#checkJson").click(function() {
                var board = {
                    bno: "2",
                    title: "안녕하세요.2222",
                    content: "자유로운 게시글을 올리는 곳입니다.",
                    writer: "손흥민2",
                    regdate: "2022-12-01",
                    updatedate: "2022-12-01"
                };
                $.ajax({
                    // 아래 타입과 url 및 데이터를 바꿔가며 테스트 진행
                    type: "POST",
                    url: "${contextPath}/boards",
                    <%--//type: "PUT",--%>
                    <%--//url: "${contextPath}/boards/1",--%>
                    contentType: "application/json",
                    data: JSON.stringify(board),
                    success: function (data, textStatus){
                        alert(data);
                    },
                    error: function (data, textStatus){
                        alert("에러가 발생했습니다.");
                    },
                    complete: function (data,textStatus){
                    }
                }); /*end ajax*/
            });
        });
    </script>

</head>
<body>
<input type="button" id="checkJson" value="테스트"><br><Br>
<div id="output"></div>
<a href="/boards/register">게시글 등록</a>
<br>
<a href="/boards/list">전체 게시글</a>
<br>
<a href="/members/register">회원 가입</a>
<br>
<a href="/logins/login">로그인</a>
<br>
<a href="/members/mypage">마이페이지</a>
<br>
<a href="/logins/logout">로그아웃</a>
</body>
</html>
