<%@page import="textbook.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
<title>教科書の登録</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>

<br/>
<div class="container">
<h1>教科書新規登録ページ</h1>
<br>
<h2>${membean.last_name} ${membean.first_name}様、教科書情報を入力してください</h2>
<br>
<form method="POST">
	<input type="hidden" name="id" value="${textbook.id}">
	<p><label>タイトル：<input type="text" name="title" size="40" value="${textbook.title}" class="m-form-text"></label></p>
	<p><label>著者名：<input type="text" name="author" size="40" value="${textbook.author}" class="m-form-text"></label></p>

	分類：<select name="category" size="1">
		<option value="0">０.文学部系</option>
		<option value="1">１.教育学部系</option>
		<option value="2">２.法学部系</option>
		<option value="3">３.社会学部系</option>
		<option value="4">４.経済学部系</option>
		<option value="5">５.理学部系</option>
		<option value="6">６.医学部系</option>
		<option value="7">７.歯学部系</option>
		<option value="8">８.薬学部系</option>
		<option value="9">９.工学部系</option>
		<option value="10">１０.農学部系</option></select>

	<p><label>売値：<input type="text" name="price" value="${textbook.price}" class="m-form-text"></label>円</p>
	商品状態:<select name="status" size="1">
		<option value="新品、未使用">新品、未使用</option>
		<option value="未使用に近い">未使用に近い</option>
		<option value="目立った傷や汚れなし">目立った傷や汚れなし</option>
		<option value="やや傷や汚れあり">やや傷や汚れあり</option>
		<option value="傷や汚れあり">傷や汚れあり</option>
		<option value="全体的に状態が悪い">全体的に状態が悪い</option>
	</select>
	<p><label>備考：<input type="text" name="info" size="40" value="${textbook.info}" class="m-form-text"></label></p>
	<p><input type="submit" value="登録" formaction="/textbook/RegistTextbookServlet" class="btn btn-flat"></p>
</form>
<p style="color: red;"> ${errmsg}</p>
<footer><a href="/textbook/MainPageServlet?action=list">トップページ</a></footer>
</div>
</body>
</html>
