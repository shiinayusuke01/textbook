<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバーからの退会</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
	<a href="/textbook/MainPageServlet?action=list">トップページに戻る</a>
    <h1>本当に退会しますか？</h1>

<table border="1">

<tr><th>氏</th><th>${membean.last_name}</th></tr>
<tr><th>名</th><th>${membean.first_name}</th></tr>
<tr><th>郵便番号</th><th>${membean.postal}</th></tr>
<tr><th>住所</th><th>${membean.address}</th></tr>
<tr><th>電話番号</th><th>${membean.tel}</th></tr>
<tr><th>Email</th><th>${membean.email}</th></tr>
<tr><th>生年月日</th><th>${membean.birthday}</th></tr>

</table>
<form action="/textbook/MembersServlet" method="post">
<input type="hidden" name="action" value="delete">
<input type="submit" value="退会">
</form>


</body>
</html>