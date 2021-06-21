<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>Member Information Change</title>
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
<br>
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
パスワード:<input type="password" name="password" value="${membean.password}">
<br>
パスワードの確認:<input type="password" name="passadd">
<br>
<input type="hidden" name="action" value="change">
<input type="submit" value="変更">
</form>
</body>
</html>