<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
</head>
<body>

<h3>現在のカートの中身</h3>

<c:if test="${empty cart.items}">
現在、カートは空です。
</c:if>

<c:if test="${not empty cart.items}">
<table border="1">
<tr><td>タイトル</td><td>著者名</td><td>値段</td><td>状態</td><td>備考</td>
    <td>削除</td>

<c:forEach items="${cart.items}" var="item">
<tr>
	<td align="center">${item.value.title}</td>
	<td align="center">${item.value.author}</td>
	<td align="right">${item.value.price}円</td>
	<td align="right">${item.value.status}</td>
	<td align="right">${item.value.info}</td>
<td>
<form action="/textbook/CartServlet?action=delete" method="post">
	<input type="hidden" name="id" value="${item.value.id}">
	<input type="submit" value="削除">
</form>
</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">合計金額：${cart.total}円</td></tr>
</table>

<form action="/textbook/OrderServlet?action=input_customer" method="post">
	<input type="submit" value="購入する">

</form>
</c:if>
<br>
<a href="/textbook/main-input.jsp"></a>
<br>	
<input type="submit" value="トップページへ戻る">

</body>
</html>
