<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-16
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원 가입 페이지</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {

            const username = document.querySelector("#username");
            const userid = document.querySelector("#userid");
            const userpw = document.querySelector("#userpw");
            const userphone = document.querySelector("#userphone");
            const useremail = document.querySelector("#useremail");
            const userphoto = document.querySelector("#userphoto");


            $(function () {
                $("#regMem").click(function () {

                    const formData = new FormData();
                    const file = document.getElementById("userphoto")


                    axios.post('/members', {
                        username: username.value,
                        userid: userid.value,
                        userpw: userpw.value,
                        userphone: userphone.value,
                        useremail: useremail.value,
                        userphoto: userphoto.value // 파일은 따로 올려야 한다??

                    })
                        .then(res => {
                                console.log('회원가입 성공!!!');
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
<h1>회원 가입 페이지</h1>
<hr>

<%--<form action="/member/register" method="post" enctype="multipart/form-data">--%>
<table>
    <tr>
        <td>이름:</td>
        <td>
            <input type="text" placeholder="이름을 입력하세요." name="username" id="username">
        </td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>
            <input type="text" placeholder="아이디를 입력하세요." name="userid" id="userid">

        </td>
    </tr>
    <tr>
        <td>PW:</td>
        <td>
            <input type="password" placeholder="비밀번호를 입력하세요." name="userpw" id="userpw">

        </td>
    </tr>
    <tr>
        <td>전화번호:</td>
        <td><input type="tel" placeholder="전화번호를 입력하세요." name="userphone" id="userphone"></td>
    </tr>
    <tr>
        <td>이메일:</td>
        <td>
            <input type="email" placeholder="이메일을 입력하세요." name="useremail" id="useremail">

        </td>
    </tr>
    <tr>
        <td>프로필 사진:</td>
        <td><input type="file" name="userphoto" id="userphoto"></td>
    </tr>
    <tr id="regform">
        <Td></Td>
        <td><button id="regMem">회원가입</button></td>
    </tr>
</table>

<%--</form>--%>


</body>
</html>
