<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <%-- 반응형 웹에 사용하는 메타 태그--%>
    <link rel="stylesheet" href="css/bootstrap.css">
    <meta name="viewport" content="width-device-width", initial-scale="1">
    <title>JSP 게시판 웹사이트</title>
    <style>
        #navbar > li {
            width: 790px;
            list-style: none;
            background-color: red;
        }


    </style>
</head>
<body>
<%--네비게이션 구성 하나의 웹사이트의 전반적이 구성--%>
<nav>
    <div >
        <%--    brand는 로고 같은 것을 의미한다.--%>
        <a  href="main.jsp">JSP 게시판 웹사이트</a>
    </div>
    <div>
        <ul id="navbar">
            <li><a href="main.jsp">메인</a></li>
            <li><a href="bbs.jsp">게시판</a></li>
            <li ><a href="#" >접속하기</a></li>
            <li><a href="login.jsp">로그인</a></li>
            <li><a href="join.jsp">회원가입</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <form method="post" action="loginAction.jsp">
        <h3>로그인 화면</h3>
        <div>
            <input type="text" placeholder="아이디" name="userID" maxlength="20">
        </div>
        <div>
            <input type="password" placeholder="비밀번호" name="userPassword" maxlength="20">
        </div>
        <input type="submit" value="로그인">
    </form>
</div>
<%--애니메이션을 담당하는 jquery--%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>