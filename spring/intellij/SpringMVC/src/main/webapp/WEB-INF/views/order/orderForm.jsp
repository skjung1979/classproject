<%--
  Created by IntelliJ IDEA.
  User: skjung_gram
  Date: 2022-11-21
  Time: AM 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>주문</h1>
<hr>
<form method="post">

    <h3>상품 1</h3>
    ID - <input type="text" name="orderItems[0].itemId"><br>
    개수 - <input type="text" name="orderItems[0].number"><br>
    주의 - <input type="text" name="orderItems[0].remark">

    <h3>상품 2</h3>
    ID - <input type="text" name="orderItems[1].itemId"><br>
    개수 - <input type="text" name="orderItems[1].number"><br>
    주의 - <input type="text" name="orderItems[1].remark">

    <h3>상품 3</h3>
    ID - <input type="text" name="orderItems[2].itemId"><br>
    개수 - <input type="text" name="orderItems[2].number"><br>
    주의 - <input type="text" name="orderItems[2].remark">

    <h2>배송지 주소</h2>
    우편번호 - <input type="text" name="address.zipcode"><br>
    주소1 - <input type="text" name="address.address1"><bR>
    주소2 - <input type="text" name="address.address2"><br>
<hr>
    <input type="submit" value="전송">

</form>

</body>
</html>
