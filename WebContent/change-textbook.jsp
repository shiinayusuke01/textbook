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
<title>教科書情報の変更</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<<<<<<< HEAD
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<form action="/textbook/regist-textbook.jsp" method="post">
<input type="submit" value="新規教科書登録">
</form>
<br>
<form action="/textbook/ShowMyTextbook" method="post">
<input type="submit" value="登録済み教科書情報変更・削除">
</form>
<br>
<form action="/textbook/mem-info-change.jsp" method="post">
<input type="submit" value="会員情報変更">
</form>
<br>
<form action="/textbook/taikai.jsp" method="post">
<input type="submit" value="退会">
</form>
<br>
<form action="/textbook/MembersServlet?action=logout" method="post">
<input type="submit" value="ログアウト">
</form>
=======
<a href="/textbook/main-input.jsp">トップページ</a>
<br />
>>>>>>> 5cf60784147f3454449644cf15a1f57ef1ff8522

<h3>教科書情報を変更してください</h3>
<form method="POST">
	<input type="hidden" name="id" value="${textbook.id}">
	<p><label>タイトル：<input type="text" name="title" size="40" value="${textbook.title}"></label></p>
	<p><label>著者名：<input type="text" name="author" size="40" value="${textbook.author}"></label></p>

	分類：<select name="category" size="1">
		<option value="0">文学部系</option>
		<option value="1">教育学部系</option>
		<option value="2">法学部系</option>
		<option value="3">社会学部系</option>
		<option value="4">経済学部系</option>
		<option value="5">理学部系</option>
		<option value="6">医学部系</option>
		<option value="7">歯学部系</option>
		<option value="8">薬学部系</option>
		<option value="9">工学部系</option>
		<option value="10">農学部系</option></p></option></select>

	<p><label>売値：<input type="text" name="price" size="40" value="${textbook.price}"></label></p>
	商品状態:<select name="status" size="1">
		<option value="新品、未使用">新品、未使用</option>
		<option value="未使用に近い">未使用に近い</option>
		<option value="目立った傷や汚れなし">目立った傷や汚れなし</option>
		<option value="やや傷や汚れあり">やや傷や汚れあり</option>
		<option value="傷や汚れあり">傷や汚れあり</option>
		<option value="全体的に状態が悪い">全体的に状態が悪い</option>
	</select>
	<p><label>備考：<input type="text" name="info" size="40" value="${textbook.info}"></label></p>
	<p><input type="submit" value="変更" formaction="/textbook/ChangeTextbookServlet"></p>
</form>

</body>
</html>