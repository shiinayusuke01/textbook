<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録教科書一覧</title>

</head>
<body>
	<table border="1">



		<tr><td>タイトル</td><td>著者名</td><td>分類</td><td>値段</td></tr>
		<c:forEach items="${textbook}" var="text">

			<tr>
				<td>${text.title}</td><td>${text.author}</td><td>${text.category}</td>
				<td>${text.price}</td>
				<td>
			<form action="/textbook/ChangeTextbookServlet?action=change" method="get">
		    	<input type="submit" value="変更"></form></td>
		    	<td>
		    <form action="/textbook/ChangeTextbookServlet?action=delete" method="get">
		    	<input type="submit" value="削除"></form></td>

	   		</tr>
      	</c:forEach>
	</table>

</body>
</html>