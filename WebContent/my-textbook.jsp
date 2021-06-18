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
	<c:forEach items="${textbooks}" var="textbook">
		<form method="POST">
			<input type="hidden" name="textbook_id" value="${textbook.id}">
				タイトル${textbook.title}<br />
				著者名${textbook.author}<br />
				状態${textbook.status}<br />
				値段${textbook.price}<br />
				備考${textbook.info}<br />
			<input type="submit" value="削除" formaction="/textbook/DeleteTextbookServlet" />^M
			<input type="submit" value="変更" formaction="/textbook/InputFormServlet" />
		</form>
		<br />
	</c:forEach>
</body>
</html>