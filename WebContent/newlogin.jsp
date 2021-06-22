<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Shinki</title>
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
<h1>新規会員登録</h1>
<form action="/textbook/MembersServlet" method="post">
氏:<input type="text" name="last_name">
名:<input type="text" name="first_name">
<br>
〒:<input type="text" name="postal">
<br>
住所:<input type="text" name="address">
<br>
電話番号:<input type="text" name="tel">
<br>
Email:<input type="email" name="email">
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
<br>
パスワード:<input type="password" name="password">
<br>
パスワードの確認:<input type="password" name="passadd">
<br>
<input type="hidden" name="action" value="setinfo">
<input type="submit" value="登録">
</form>
</body>
</html>