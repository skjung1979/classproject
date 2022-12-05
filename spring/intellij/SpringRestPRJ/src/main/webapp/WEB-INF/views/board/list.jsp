<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-12-01
  Time: PM 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            //getList(); // ajax 방식
            getList2() // axios 방식
            getPage2();


        });

        function getList2(num) {

            const allList = document.querySelector("#allList");

            axios.get('/boards/all' ,{
                params: {
                    p: num
                }
            })
                .then(res => {

                    console.log("dtolist => ", res.data.dtolist);
                    console.log("dtolist / bno => ", res.data.dtolist[0].bno);

                    let html = "<table class='table'>";
                    html += "<tr class='head'>";
                    html += "<th>번호</th>";
                    html += "<th>제목</th>";
                    html += "<th>작성자</th>";
                    html += "<th>작성일자</th>";
                    html += "</tr>";

                    for (let i=0; i<res.data.dtolist.length; i++){

                        if (res.data.dtolist[i].rcnt != "0") {
                            html += "<tr>";
                            html += "<td class='cen'>" + res.data.dtolist[i].bno + "</td>";
                            html += "<td><a href='/boards/read?bno=" + res.data.dtolist[i].bno + "'>" + res.data.dtolist[i].title + "</a> <b>[" + res.data.dtolist[i].rcnt + "]</b></td>";
                            html += "<td class='cen'>" + res.data.dtolist[i].writer + "</td>";
                            html += "<td class='cen'>" + res.data.dtolist[i].regdate + "</td>";
                            html += "</tr>";

                        } else {
                            html += "<tr>";
                            html += "<td class='cen'>" + res.data.dtolist[i].bno + "</td>";
                            html += "<td><a href='/boards/read?bno=" + res.data.dtolist[i].bno + "'>" + res.data.dtolist[i].title + "</a></td>";
                            html += "<td class='cen'>" + res.data.dtolist[i].writer + "</td>";
                            html += "<td class='cen'>" + res.data.dtolist[i].regdate + "</td>";
                            html += "</tr>";
                        }

                    }

                    html += "</table>";

                    allList.innerHTML = html;
                    //allList.textContent = html; // html 소스 그대로 들어감.

                })
                .catch(err => console.log(err))

        }

        function getPage2(num) {

            const paging = document.querySelector("#paging");

            axios.get('/boards/all', {
                params: {
                    p: num
                }
            })
                .then(res => {

                    console.log("요청 페이지 번호 => ", res.data.pageNum);
                    console.log("페이지당 게시글 수 => ", res.data.psize);
                    console.log("전체 페이지 수 => ", res.data.ptotal);
                    console.log("시작 페이지 => ", res.data.start);
                    console.log("마지막 페이지 => ", res.data.end);
                    console.log("prev유무 => ", res.data.prev);
                    console.log("next유무 => ", res.data.next);

                    pagingDiv = document.querySelector("#paging")
                    //newDiv = document.createElement('div');

                    let str = '';

                    if (res.data.prev == true) {
                        str += '<a href="javascript: getPage2(' + (res.data.pageNum-10) + ')">PREV </a>';
                    }

                    for (let i = res.data.start; i <= res.data.end; i++) {

                        if (i == res.data.pageNum) {
                            str += '<a href="javascript: getList2(' + i + '); getPage2(' + i + ');"><b>' + i + '</b></a> ';

                        } else {
                            str += '<a href="javascript: getList2(' + i + '); getPage2(' + i + ');">' + i + '</a> ';
                        }
                    }

                    //if (data.pageNum < 10 && data.ptotal > 10) {
                    if (res.data.next == true) {
                        str += '<a href="javascript: getPage2(' + (res.data.pageNum) + ')"> NEXT</a>';
                    }

                    //newDiv.innerHTML = str;
                    pagingDiv.innerHTML = str;

                })
                .catch(err => console.log(err))

        }

        function getList() {

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

                console.log("dtolist => ", data.dtolist);

                var html = "<table class='table'>";
                html += "<tr class='head'>";
                html += "<th>번호</th>";
                html += "<th>제목</th>";
                html += "<th>작성자</th>";
                html += "<th>작성일자</th>";
                html += "</tr>";

                $.each(data.dtolist, (index, obj) => {

                    if (obj.rcnt != "0") {
                        html += "<tr>";
                        html += "<td class='cen'>" + obj.bno + "</td>";
                        html += "<td><a href='/boards/read?bno=" + obj.bno + "'>" + obj.title + "</a> <b>[" + obj.rcnt + "]</b></td>";
                        html += "<td class='cen'>" + obj.writer + "</td>";
                        html += "<td class='cen'>" + obj.regdate + "</td>";
                        html += "</tr>";
                    } else {
                        html += "<tr>";
                        html += "<td class='cen'>" + obj.bno + "</td>";
                        html += "<td><a href='/boards/read?bno=" + obj.bno + "'>" + obj.title + "</a></td>";
                        html += "<td class='cen'>" + obj.writer + "</td>";
                        html += "<td class='cen'>" + obj.regdate + "</td>";
                        html += "</tr>";
                    }
                })
                html += "</table>";

                $("#allList").html(html);
            }

        }



        function getPage() {

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

                console.log("요청 페이지 번호 => ", data.pageNum);
                console.log("페이지당 게시글 수 => ", data.psize);
                console.log("전체 페이지 수 => ", data.ptotal);
                console.log("시작 페이지 => ", data.start);
                console.log("마지막 페이지 => ", data.end);
                console.log("prev유무 => ", data.prev);
                console.log("next유무 => ", data.next);

                pagingDiv = document.querySelector("#paging")
                newDiv = document.createElement('div');

                let str = '';

                if (data.prev == true) {
                    str += '<a>PREV</a>';
                }

                for (let i = data.start; i <= data.end; i++) {

                    if (i == data.pageNum) {
                        //str += '<a href="/boards/list?p=' + i + '" onclick="getList2(' + i + ');"><b>' + i + '</b></a>  ';
                        str += '<a href="javascript: getList2(' + i + ')"><b>' + i + '</b></a>';

                    } else {

                        //str += '<a href="/boards/list?p=' + i + '" onclick="getList2(' + i + ');">' + i + '</a>  ';
                        str += '<a href="javascript: getList2(' + i + ')">' + i + '</a>';
                    }
                }

                //if (data.pageNum < 10 && data.ptotal > 10) {
                if (data.next == true) {
                    str += '<a href="#">NEXT</a>';
                }

                newDiv.innerHTML = str;
                pagingDiv.appendChild(newDiv);

            }

        }

    </script>
</head>
<body>
<h1>게시글 전체 목록</h1>
<hr>

<div id="allList"></div>
<div id="paging"></div>


<%--   <c:if test="${page.pageNum > 10}">
       <a>&laquo;</a>
   </c:if>

   <c:forEach var="num" begin="1" end="${page.totalCntOfPage}">
       <a href="?p=${num}">${num}</a>
   </c:forEach>

   <c:if test="${page.pageNum < 10 and page.totalCntOfPage > 10}">
       <a href="#">&raquo;</a>
   </c:if>--%>


<a href="/boards/register">
    <button>글쓰기</button>
</a>
</body>
</html>
