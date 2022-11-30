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

<c:set var="contextPath" value="${pageContext.request.contextPath}"

<html>
<head>
    <title>Title</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        $(function () {
            $("#checkJson").click(function() {
                var board = {bno: "1",
                    title: "안녕하세요.",
                    content: "자유로운 게시글을 올리는 곳입니다.",
                    write: "손흥민"
                };
                $.ajax({
                    // 아래 타입과 url 및 데이터를 바꿔가며 테스트 진행
                    type: "POST",
                    url: "${contextPath}/boards",
                    type: "PUT",
                    url: "${contextPath}/boards/1",
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
</body>
</html>
