<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入手続き</title>
</head>
<body>
<a>支払い方法を選択してください</a>
<form action="PurchaseServlet">
	<input type="radio" name="pay" value="card"> クレジットカード
	<input type="radio" name="pay" value="debit"> デビットカード
	<input type="radio" name="pay" value="cash"> 現金
</form>

<a>最終確認</a>

<a>支払金額</a>
<a>教科書情報</a>
<a>名前</a>
<a>発送先住所</a>
<a>電話番号</a>
</body>
</html>