<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員メイン</title>
</head>
<body>
<h1>会員メイン</h1>
<br>
<a href="/textbook/form-textbook.jsp">登録</a>
<br>
<a href="/textbook/my-textbook.jsp">変更</a>
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





<h5>会員メイン画面</h5>
<form action="/textbook/MainPageServlet" method="post">
<input type="text" name="searchname">
<input type="hidden" name="action" value="search">
<input type="submit" value="検索">
</form>

<table border=1>
<tr>
    <td>title</td>
    <td>author</td>
    <td>category</td>
    <td>price</td>
    <td>status</td>
    <td>info</td>
    <td>userId</td>
    <td>カートに追加</td>
  </tr>

<c:forEach items="${show}" var="Textbook">
<tr><td>${Textbook.title}</td><td>${Textbook.author}</td>
<td>${Textbook.category}</td><td>${Textbook.price}</td>
<td>${Textbook.status}</td><td>${Textbook.info}</td>
<td>${Textbook.userId}</td>
<td>
<form action="/Textbook/MainPageServlet?action=textadd" method="post">
<input type="hidden" name="Textbook_id" value="${Textbook.id}">
<input type="submit" value="カートに追加する">
</form></td></tr>

</c:forEach>

</table>
</body>
</html>