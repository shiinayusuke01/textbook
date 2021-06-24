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
<header></header>
<h1>管理者トップページ</h1>
<br>
<a href="/textbook/MembersServlet?action=logout" >ログアウト</a>
</form>

<h3>会員検索</h3>
	<form action="/textbook/AdMainPageServlet" method="post">
		苗字を入力：<input type="text" name="searchname">
		<input type="hidden" name="action" value="memsearch">
		<input type="submit" value="検索" class="btn btn-flat">
	</form>

	<table class="type06">
		<thead>
			<tr>
				<th>id</th>
				<th>氏</th>
				<th>名</th>
				<th>email</th>
				<th>削除</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${showmem}" var="member">

			<tr>
				<td>${member.id}</td>
				<td>${member.last_name}</td>
				<td>${member.first_name}</td>
				<td>${member.email}</td>
			</tr>


		<form action="/textbook/AdMainPageServlet?action=memdelete" method="post">
			<input type="hidden" name="mem_id" value="${member.id}">
			<input type="submit" value="削除" class="btn btn-flat">
		</form>
	</c:forEach>
	</tbody>
	</table>

	<br>
	<br>

<h3>教科書検索</h3>
	<form action="/textbook/AdMainPageServlet" method="post">
		タイトルを入力：<input type="text" name="searchtitle">
		<input type="hidden" name="action" value="textsearch">
		<input type="submit" value="検索" class="btn btn-flat">
	</form>

	<table class="type06">
		<thead>
			<tr>
				<th>id</th>
				<th>タイトル</th>
				<th>著者名</th>
				<th>状態</th>
				<th>分類</th>
				<th>売値</th>
				<th>備考</th>
				<th>登録者</th>
				<th>削除</th>
			</tr>
		</thead>
		<tbody>
	<c:forEach items="${showtext}" var="text">

			<tr>
				<td>${text.id}</td>
				<td>${text.title}</td>
				<td>${text.author}</td>
				<td>${text.status}</td>
				<td>${text.category}</td>
				<td>${text.price}</td>
				<td>${text.info}</td>
				<td>${text.userId}</td>
				<td>
				<form action="/textbook/AdMainPageServlet?action=textdelete" method="post">
		        <input type="hidden" name="text_id" value="${text.id}">
		        <input type="submit" value="削除" class="btn btn-flat">
	            </form>
	            </td>
			</tr>



		<br>
<br>
</c:forEach>
</tbody>
</table>

<br>
<br>

<h3>問い合わせ一覧表示</h3>
	<form action="/textbook/AdMainPageServlet" method="post">
		<input type="hidden" name="action" value="inquiryshow">
		<input type="submit" value="表示" class="btn btn-flat">
	</form>

	<table class="type06">
		<thead>
			<tr>
				<th>問い合わせ内容</th>
				<th>名前</th>
				<th>削除</th>

			</tr>
		</thead>
		<tbody>
	<c:forEach items="${showinquiry}" var="text">

			<tr>
				<td>${text.content}</td>
				<td>${text.user}</td>
				<td>
				<form action="/textbook/AdMainPageServlet?action=inquirydelete" method="post">
		<input type="hidden" name="inquiry_id" value="${text.id}">
		<input type="submit" value="削除" class="btn btn-flat">
			</form>

		</td>
			</tr>


<br>
</c:forEach>
</tbody>
</table>
</body>
</html>