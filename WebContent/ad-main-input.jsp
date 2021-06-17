<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ホーム</title>
</head>
<body>
<h1>管理者トップページ</h1>

<h5>会員検索</h5>
<form action="/textbook/AdMainPageServlet" method="post">
苗字を入力：<input type="text" name="searchname">
<input type="hidden" name="action" value="search">
<input type="submit" value="検索">
</form>

<table border=1>
<tr><td>id</td><td>氏</td><td>名</td><td>email</td><td>削除</td></tr>

<c:forEach items="${show}" var="member">
<tr><td>${member.id}</td><td>${member.last_name}</td>
<td>${member.first_name}</td><td>${member.email}</td>
<td>
<form action="/textbook/AdMainPageServlet?action=delete" method="post">
<input type="hidden" name="mem_id" value="${member.id}">
<input type="submit" value="削除">
</form></td></tr>

</c:forEach>

</table>
</body>
</html>