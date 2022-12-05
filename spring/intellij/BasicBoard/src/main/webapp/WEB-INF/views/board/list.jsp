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
            <h3 class="title">Basic Board List</h3>
        </div>
        <div class="card-body">


            <table class="table table-hover table-bordered">
                <thead class="text-center bg-primary text-white">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">제목</th>
                    <th scope="col">작성자</th>
                    <th scope="col">작성일</th>
                    <th scope="col">수정일</th>
                </tr>
                </thead>
                <tbody class="text-center">
                <c:forEach items="${page.list}" var="board" varStatus="status">
                    <tr>
                        <th scope="row">${(page.totalCountOfArticle - (page.pageNum-1)*10 ) - status.index}</th>
                        <td><a href="view?bno=${board.bno}">${board.title}</a> <span class="badge bg-danger">${board.replycnt}</span></td>
                        <td>${board.writer}</td>
                        <td>${board.regdate}</td>
                        <td>${board.updatedate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="text-end m-3">
                <a href="/board/reg" class="btn btn-primary" role="button">글 작성</a>
            </div>
            <%--pagination--%>
            <div class="container text-center ">
                <div class="row justify-content-md-center">
                    <div class="col">
                        <nav aria-label="...">
                            <ul class="pagination">

                                <c:if test="${page.pageNum > 10}">
                                    <li class="page-item disabled">
                                        <a class="page-link">&laquo;</a>
                                    </li>
                                </c:if>

                                <c:forEach var="num" begin="1" end="${page.totalCountOfPage}">
                                    <li class="page-item ${num eq page.pageNum ? 'active' : ''}" ><a class="page-link" href="?p=${num}">${num}</a></li>
                                </c:forEach>

                                <c:if test="${page.pageNum < 10 and page.totalCountOfPage > 10}">
                                    <li class="page-item">
                                        <a class="page-link" href="#">&raquo;</a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>

                </div>

            </div>


        </div>


    </div>



</main>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>