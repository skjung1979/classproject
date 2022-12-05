<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>

    <%-- bootstrap v5.2 --%>
    <link  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">


</head>
<body>

<%--nav include--%>
<%@ include file="/WEB-INF/views/include/nav.jsp"%>


<main class="p-2">

    <div class="card">
        <div class="card-header">
            <h3 class="title">Basic Board Registration</h3>
        </div>
        <div class="card-body">

            <form method="post">
                <div class="mb-3">
                    <label for="title" class="form-label">제목</label>
                    <input type="text" class="form-control" id="title" name="title">
                    <%--<div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>--%>
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">내용</label>
                    <textarea class="form-control" id="content" name="content" rows="3"></textarea>
                </div>
                <div class="mb-3">
                    <label for="writer" class="form-label">작성자</label>
                    <input type="text" class="form-control" id="writer" name="writer">
                </div>
                <div class="mb-3">
                    <label for="photo" class="form-label">작성자</label>
                    <input type="file" class="form-control" id="photo" name="photo">
                </div>
                <div class="mb-3 text-end">
                    <button type="submit" class="btn btn-primary ">글 작성</button>
                </div>
            </form>



        </div>

    </div>



</main>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>