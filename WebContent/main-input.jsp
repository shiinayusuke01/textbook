<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h2>会員専用メイン画面</h2>
<br>
<a href="/textbook/form-textbook.jsp">新規教科書登録</a>
<br>
<a href="/textbook/my-textbook.jsp?action=textchange">教科書情報変更・削除</a>
<br>
<a href="/textbook/mem-info-change.jsp">会員情報変更</a>
<br>
<a href="/textbook/taikai.jsp">退会</a>
<br>
<a href="/textbook/MembersServlet?action=logout">ログアウト</a>
<br>

<br>
<a href="/textbook/cart.jsp">カート/購入</a>
<br>
<br>

<h3>検索</h3>（教科書タイトルを入力してください）

<br>
<br>
<form action="/textbook/MainPageServlet" method="post">
<input type="text" name="title">
<input type="hidden" name="action" value="search">
<input type="submit" value="検索">
</form>

<br>
<br>

<h2>検索結果</h2>

<table border="1">
  <tr>
    <td>title</td>
    <td>author</td>
    <td>category</td>
    <td>price</td>
    <td>status</td>
    <td>info</td>
    <td>userId</td>
  </tr>
<c:forEach items="${list}" var="TextbookBean">
  <tr>
    <td>${TextbookBean.title}</td>
    <td>${TextbookBean.author}</td>
    <td>${TextbookBean.category}</td>
    <td>${TextbookBean.price}</td>
    <td>${TextbookBean.status}</td>
    <td>${TextbookBean.info}</td>
    <td>${TextbookBean.userId}</td>

 <td>
 <form action="/textbook/cart.jsp" method="post">
  <input type="hidden" name="action" value="add">
  <input type="submit" value="カートに追加"></form>
  </td>
  </tr>


</c:forEach>
</table>


<br/>


</body>
</html>

