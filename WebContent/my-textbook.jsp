<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録した教科書一覧</title>
</head>
<body>
	<h3>登録した教科書一覧</h3>
	<table  border="1">
	<tr><th>タイトル</th><th>著者名</th><th>状態</th><th>値段</th><th>備考</th><th> </th><th> </th></tr>
	<c:forEach items="${textbooks}" var="textbook">
		<form method="POST">
			<input type="hidden" name="textbook_id" value="${textbook.id}">
				<tr>
					<td>${textbook.title}</td>
					<td>${textbook.author}</td>
					<td>${textbook.status}</td>
					<td>${textbook.price}円</td>
					<td>${textbook.info}</td>
					<td><input type="submit" value="削除" formaction="/textbook/DeleteTextbookServlet" /></td>
					<td><input type="submit" value="変更" formaction="/textbook/InputFormServlet" /></td>
				</tr>
		</form>
	</c:forEach>
	</table>
</body>
</html>