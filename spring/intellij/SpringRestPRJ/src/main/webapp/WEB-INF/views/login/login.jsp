<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-16
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원 로그인 페이지</title>
    <style>
        table {
            padding: 5px;
        }

        td {
            padding: 5px;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>


        document.addEventListener('DOMContentLoaded', () => {

            memberid = document.querySelector("#userid");
            memberpw = document.querySelector("#userpw");
            idremember = document.querySelector("#idremember");
            keeplogin = document.querySelector("#keeplogin");

            $(function () {
                $("#login").click(function () {
                    axios.post('/logins', {
                        memberid: memberid.value,
                        memberpw: memberpw.value,
                        idremember: idremember.value,
                        keeplogin: keeplogin.value

                    })
                        .then(res => {
                                console.log('로그인 성공');
                                location.href = "/";
                            }
                        )
                        .catch(err => console.log(err)) /*end axios*/
                });
            });


        })
    </script>
</head>
<body>
<h1>Todo 회원 로그인 페이지</h1>
<hr>
<%--<form method="post">--%>

<table>
    <tr>
        <td>ID:</td>
        <td><input type="text" placeholder="아이디를 입력하세요." name="userid" id="userid" value="${cookie.reId.value}">
        </td>
    </tr>
    <tr>
        <td>PW:</td>
        <td><input type="password" placeholder="비밀번호를 입력하세요." name="userpw" id="userpw"></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="checkbox" name="idremember" id="idremember" ${cookie.reId.value ne null ? 'checked' : ''}>
            아이디 저장
        </td>
    </tr>
    <tr>
        <td></td>
        <td><input type="checkbox" name="keeplogin" id="keeplogin" ${cookie.uuid.value != null ? 'checked' : ''}>
            로그인 유지
        </td>
    </tr>
    <tr>
        <td></td>
        <td><A href="/logins/login"> 회원 가입</A></td>
    </tr>

    <tr id="loginTdo">
        <Td></Td>
        <td>
            <button id="login">로그인</button>
        </td>
    </tr>
</table>
<%--</form>--%>

<c:if test="${param.error eq 'e'}">
    <script>
        alert('오류발생!!');
    </script>
</c:if>

<c:if test="${param.type eq 'nf'}">
    <script>
        alert('아이디 또는 비밀번호가 틀립니다.');
    </script>
</c:if>

</body>
</html>
