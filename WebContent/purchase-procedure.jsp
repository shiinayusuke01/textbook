<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終確認</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<h3>下記の内容で注文を行いますか？</h3>
<h3>教科書情報</h3>
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
<form action="/textbook/OrderServlet?action=delete2" method="post">
	<input type="hidden" name="textsid2" value="${item.id}">
	<input type="submit" value="削除">
</form>
</td>
</tr>
</c:forEach>
<tr><td align="right" colspan="6">支払金額：

<c:set value="${0}" var="total"></c:set>
<c:forEach items="${cart}" var="text">
<c:set var="total" value="${total + text.price}"></c:set>
</c:forEach>
${total}円</td></tr>
	</table>
<h3>支払い方法を選択してください</h3>
	<input type="radio" name="pay" value="card" checked> クレジットカード
	<input type="radio" name="pay" value="debit"> デビットカード
	<input type="radio" name="pay" value="cash"> 現金
<h3>お届け先</h3>
氏:<input type="text" name="last_name" value="${membean.last_name}"><br>
名:<input type="text" name="first_name" value="${membean.first_name}">
<br>
〒:<input type="text" name="postal" value="${membean.postal}">
<br>
住所:<input type="text" name="address" value="${membean.address}">
<br>
電話番号:<input type="text" name="tel" value="${membean.tel}">
<br><br>
</c:if>
<form action="/textbook/OrderServlet?action=order" method="post">
<input type="submit" value="この注文内容で注文">
</form>

<form action="/textbook/MainPageServlet?action=list" method="post">
<input type="submit" value="トップページに戻る">
</form>


</body>
</html>