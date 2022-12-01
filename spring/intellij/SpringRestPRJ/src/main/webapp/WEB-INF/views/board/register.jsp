<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-12-01
  Time: AM 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 등록</title>
    <style>
        table {
            width: 600px;
        }

        input {
            width: 500px
        }

        textarea {
            width: 500px;
            height: 500px;
            resize: none;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {

            bno = document.querySelector("#bno")
            writer = document.querySelector("#writer")
            title = document.querySelector("#title")
            content = document.querySelector("#content")


            axios.get('/boards/Maxbno')
                .then(res => /*console.log('res', res.data)*/
                    bno.value = res.data + 1)
                // 태그 캐스팅 -> 데이터 변경
                .catch(err => console.log(err))

            axios.get('/boards/membernm')
                .then(res => writer.value = res.data)
                // 태그 캐스팅 -> 데이터 변경
                .catch(err => console.log(err))

            $(function () {
                $("#insert").click(function () {
                    axios.post('/boards', {
                        bno: bno.value,
                        title: title.value,
                        content: content.value,
                        writer: writer.value,
                        regdate: "2022-12-01",
                        updatedate: "2022-12-01"
                    })
                        .then(res =>
                            location.href = "list"
                        )
                        .catch(err => console.log(err)) /*end axios*/
                });
            });


            /*$(function () {
                $("#insert").click(function () {
                    var board = {
                        bno: bno.value,
                        title: title.value,
                        content: content.value,
                        writer: writer.value,
                        regdate: "2022-12-01",
                        updatedate: "2022-12-01"
                    };
                    $.ajax({
                        // 아래 타입과 url 및 데이터를 바꿔가며 테스트 진행
                        type: "POST",
                        url: "

            ${contextPath}/boards",


            <%--//type: "PUT",--%>


            <%--//url: "${contextPath}/boards/1",--%>
                        contentType: "application/json",
                        data: JSON.stringify(board),
                        success: function (data, textStatus) {
                            alert(data);
                        },
                        error: function (data, textStatus) {
                            alert("에러가 발생했습니다.");
                        },
                        complete: function (data, textStatus) {
                        }
                    }); /!*end ajax*!/
                });
            });*/


        });
    </script>
</head>
<body>

<h1>게시글 등록</h1>
<hr>

<table>
    <tr>
        <Td>번호</Td>
        <Td><input type="text" name="bno" readonly id="bno"></Td>
    </tr>
    <tr>
        <Td>제목:</Td>
        <Td><input type="text" name="title" id="title"></Td>
    </tr>
    <tr>
        <Td>작성자:</Td>
        <Td><input type="text" name="writer" id="writer" readonly></Td>
    </tr>
    <tr>
        <Td>내용:</Td>
        <Td><textarea name="content" id="content"></textarea></Td>
    </tr>
    <tr>
        <Td></Td>
        <Td>
            <button id="insert">게시글 등록</button> <a href="/boards/list"><button>전체목록</button></a>

        </Td>
    </tr>
</table>

</body>
</html>
