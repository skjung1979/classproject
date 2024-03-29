<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-24
  Time: PM 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/bootstrap/offcanvas.css" rel="stylesheet">

</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    <a class="navbar-brand mr-auto mr-lg-0" href="/">DEPT MANAGER</a>
    <button class="navbar-toggler p-0 border-0" type="button" data-toggle="offcanvas">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">DEPT<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">EMP</a>
            </li>

            <li class="nav-item">
                <a class="nav-link" href="#">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Switch account</a>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="https://example.com" id="dropdown01" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Settings</a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<div class="nav-scroller bg-white box-shadow">
    <nav class="nav nav-underline">
        <a class="nav-link active" href="#">Dashboard</a>
        <a class="nav-link" href="#">
            Friends
            <span class="badge badge-pill bg-light align-text-bottom">27</span>
        </a>
        <a class="nav-link" href="#">Explore</a>
        <a class="nav-link" href="#">Suggestions</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
        <a class="nav-link" href="#">Link</a>
    </nav>
</div>

<%--본문 화면 넣는 곳--%>
<main role="main" class="container">

    <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-primary rounded box-shadow">
        <img class="mr-3" src="https://icons.getbootstrap.com/assets/img/icons-hero.png" alt="" width="48" height="48">
        <div class="lh-100">
            <h6 class="mb-0 text-white lh-100">부서 리스트 </h6>
            <small>부서 정보 출력</small>
        </div>
    </div>

    <div class="my-3 p-3 bg-white rounded box-shadow">
        <table class="table table-striped">
            <tR>
                <th>부서번호</th>
                <th>부서이름</th>
                <th>부서위치</th>
                <th>관리</th>
            </tR>

            <c:forEach var="dept" items="${deptList}">

                <tr>
                    <Td>${dept.deptno}</Td>
                    <Td>${dept.dname}</Td>
                    <Td>${dept.loc}</Td>
                    <Td><a href="/dept/edit?no=${dept.deptno}">수정</a> / <a onclick="deleteDept(${dept.deptno});"
                                                                           style="cursor: pointer">삭제</a></Td>
                </tr>

            </c:forEach>
        </table>
    </div>


    <div class="m-3 p-1 border">
        <form>
            <table>
                <tr>
                    <td class="p-2">
                        <a href="/dept/register" class="btn btn-primary">부서등록</a>
                    </td>
                    <td class="p-2">

                    </td>
                    <td class="p-2">검색</td>
                    <td class="p-2">
                        <select name="searchType" class="form-control">
                            <option value="dname">부서이름</option>
                            <option value="loc">부서위치</option>
                        </select>
                    </td>
                    <td class="p-2">
                        <input type="text" name="keyword" class="form-control">
                    </td>
                    <td class="p-2">
                        <input type="submit" value="검색" class="btn btn-info">
                    </td>

                </tr>
            </table>
        </form>

    </div>
</main>


<script>
    function deleteDept(no) {
        if (confirm("삭제하시겠습니까?")) {
            location.href = '/dept/delete?deptno=' + no;
        }
    }
</script>


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="js/assets/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="js/assets/vendor/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/assets/js/vendor/holder.min.js"></script>
<script src="js/bootstrap/offcanvas.js"></script>

</body>
</html>
