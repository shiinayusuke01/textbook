<%@page import="textbook.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員ホーム</title>
<link href="./css/title.css" rel="stylesheet">

<script type="text/javascript">
        $(document).ready(function(){
            $('.slider').bxSlider({
                auto: true,
                pause: 5000,
            });
        });
</script>

</head>
<body>
<header>
            <ul>
              <li>
              <form action="/textbook/regist-textbook.jsp" method="post">
				<input type="submit" value="新規教科書登録" class="btn btn-flat">
				</form>
				</li>
              <li><form action="/textbook/ShowMyTextbook" method="post">
				<input type="submit" value="教科書情報変更・削除" class="btn btn-flat">
				</form>
				</li>
              <li><form action="/textbook/mem-info-change.jsp" method="post">
				<input type="submit" value="会員情報変更" class="btn btn-flat">
				</form>
				</li>
              <li><form action="/textbook/taikai.jsp" method="post">
				<input type="submit" value="退会" class="btn btn-flat">
				</form>
				</li>
              <li><form action="/textbook/MembersServlet?action=logout" method="post">
				<input type="submit" value="ログアウト" class="btn btn-flat">
				</form>
				</li>
            </ul>

</header>

<div class="main-grid">

<aside>
	<h2>教科書検索</h2>

	<form action="/textbook/MainPageServlet" method="post">
	検索したいタイトルを入力してください<br>
	<input type="text" name="searchname" class="m-form-text" >
	<input type="hidden" name="action" value="search">
	<input type="submit" value="検索" >
	</form>
	<br>
	<br>

	<form action="/textbook/MainPageServlet" method="post">
	検索したい著者名を入力してください<br>
	<input type="text" name="authorname" class="m-form-text" >
	<input type="hidden" name="action" value="searchauthor">
	<input type="submit" value="検索" >
	</form>
	<br>
	<br>

	<form action="/textbook/MainPageServlet" method="post">
	検索したい分類を選択してください<br>
	<div class="cp_ipselect cp_sl02">
	<select name="category" size="1" required>
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
		<option value="10">農学部系</option></p></option>
		</select>
	</div>
	<br>
	<input type="hidden" name="action" value="searchcate">
	<input type="submit" value="検索" >

	</form>

</aside>

<article>

	<h1>会員トップページ</h1>
	<h2>${membean.last_name} ${membean.first_name}様、いらっしゃいませ</h2>
<br><br>
	<a href="/textbook/cart.jsp" >
	カート/購入ページへ</a>

	<br><br>
	<a href="/textbook/PurchaseHistory">
	購入履歴ページへ</a>
	<br>
	<br>



	<h3>検索結果表示</h3>

	<br>
	<table class="type06">
	<tr>
    <th>タイトル</th>
    <th >著者名</th>
    <th >分類</th>
    <th >価格</th>
    <th >状態</th>
    <th >備考</th>
    <th >カートに追加</th>
  	</tr>

	<c:forEach items="${show}" var="Textbook">
	<tr><td>${Textbook.title}</td><td>${Textbook.author}</td>
	<td>${Textbook.categoryname}</td><td>${Textbook.price}</td>
	<td>${Textbook.status}</td><td>${Textbook.info}</td>
	<td>
	<br>

	<form action="/textbook/CartServlet?action=add" method="post">
	<input type="hidden" name="text-id" value="${Textbook.id}">
	<input type="hidden" name="putid2" value="${Textbook.userId}">
	<input type="submit" value="カートに追加"  class="btn btn--orange">
	</form></td></tr>

	</c:forEach>
	</table>
	<br><br>

	<h2>販売中教科書一覧</h2>
	<br>
	<table class="type06">
	<thead>
    <tr>
      <th>タイトル</th>
      <th>著者名</th>
      <th>分類</th>
      <th>価格</th>
      <th>状態</th>
      <th>備考</th>
      <th>カートに追加</th>
    </tr>
  </thead>

  <tbody>
  <c:forEach items="${showall}" var="Text">
  <tr>
      <td>${Text.title}</td>
      <td>${Text.author}</td>
      <td>${Text.categoryname}</td>
      <td>${Text.price}</td>
      <td>${Text.status}</td>
      <td>${Text.info}</td>
      <td>
      <form action="/textbook/CartServlet?action=addtext" method="post">
	<input type="hidden" name="textid" value="${Text.id}">
      <input type="hidden" name="putid" value="${Text.userId}">
	<input type="submit" value="カートに追加"  class="btn btn--orange">
	</form>
	</td>
    </tr>
    </c:forEach>
  </tbody>
	</table>
</article>
</div>

</body>
</html>


