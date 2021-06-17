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
<input type="hidden" name="">
${textbook.title}
${textbook.autor}
${textbook.autor}

</c:forEach>
</body>
</html>