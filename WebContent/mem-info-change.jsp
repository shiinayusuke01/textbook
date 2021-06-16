<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
=======


>>>>>>> 01bd242 (0616/15:30)
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<<<<<<< HEAD
	<title>Member Information Change</title>
=======
	<title>Login Shinki</title>
>>>>>>> 01bd242 (0616/15:30)
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

<h1>会員情報変更</h1>
<<<<<<< HEAD
氏:<input type="text" name="name1">
名:<input type="text" name="name2">
<br>
〒:<input type="text" name="num">
<br>
住所:<input type="text" name="address">
<br>
電話番号:<input type="text" name="tel">
<br>
Email:<input type="email" name="email">
<br>
生年月日:
<form>
年:
	<select>
		<script>func(2021)</script>
	</select>
月:
	<select>
		<script>func2(12)</script>
	</select>
日:
	<select>
		<script>func2(31)</script>
	</select>
	</form>

<br>
パスワード:<input type="password" name="pass">
<br>
パスワードの確認:<input type="password" name="passadd">
<br>
<input type="submit" value="変更">

=======
<form action="/textbook/MembersServlet" method="post">
氏:<input type="text" name="last_name" value="${membean.last_name}">
名:<input type="text" name="first_name" value="${membean.first_name}">
<br>
〒:<input type="text" name="postal" value="${membean.postal}">
<br>
住所:<input type="text" name="address" value="${membean.address}">
<br>
電話番号:<input type="text" name="tel" value="${membean.tel}">
<br>
Email:<input type="email" name="email" value="${membean.email}">
<br>
生年月日:
年:
	<select name="year">
		<script>func(2021)</script>
	</select>
月:
	<select name="month">
		<script>func2(12)</script>
	</select>
日:
	<select name="day">
		<script>func2(31)</script>
	</select>
*生年月日は必ず再度ご入力ください
<br>
パスワード:<input type="password" name="password" value="${membean.password}">
<br>
パスワードの確認:<input type="password" name="passadd">
<br>
<input type="hidden" name="change" value="change">
<input type="submit" value="変更">
</form>
>>>>>>> 01bd242 (0616/15:30)
</body>
</html>