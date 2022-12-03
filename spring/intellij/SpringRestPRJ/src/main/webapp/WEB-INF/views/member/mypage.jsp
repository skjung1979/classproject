<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-22
  Time: PM 4:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mypage</title>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>

        document.addEventListener('DOMContentLoaded', () => {

            membernm = document.querySelector("#nm");
            seq = document.querySelector("#seq");
            id = document.querySelector("#id");
            email = document.querySelector("#email");
            photo = document.querySelector("#photo");
            img1 = document.querySelector("#img1");
            newImg = document.createElement('img');

            axios.get('/members/loginMember')
                .then(res => {

                        console.log('res => ', res);
                        console.log(res.data.membernm);

                        membernm.textContent = res.data.membernm;
                        seq.textContent = res.data.seq;
                        id.textContent = res.data.memberid;
                        email.textContent = res.data.memberemail;

                        newImg.setAttribute("src", "/uploadfile/member/" + res.data.uphoto);
                        photo.appendChild(newImg);

                    }
                )
                .catch(err => console.log(err))


        })

    </script>
</head>
<body>
<h1>Mypage</h1>
<hr>
<table style="border: 1px">
    <tr>
        <td>이름</td>
        <td id="nm"></td>
    </tr>
    <tr>
        <td>회원코드</td>
        <td id="seq"></td>
    </tr>
    <tr>
        <td>아이디</td>
        <td id="id"></td>
    </tr>
    <tr>
        <td>이메일</td>
        <td id="email"></td>
    </tr>
    <tr>
        <td>사진</td>
        <td id="photo"><img id="img1"></td>
        <%--<td id="photo"><img src="/uploadfile/member/${loginInfo.uphoto}" id="img1"></td>--%>
    </tr>
</table>
<a href="/">going to Main Page</a>

</body>
</html>
