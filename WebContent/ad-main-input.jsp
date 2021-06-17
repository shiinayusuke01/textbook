<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ホーム</title>
</head>
<body>
<h1>管理者トップページ</h1>

<form action="/textbook/AdMainPageServlet" method="post">
<input type="text" value="searchname">
<input type="hidden" name="action" value="search">
<input type="submit" value="検索">
</form>
</body>
</html>