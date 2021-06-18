<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入手続き</title>
</head>
<body>

<h3>購入手続き</h3>

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
	</form>
		</td>
		</tr>
</c:forEach>
		<tr><td align="right" colspan="6">合計金額：${cart.total}円</td></tr>
	</table>

<h3>お客様情報を入力してください</h3>

	<form action="/textbook/OrdesServlet?action=confirm" method="post">
		<table border="1">
    		<tr>
    		<td>氏</td><td><input type="text" name="last_name"></td>
    		</tr>
    		<tr>
    		<td>名</td><td><input type="text" name="first_name"></td>
    		</tr>
    		<tr>
    		<td>住所</td><td><input type="text" name="address"></td>
    		</tr>
    		<tr>
    		<td>電話番号</td><td><input type="text" name="tel"></td>
    		</tr>
    		<tr>
    		<td>e-mail</td><td><input type="text" name="e-mail"></td>
		</table>
	<input type="submit" value="確認画面へ">
	</form>

</c:if>
</body>
</html>