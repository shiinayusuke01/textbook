<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Member Information Change</title>
<link href="./css/header.css" rel="stylesheet">
<script>
		function func(num){
			for (var i = 1900; i <= num; i++){
				document.write("<option>" + i + "</option>");
			}
		}
	</script>
	<script>
		function func2(num){
			for (var i = 1; i <= num; i++){
				document.write("<option>" + i + "</option>");
			}
		}
	</script>
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<h1>会員情報変更</h1>
<br>
<form action="/textbook/MembersServlet" method="post">
氏:<input type="text" name="last_name" value="${membean.last_name}" class="m-form-text">
<br>
名:<input type="text" name="first_name" value="${membean.first_name}" class="m-form-text">
<br>
〒:<input type="text" name="postal" value="${membean.postal}" class="m-form-text">
<br>
住所:<input type="text" name="address" value="${membean.address}" class="m-form-text">
<br>
電話番号:<input type="text" name="tel" value="${membean.tel}" class="m-form-text">
<br>
Email:<input type="email" name="email" value="${membean.email}" class="m-form-text">
<br>
生年月日:

	<select name="year">
		<script>func(2021)</script>
	</select>年

	<select name="month">
		<script>func2(12)</script>
	</select>月

	<select name="day">
		<script>func2(31)</script>
	</select>日
*生年月日は必ず再度ご入力ください
<br>
パスワード:<input type="password" name="password" value="${membean.password}" class="m-form-text">
<br>
パスワードの確認:<input type="password" name="passadd" class="m-form-text">
<br>
<input type="hidden" name="action" value="change">
<input type="submit" value="変更" class="btn btn-flat">
</form>
<br>
<footer><a href ="/textbook/MainPageServlet?action=list">トップページ</a></footer>
</form>
</body>
</html>