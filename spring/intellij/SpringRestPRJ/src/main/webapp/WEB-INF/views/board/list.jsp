<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-12-01
  Time: PM 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 리스트</title>
    <style>
        table {
            width: 600px;
            border: 0px;
        }
        .cen {
            text-align: center;
        }
        .head {
            background-color: gray;
            color: white;
        }
    </style>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
    <script>
        document.addEventListener('DOMContentLoaded', () => {

            const wrap = document.querySelector("#wrap")

            const newTB = document.createElement('table');
            const newTR = document.createElement('tr');
            const newTD = document.createElement('td');


            $.ajax({
                url: "/boards/all",
                type: "GET",
                dataType: "json",
                success: ajaxHtml,
                error: function () {
                    alert("error");
                }
            });

            function ajaxHtml(data) {
                var html = "<table class='table'>";
                html += "<tr class='head'>";
                html += "<th>번호</th>";
                html += "<th>제목</th>";
                html += "<th>작성자</th>";
                html += "<th>작성일자</th>";
                html += "</tr>";

                $.each(data, (index, obj) => {
                    html += "<tr>";
                    html += "<td class='cen'>" + obj.bno + "</td>";
                    html += "<td><a href='/boards/read?bno=" + obj.bno + "'>" + obj.title + "</a></td>";
                    html += "<td class='cen'>" + obj.writer + "</td>";
                    html += "<td class='cen'>" + obj.regdate + "</td>";
                    html += "</tr>";
                })
                html += "</table>";

                $("#allList").html(html);
            }


            /*       axios.get('/boards/all')
                       .then(res => console.log('res', res))
                       .then(res => console.log(res))
                       // 태그 캐스팅 -> 데이터 변경
                       .catch(err => console.log(err))*/


            /*         $(function () {
                         $("#insert").click(function () {
                             axios.post('/boards', {
                                 bno: bno.value,
                                 title: title.value,
                                 content: content.value,
                                 writer: writer.value,
                                 regdate: "2022-12-01",
                                 updatedate: "2022-12-01"
                             })
                                 .then(res => console.log(res))
                                 .catch(err => console.log(err)) /!*end axios*!/
                         });
                     });
         */

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
                        url: "${contextPath}/boards",

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
<h1>게시글 전체 목록</h1>
<hr>

<div id="allList">여기에 게시글 전체 목록이 출력됩니다.</div>
<a href="/boards/register"><button>글쓰기</button></a>
</body>
</html>
