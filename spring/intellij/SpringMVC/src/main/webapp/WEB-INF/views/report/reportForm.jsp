<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-21
  Time: PM 2:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>과제 제출 3 (세번째 방법: 커맨드 객체)</h1>
<form action="/report/submit3" method="post" enctype="multipart/form-data"> <!-- 파일 업로드 방식의 필수 속성들 method:post / enctype:multipart/form-data -->

    <table>
        <Tr>
            <td>학번:</td>
            <td><input type="text" name="snum"></td>
        </Tr>
        <Tr>
            <td>이름:</td>
            <td><input type="text" name="sname"></td>
        </Tr>
        <Tr>
            <td>리포트 파일:</td>
            <td><input type="file" name="report"></td>
        </Tr>
        <Tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </Tr>

    </table>

</form>

<hr>

<h1>과제 제출 2 (두번째 방법 MultipartHttpServletRequest)</h1>
<form action="/report/submit2" method="post" enctype="multipart/form-data"> <!-- 파일 업로드 방식의 필수 속성들 method:post / encttype:multipart/form-data -->

    <table>
        <Tr>
            <td>학번:</td>
            <td><input type="text" name="snum"></td>
        </Tr>
        <Tr>
            <td>이름:</td>
            <td><input type="text" name="sname"></td>
        </Tr>
        <Tr>
            <td>리포트 파일:</td>
            <td><input type="file" name="report"></td>
        </Tr>
        <Tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </Tr>

    </table>

</form>
<hr>
<h1>과제 제출 1 (첫번째 방법 @RequestParam)</h1>
<form action="/report/submit1" method="post" enctype="multipart/form-data"> <!-- 파일 업로드 방식의 필수 속성들 method:post / encttype:multipart/form-data -->

    <table>
        <Tr>
            <td>학번:</td>
            <td><input type="text" name="snum"></td>
        </Tr>
        <Tr>
            <td>이름:</td>
            <td><input type="text" name="sname"></td>
        </Tr>
        <Tr>
            <td>리포트 파일:</td>
            <td><input type="file" name="report"></td>
        </Tr>
        <Tr>
            <td></td>
            <td><input type="submit" value="제출"></td>
        </Tr>

    </table>

</form>


</body>
</html>
