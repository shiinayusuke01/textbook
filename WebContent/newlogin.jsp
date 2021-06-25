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
<header></header>
<h1>新規会員登録</h1>
<form action="/textbook/MembersServlet" method="post">
氏:<input type="text" name="last_name"  class="m-form-text">
<br>
名:<input type="text" name="first_name" class="m-form-text">
<br>
〒:<input type="text" name="postal" class="m-form-text">
<br>
住所:<input type="text" name="address" class="m-form-text">
<br>
電話番号:<input type="text" name="tel" class="m-form-text">
<br>
Email:<input type="email" name="email" class="m-form-text">
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
パスワード:<input type="password" name="password" class="m-form-text">
<br>
パスワードの確認:<input type="password" name="passadd" class="m-form-text">
<br><br>
<input type="hidden" name="action" value="setinfo">
<input type="submit" value="登録" class="btn btn-flat">
</form><br><br>
<footer><a href="/textbook/Login.html"  class="cp_link2" >ログイン画面に戻る</a></footer>
</body>
</html>