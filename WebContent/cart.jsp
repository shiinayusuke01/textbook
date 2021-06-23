<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome shopping!</title>
<link href="./css/title.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>

<h1>現在のカートの中身</h1>

<c:if test="${empty cart}">
<h2>現在、カートは空です。</h2>
</c:if>

<c:if test="${not empty cart}">
<table class="type06"   align="center">
	<thead>
	<tr>
	<th>タイトル</th>
	<th>著者名</th>
	<th>分類</th>
	<th>価格</th>
	<th>状態</th>
	<th>備考</th>
    <th>削除</th>
	<tr>
	<thead>

	<tbody>
	<c:forEach items="${cart}" var="item">
	<td>${item.title}</td>
	<td>${item.author}</td>
	<td>${item.categoryname}</td>
	<td>${item.price}円</td>
	<td>${item.status}</td>
	<td>${item.info}</td>
<td>
<form action="/textbook/CartServlet?action=delete1" method="post">
	<input type="hidden" name="textsid" value="${item.id}">
	<input type="submit" value="削除" class="btn btn-flat">
</form>
</td>
</c:forEach>

<tr><td align="right" colspan="6">合計金額：
<c:set value="${0}" var="total"></c:set>
<c:forEach items="${cart}" var="text">
<c:set var="total" value="${total + text.price}"></c:set>
</c:forEach>
${total}円</td></tr>
</table>
 </tbody>

<form action="/textbook/OrderServlet?action=purchase" method="post">
<input type="submit" value="購入する" class="btn btn-flat">

</form>
</c:if>
<br>
<footer><a href="/textbook/MainPageServlet?action=list">トップページへ</a></footer>
</form>

</body>
</html>
