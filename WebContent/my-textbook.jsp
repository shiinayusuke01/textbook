<%@page import="textbook.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%
MembersBean bean = (MembersBean) session.getAttribute("membean");
if(bean == null) {
	RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
	rd.forward(request, response);
}

%>

<%
String deletedTitle = request.getParameter("deleted_textbook");
String changeTitle = request.getParameter("change_textbook");
String insertedTitle = request.getParameter("inserted_textbook");
String deletedMsg = "";
String changeMsg = "";
String insertedMsg = "";
if(deletedTitle != null){
	deletedMsg = deletedTitle + "を削除しました";
}
if(changeTitle != null){
	changeMsg = changeTitle + "を変更しました。";
}
if(insertedTitle != null){
	insertedMsg = insertedTitle + "を登録しました。";
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>登録した教科書一覧</title>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header><img src="./img/textbook.jpeg" padding="5px" width="1400px" height="150px"></header>
<a href="/textbook/MainPageServlet?action=list">トップページ</a>
<br />

	<h3>${membean.last_name} ${membean.first_name} 様が登録した教科書一覧</h3>

	<a style="color:red"><%= deletedMsg %></a>
	<a style="color:red"><%= insertedMsg %></a>

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