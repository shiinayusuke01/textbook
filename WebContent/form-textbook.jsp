<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録教科書の変更</title>
</head>
<body>
<form action="/textbook/RegistTextbook" method="post">
<p><label>タイトル：<input type="text" name="title" size="40"></label></p>
<p><label>著者名：<input type="text" name="author" size="40"></label></p>
<p><label>分類：<input type="text" name="category" size="40"></label></p>
<p><label>売値：<input type="text" name="price" size="40"></label></p>

<select name="status" size="5">
<option value="新品、未使用">新品、未使用</option>
<option value="未使用に近い">未使用に近い</option>
<option value="目立った傷や汚れなし">目立った傷や汚れなし</option>
<option value="やや傷や汚れあり">やや傷や汚れあり</option>
<option value="傷や汚れあり">傷や汚れあり</option>
<option value="全体的に状態が悪い">全体的に状態が悪い</option>
</select>
<p><label>備考：<input type="text" name="info" size="40"></label></p>
<input type="hidden" name="action" value="reg">
<p><input type="submit" value="登録"></p>
<input type="hidden" name="action" value="change">
<p><input type="submit" value="変更"></p>

</form>

</body>
</html>