<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Shinki</title>
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

<h1>新規会員登録</h1>
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
<input type="submit" value="登録">

</body>
</html>