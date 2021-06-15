<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="textbook.MembersBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバーからの退会</title>
</head>
<body>
	<a href="/textbook/MembersServlet?action=main-input">トップページに戻る</a>
    <h1>マイページ／会員情報表示</h1>

<table border="1">

<tr><th>氏</th><th>${del.family_name}</th></tr>
<tr><th>名</th><th>${del.first_name}</th></tr>
<tr><th>住所</th><th>${del.address}</th></tr>
<tr><th>電話番号</th><th>${del.tel}</th></tr>
<tr><th>Email</th><th>${del.email}</th></tr>
<tr><th>生年月日</th><th>${del.birthday}</th></tr>

	<c:forEach items="${delete}" var="del">
		<form action="/textbook/MembersServlet?action=add" method="get">
		<input type="hidden" name="" value="${del.name}">
    </form>
	</c:forEach>
</table>
<input type="submit" value="削除">


</body>
</html>