<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/header.css" rel="stylesheet">
<title>最終確認</title>

</head>
<body>
<header></header>
<h2>下記の内容で注文を行いますか？</h2>

<h3>教科書情報</h3>
<c:if test="${not empty cart}">
		<table class="type06">
		<thead>
	<tr><th>タイトル</th><th>著者名</th><th>分類</th><th>値段</th><th>状態</th><th>備考</th>
    <th>削除</th>
    </thead>
    <tbody>

<c:forEach items="${cart}" var="item">

		<tr>
		<td>${item.title}</td>
		<td>${item.author}</td>
		<td>${item.categoryname}</td>
		<td>${item.price}円</td>
		<td>${item.status}</td>
		<td>${item.info}</td>
		<td>
<form action="/textbook/OrderServlet?action=delete2" method="post">
	<input type="hidden" name="textsid2" value="${item.id}">
	<input type="submit" value="削除" class="btn btn-flat">
</form>
</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="7">支払金額：

<c:set value="${0}" var="total"></c:set>
<c:forEach items="${cart}" var="text">
<c:set var="total" value="${total + text.price}"></c:set>
</c:forEach>
${total}円</td></tr>
	</table></tbody>

	<br><br>
<h2>支払い方法を選択してください</h2>
<br><br>
	<input type="radio" name="pay" value="card" checked> クレジットカード
	<input type="radio" name="pay" value="debit"> デビットカード
	<input type="radio" name="pay" value="cash"> 現金
	<br><br>
<h2>お届け先</h2>

氏:<input type="text" name="last_name" value="${membean.last_name} "class="m-form-text" ><br><br>
名:<input type="text" name="first_name" value="${membean.first_name}"class="m-form-text" >
<br><br>
〒:<input type="text" name="postal" value="${membean.postal}"class="m-form-text" >
<br><br>
住所:<input type="text" name="address" value="${membean.address}"class="m-form-text" >
<br><br>
電話番号:<input type="text" name="tel" value="${membean.tel}"class="m-form-text" >
<br><br>
</c:if>
<br><br>
<form action="/textbook/OrderServlet?action=order" method="post"  >
<input type="submit" value="注文確定" class="btn btn--orange">
</form>
<br><br>
<footer><a href="/textbook/MainPageServlet?action=list">トップページへ</a></footer>


</body>
</html>