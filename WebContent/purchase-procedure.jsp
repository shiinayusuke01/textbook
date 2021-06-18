<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終確認</title>
</head>
<body>
<h3>下記の内容で注文を行いますか？</h3>
<h3>教科書情報</h3>
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
	<input type="hidden" name="text-id" value="${item.value.id}">
	<input type="submit" value="削除">
</form>
</td>
</tr>
</c:forEach>
		<tr><td align="right" colspan="6">支払金額：${cart.total}円</td></tr>
	</table>
<form action="/textbook/OrderServlet?action=pay" method="post">
<h3>支払い方法を選択してください</h3>
	<input type="radio" name="pay" value="card" checked> クレジットカード
	<input type="radio" name="pay" value="debit"> デビットカード
	<input type="radio" name="pay" value="cash"> 現金
</form>
<h3>お客様情報</h3>
	<table border="1">
	<tr><td>氏</td><td>${member.last_name}</td>
	</tr>
	<tr>
	<tr><td>名</td><td>${member.first_name}</td>
	</tr>
	<tr>
	<td>発送先住所</td><td>${member.address}</td>
	</tr>
	<tr>
	<tr><td>電話番号</td><td>${member.tel}</td>
	</tr>
	<tr>
	<tr><td>e-mail</td><td>${member.email}</td>
	</tr>
	</table><br>
	<form action="/textbook/Order.jsp">
	<input type="submit" value="この注文内容で注文">
	</form>

	</c:if>
</body>
</html>