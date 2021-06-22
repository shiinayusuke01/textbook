<%@page import="textbook.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員ホーム</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<h1>会員トップページ</h1>
<h3>${membean.last_name} ${membean.first_name}様、いらっしゃいませ</h3>
<br>
<form action="/textbook/regist-textbook.jsp" method="post">
<input type="submit" value="新規教科書登録">
</form>
<br>
<form action="/textbook/ShowMyTextbook" method="post">
<input type="submit" value="登録済み教科書情報変更・削除">
</form>
<br>
<form action="/textbook/mem-info-change.jsp" method="post">
<input type="submit" value="会員情報変更">
</form>
<br>
<form action="/textbook/taikai.jsp" method="post">
<input type="submit" value="退会">
</form>
<br>
<form action="/textbook/MembersServlet?action=logout" method="post">
<input type="submit" value="ログアウト">
</form>

<br>
<br>

<h2>教科書検索</h2>

<form action="/textbook/MainPageServlet" method="post">
検索したいタイトルを入力してください<br>
<input type="text" name="searchname">
<input type="hidden" name="action" value="search">
<input type="submit" value="検索">
</form>
<br>
<br>
<form action="/textbook/MainPageServlet" method="post">
分類：<select name="category" size="1">
		<option value="0">文学部系</option>
		<option value="1">教育学部系</option>
		<option value="2">法学部系</option>
		<option value="3">社会学部系</option>
		<option value="4">経済学部系</option>
		<option value="5">理学部系</option>
		<option value="6">医学部系</option>
		<option value="7">歯学部系</option>
		<option value="8">薬学部系</option>
		<option value="9">工学部系</option>
		<option value="10">農学部系</option></p></option></select>
検索したい分類を入力してください<br>
<input type="hidden" name="action" value="searchcate">
<input type="submit" value="検索">
</form>
<br>
<a href="/textbook/cart.jsp">カート/購入ページへ</a>
<br>
<br>



<h2>検索結果表示</h2>

<br>
<table border=1>
<tr>
    <td>タイトル</td>
    <td>著者名</td>
    <td>分類</td>
    <td>価格</td>
    <td>状態</td>
    <td>備考</td>
    <td>登録者ID</td>
    <td>カートに追加</td>
  </tr>

<c:forEach items="${show}" var="Textbook">
<tr><td>${Textbook.title}</td><td>${Textbook.author}</td>
<td>${Textbook.category}</td><td>${Textbook.price}</td>
<td>${Textbook.status}</td><td>${Textbook.info}</td>
<td>${Textbook.userId}</td>
<td>
<br>

<form action="/textbook/CartServlet?action=add" method="post">
<input type="hidden" name="text-id" value="${Textbook.id}">
<input type="submit" value="カートに追加する">
</form></td></tr>

</c:forEach>
</table>
<br><br>

<h2>販売中教科書一覧</h2>
<br>
<table border=1>
<tr>
    <td>タイトル</td>
    <td>著者名</td>
    <td>分類</td>
    <td>価格</td>
    <td>状態</td>
    <td>備考</td>
    <td>登録者ID</td>
    <td>カートに追加</td>
  </tr>

<c:forEach items="${showall}" var="Text">
<tr><td>${Text.title}</td><td>${Text.author}</td>
<td>${Text.category}</td><td>${Text.price}</td>
<td>${Text.status}</td><td>${Text.info}</td>
<td>${Text.userId}</td>
<td>
<br>

<form action="/textbook/CartServlet?action=addtext" method="post">
<input type="hidden" name="textid" value="${Text.id}">
<input type="submit" value="カートに追加する">
</form></td></tr>

</c:forEach>
</table>
</body>
</html>
