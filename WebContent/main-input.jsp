<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>

<h2>会員専用メイン画面</h2>
<br>
<a herf="">新規教科書登録</a>
<br>
<a herf="">教科書情報変更・削除</a>
<br>
<a herf="">会員情報変更</a>
<br>
<a herf="">退会</a>
<br>
<a herf="">ログアウト</a>
<br>

検索（教科書タイトルを入力してください）
<br>
<form action="/textbook/MainPageServlet" method="post">
<input type="text" value="">
<input type="submit" value="検索">
</form>

<br>
<br>

<h2>検索結果</h2>

<table>
  <tr>
    <th>title</th>
    <th>author</th>
    <th>category</th>
    <th>status</th>
    <th>price</th>
    <th>info</th>
  </tr>
<c:forEach var="TextbookBean" items="${TextbookBean}">
  <tr>
    <td>${TextbookBean.title}</td>
    <td>${TextbookBean.author}</td>
    <td>${TextbookBean.category}</td>
    <td>${TextbookBean.status}</td>
    <td>${TextbookBean.price}</td>
    <td>${TextbookBean.info}</td>
  </tr>
</c:forEach>
</table>
<br/>


</body>
</html>

