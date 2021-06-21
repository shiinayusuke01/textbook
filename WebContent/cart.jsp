<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
<link rel="stylesheet" href="header.css">
</head>
<body>
<header>ヘッダー</header>
<h3>現在のカートの中身</h3>

<c:if test="${empty cart}">
現在、カートは空です。
</c:if>

<c:if test="${not empty cart}">
<table border="1">
<tr><td>タイトル</td><td>著者名</td><td>値段</td><td>状態</td><td>備考</td>
    <td>削除</td>

<c:forEach items="${cart}" var="item">
<tr>
	<td align="center">${item.title}</td>
	<td align="center">${item.author}</td>
	<td align="right">${item.price}円</td>
	<td align="right">${item.status}</td>
	<td align="right">${item.info}</td>
<td>
<form action="/textbook/CartServlet?action=delete" method="post">
	<input type="hidden" name="textsid" value="${item.id}">
	<input type="submit" value="削除">
</form>
</td>
</tr>
</c:forEach>

<tr><td align="right" colspan="6">合計金額：
<c:set value="${0}" var="total"></c:set>
<c:forEach items="${cart}" var="text">
<c:set var="total" value="${total + text.price}"></c:set>
</c:forEach>
${total}円</td></tr>
</table>

<form action="/textbook/OrderServlet?action=input_customer" method="post">
	<input type="submit" value="購入する">

</form>
</c:if>
<br>
<form action="/textbook/MainPageServlet?action=list" method="post">
<input type="submit" value="トップページに戻る">
</form>

</body>
</html>
