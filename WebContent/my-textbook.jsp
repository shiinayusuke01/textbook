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
String changedTitle = request.getParameter("changed_textbook");
String insertedTitle = request.getParameter("inserted_textbook");

String deletedMsg = "";
String changeMsg = "";
String insertedMsg = "";
if(deletedTitle != null){
	deletedMsg = deletedTitle + "を削除しました";
}
if(changedTitle != null){
	changeMsg = changedTitle + "を変更しました。";
}
if(insertedTitle != null){
	insertedMsg = insertedTitle + "を登録しました。";
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>登録した教科書一覧</title><br>
<link href="./css/header.css" rel="stylesheet">
</head>
<body>
<header></header>
<br />

	<h2>${membean.last_name} ${membean.first_name} 様が登録した教科書一覧</h2>
<br>
	<a style="color:red"><%= deletedMsg %></a>
	<a style="color:red"><%= changeMsg %></a>
	<a style="color:red"><%= insertedMsg %></a>


	<table class="type06">
	<tr><th class="data fst">タイトル</th><th class="data">著者名</th><th class="data">分類</th><th class="data">状態</th><th class="data">値段</th><th class="data">備考</th><th class="data">販売状態</th><th class="data">削除</th><th class="data">変更</th></tr>
		<c:forEach items="${textbooks}" var="textbook">
		    <c:if test="${textbook.stock eq 1}">
		      <form method="POST">
			  <input type="hidden" name="textbook_id" value="${textbook.id}">
				<tr>
					<td>${textbook.title}</td>
					<td class="data fst">${textbook.author}</td>
					<td class="data fst">${textbook.categoryname}</td>
					<td class="data">${textbook.status}</td>
					<td class="data">${textbook.price}円</td>
					<td class="data">${textbook.info}</td>
					<td class="data">販売中</td>
					<td><input type="submit" value="削除" formaction="/textbook/DeleteTextbookServlet"  class="btn btn-flat"/></td>
					<td><input type="submit" value="変更" formaction="/textbook/InputFormServlet"  class="btn btn-flat"/></td>
				</tr>
		      </form>
		    </c:if>
		</c:forEach>
	</table>
<br><br>
	<h2>売却済み教科書一覧</h2>
<br>
	<table class="type06">
	<tr><th class="data fst">タイトル</th><th class="data">著者名</th><th class="data">分類</th><th class="data">状態</th><th class="data">値段</th><th class="data">備考</th><th class="data">販売状態</th></tr>
		<c:set value="${0}" var="total"></c:set>
		<c:forEach items="${textbooks}" var="textbook">
		    <c:if test="${textbook.stock eq 0}">
		      <form method="POST">
			  <input type="hidden" name="textbook_id" value="${textbook.id}">
				<tr>
					<td>${textbook.title}</td>
					<td class="data fst">${textbook.author}</td>
					<td class="data fst">${textbook.categoryname}</td>
					<td class="data">${textbook.status}</td>
					<td class="data">${textbook.price}円</td>
					<td class="data">${textbook.info}</td>
					<td class="data">売却済</td>
				</tr>
		      </form>
		<c:set var="total" value="${total + textbook.price}"></c:set>
		    </c:if>
		</c:forEach>
		<tr><td align="right" colspan="7">合計売上金額：
		${total}円</td></tr>
	</table>

	<footer><a href="/textbook/MainPageServlet?action=list">トップページ</a></footer>
</body>
</html>