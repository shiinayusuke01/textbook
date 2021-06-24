<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html; charset=UTF-8");
 	String inquiry = request.getParameter("inquiry");
 	if(inquiry.equals("")){
		RequestDispatcher rd = request.getRequestDispatcher("MainPageServlet");
		request.setAttribute("inquiry_err_msg", "お問い合わせ内容が空です。");
		rd.forward(request, response);
 	}else{
 		request.setAttribute("inquiry_err_msg", "");
 	}
 %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./css/title.css" rel="stylesheet">
<title>お問い合わせの確認</title>
</head>
<body>
<h2>お問い合わせの内容はこちらでよろしいですか？</h2>
<%=inquiry%>
<form action="RegistInquiryServlet" method="post">
<input type="hidden" name="inquiry_content" value="<%=inquiry %>">
<input type="submit" value="送信">
</form>
</body>
</html>