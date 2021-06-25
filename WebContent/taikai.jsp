<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="textbook.MembersBean"%>
<%
MembersBean bean = (MembersBean) session.getAttribute("membean");
if(bean == null) {
	RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
	rd.forward(request, response);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバーからの退会</title>
<link href="./css/header.css" rel="stylesheet">
<style>

</style>
</head>
<body>
<header></header>
<h1>本当に退会しますか？</h1>
<table class="type06"   align="center">
<caption></caption>
<tr><th>氏</th><td>${membean.last_name}</td></tr>
<tr><th>名</th><td>${membean.first_name}</td></tr>
<tr><th>郵便番号</th><td>${membean.postal}</td></tr>
<tr><th>住所</th><td>${membean.address}</td></tr>
<tr><th>電話番号</th><td>${membean.tel}</td></tr>
<tr><th>Email</th><td>${membean.email}</td></tr>
<tr><th>生年月日</th><td>${membean.birthday}</td></tr>

</table>
<form action="/textbook/MembersServlet" method="post">
<input type="hidden" name="action" value="delete">
<input type="submit" value="退会" class="btn btn-flat">
</form>
<br><br>
<footer><a href="/textbook/MainPageServlet?action=list">トップページ</a></footer>
</body>
</html>