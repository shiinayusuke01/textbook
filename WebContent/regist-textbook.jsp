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
</head>
<body>
<a href="/textbook/main-input.jsp">トップページ</a>
<br />

<h3>${membean.last_name} ${membean.first_name}様</h3>
<h3>教科書を登録してください</h3>
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

	<p><label>売値：<input type="text" name="price" value="${textbook.price}"></label></p>
	商品状態:<select name="status" size="1">
		<option value="新品、未使用">新品、未使用</option>
		<option value="未使用に近い">未使用に近い</option>
		<option value="目立った傷や汚れなし">目立った傷や汚れなし</option>
		<option value="やや傷や汚れあり">やや傷や汚れあり</option>
		<option value="傷や汚れあり">傷や汚れあり</option>
		<option value="全体的に状態が悪い">全体的に状態が悪い</option>
	</select>
	<p><label>備考：<input type="text" name="info" size="40" value="${textbook.info}"></label></p>
	<p><input type="submit" value="登録" formaction="/textbook/RegistTextbookServlet"></p>
</form>
<p style="color: red;"> ${errmsg}</p>

</body>
</html>
