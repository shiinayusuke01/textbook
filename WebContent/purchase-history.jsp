<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="./css/header.css" rel="stylesheet">
</head>
<meta charset="UTF-8">
<title>購入履歴</title>
</head>
<body>
	<h3>${membean.last_name} ${membean.first_name}様の購入履歴</h3>
	<table class="brwsr2">
	<tr><th>タイトル</th><th>著者名</th><th>状態</th><th>値段</th><th>備考</th></tr>
		<c:set value="${0}" var="total"></c:set>
		<c:forEach items="${purchased_textbooks}" var="textbook">
			<tr>
				<td>${textbook.title}</td>
				<td>${textbook.author}</td>
				<td>${textbook.status}</td>
				<td>${textbook.price}円</td>
				<td>${textbook.info}</td>
			</tr>
			<c:set var="total" value="${total + textbook.price}"></c:set>

		</c:forEach>
		<tr><td align="right" colspan="6">合計購入金額：
		${total}円</td></tr>
	</table>
	<footer><a href="/textbook/MainPageServlet?action=list">トップページ</a></footer>
</body>
</html>