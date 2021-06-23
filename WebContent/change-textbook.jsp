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
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>

<br />
<h1>教科書情報を変更してください</h1>
<form method="POST">
	<input type="hidden" name="id" value="${textbook.id}">
	<p><label>タイトル：<input type="text" name="title" size="40" value="${textbook.title}"></label></p>
	<p><label>著者名：<input type="text" name="author" size="40" value="${textbook.author}"></label></p>

	分類：<select name="category" id="category" size="1">
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
	商品状態:<select name="status" id="status" size="1">
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
<br><br>
<a href="/textbook/MainPageServlet?action=list">トップページへ</a>

<script>
document.getElementById("category").selectedIndex = ${textbook.category};
</script>

</body>
</html>
