<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ホーム</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<h1>管理者トップページ</h1>
<br>
<form action="/textbook/MembersServlet?action=logout" method="post">
<input type="submit" value="ログアウト" class="btn btn-flat">
</form>

<h3>会員検索</h3>
<form action="/textbook/AdMainPageServlet" method="post">
苗字を入力：<input type="text" name="searchname">
<input type="hidden" name="action" value="memsearch">
<input type="submit" value="検索">
</form>

<table class="brwsr2">
<tr><td>id</td><td>氏</td><td>名</td><td>email</td><td>削除</td></tr>

<c:forEach items="${showmem}" var="member">
<tr><td>${member.id}</td><td>${member.last_name}</td>
<td>${member.first_name}</td><td>${member.email}</td>
<td>
<form action="/textbook/AdMainPageServlet?action=memdelete" method="post">
<input type="hidden" name="mem_id" value="${member.id}">
<input type="submit" value="削除">
</form></td></tr>

</c:forEach>
<br>
</table>
<br><br>
<h3>教科書検索</h3>
<form action="/textbook/AdMainPageServlet" method="post">
タイトルを入力：<input type="text" name="searchtitle">
<input type="hidden" name="action" value="textsearch">
<input type="submit" value="検索">
</form>

<table class="brwsr2">
<br>
<tr><td>id</td><td>タイトル</td><td>著者名</td><td>状態</td><td>分類</td><td>売値</td><td>備考</td><td>登録者</td><td>削除</td></tr>

<c:forEach items="${showtext}" var="text">
<tr><td>${text.id}</td><td>${text.title}</td><td>${text.author}</td>
<td>${text.status}</td><td>${text.category}</td>
<td>${text.price}</td><td>${text.info}</td><td>${text.userId}</td>
<td>
<form action="/textbook/AdMainPageServlet?action=textdelete" method="post">
<input type="hidden" name="text_id" value="${text.id}">
<input type="submit" value="削除">
</form></td></tr>
<br>
</c:forEach>
</table>
<br>
<br>
<table border="1">
<tr><th>お問い合わせ内容</th><th>名前</th><th>メールアドレス</th></tr>
<c:forEach items="${inquirybeans}" var="inquiry">
	<tr><td>${inquiry.content}</td><td>${inquiry.user}</td><td>${inquiry.email}</td></tr>
</c:forEach>
</table>
</body>
</html>