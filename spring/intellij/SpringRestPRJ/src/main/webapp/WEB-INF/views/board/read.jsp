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
    <title>게시글 상세화면</title>
    <style>
        table {
            width: 600px;
        }

        input {
            width: 500px
        }

        .cont {
            width: 500px;
            height: 500px;
            resize: none;
        }

        .rep {
            width: 500px;
            height: 100px;
            resize: none;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {

            /*현재 날짜*/
            const date = new Date();
            const year = date.getFullYear();
            const month = ('0' + (date.getMonth() + 1)).slice(-2);
            const day = ('0' + date.getDate()).slice(-2);
            const dateStr = year + '-' + month + '-' + day;
            console.log(dateStr);

            /* 문서 객체 생성 */
            const bno = document.querySelector("#bno")
            const writer = document.querySelector("#writer")
            const title = document.querySelector("#title")
            const content = document.querySelector("#content")
            const editA = document.querySelector("#editA")
            const regdate = document.querySelector("#regdate")

            const rno = document.querySelector("#rno")
            const rcontent = document.querySelector("#rcontent")



            /*선택한 게시글 하나 불러옴*/
            axios.get('/boards/${param.bno}')
                .then(res => {
                    console.log('res', res.data.bno);
                    bno.value = res.data.bno;
                    title.value = res.data.title;
                    writer.value = res.data.writer;
                    content.value = res.data.content;
                    regdate.value = res.data.regdate;
                    editA.href = '/boards/edit?bno=' + res.data.bno;
                })
                .catch(err => console.log(err))

            axios.get('/replys/Maxrno')
                .then(res => rno.value = res.data+1)
                .catch(err => console.log(err))


            $(function () {
                $("#btn_rep").click(function () {
                    axios.post('/replys', {
                        rno: rno.value,
                        userid: "sk",
                        boardid: bno.value,
                        content: rcontent.value,
                        regdate: dateStr,
                        updatedate: dateStr
                    })
                        .then(res => {
                            console.log('댓글 쓰기 성공!!!');

                            /*댓글 쓴 후 기존 리스트에 새댓글이 삽입되어야 함*/
                            replyTbl = document.querySelector("#replyTbl")

                            const newTrU = document.createElement('tr')
                            const newTrC = document.createElement('tr')
                            const newTrD = document.createElement('tr')
                            const newTrB = document.createElement('tr')
                            const newBtn = document.createElement('button')

                            let str1 = '<td>' + 'sk' + '</td>'
                            let str2 = '<td>' + rcontent.value + '</td>'
                            let str3 = '<td>' + dateStr + '</td>'
                            let str4 = '<td><button>수정</button> <button>삭제</button><hr>'

                            newTrU.innerHTML = str1
                            replyTbl.appendChild(newTrU);

                            newTrC.innerHTML = str2
                            replyTbl.appendChild(newTrC);

                            newTrD.innerHTML = str3
                            replyTbl.appendChild(newTrD);

                            newTrB.innerHTML = str4;
                            replyTbl.appendChild(newTrB);

                            /*댓글 쓴 후 기존 값들 초기화시킴*/
                            rno.value = "";
                            rcontent.value = "";

                        })
                        .catch(err => console.log(err)) /*end axios*/
                });
            });

            getReplys();




        });

        function getReplys(){

            /*댓글 중 bno와 일치하는 리스트 출력하기*/
            $.ajax({
                url: "/replys/board/${param.bno}",
                type: "GET",
                dataType: "json",
                success: ajaxHtml,
                error: function () {
                    alert("error");
                }
            });

            function ajaxHtml(data) {
                var html = "<table class='table' id='replyTbl'>";

                $.each(data, (index, obj) => {
                    html += "<tr>";
                    html += "<td>" + obj.userid + "/" + obj.rno + "</td>";
                    html += "</tr>";
                    html += "<tr>";
                    html += "<td>" + obj.content + "</td>";
                    html += "</tr>";
                    html += "<tr>";
                    html += "<td>" + obj.regdate + "</td>";
                    html += "</tr>";
                    html += "<tr>";
                    html += "<td><button>수정</button> <a href='javascript: removeReply(" + obj.rno + ")'><button>삭제</button></a><hr></td>";
                    html += "</tr>";
                })
                html += "</table>";

                $("#allReply").html(html);
            }

        }

        function removeReply(no){
            axios.delete('/replys/'+ no )
                .then(res => getReplys())
                .catch(err => console.log(err))

        };


    </script>
</head>
<body>

<h1>게시글 상세화면</h1>
<hr>

<table>
    <tr>
        <Td>번호</Td>
        <Td><input type="text" name="bno" readonly id="bno"></Td>
    </tr>
    <tr>
        <Td>제목:</Td>
        <Td><input type="text" name="title" id="title" readonly></Td>
    </tr>
    <tr>
        <Td>작성자:</Td>
        <Td><input type="text" name="writer" id="writer" readonly>
        <input type="hidden" id="regdate"></Td>
    </tr>
    <tr>
        <Td>내용:</Td>
        <Td><textarea name="content" id="content" readonly class="cont"></textarea></Td>
    </tr>
    <tr>
        <Td></Td>
        <Td>
            <a href="/boards/edit?bno=" id="editA"><button>게시글 수정</button></a> <a href="/boards/list"><button>전체목록</button></a>
        </Td>
    </tr>
</table>
<hr>
<b>댓글</b>
<table>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <td><div id="allReply">댓글 목록 로딩 중...</div>
        </td>
    </tr>
    <tr>
        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="hidden" id="rno" name="rno"></td>
        <td><textarea id="rcontent" class="rep" name="rcontent"></textarea><br><br>
            작성자: 아무개 <button id="btn_rep">댓글쓰기</button>
        </td>
    </tr>
</table>



</body>
</html>
