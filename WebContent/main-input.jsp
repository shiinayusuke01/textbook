<%@page import="textbook.MembersBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="textbook.MembersBean"%>
<%
MembersBean bean = (MembersBean) session.getAttribute("membean");
if(bean == null) {
	RequestDispatcher rd = request.getRequestDispatcher("/Login.html");
	rd.forward(request, response);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員ホーム</title>
<link href="./css/title.css" rel="stylesheet">
<script type="text/javascript">
        $(document).ready(function(){
            $('.slider').bxSlider({
                auto: true,
                pause: 5000,
            });
        });
</script>

</head>
<body>
<header>
            <ul>
              <li><a href="/textbook/regist-textbook.jsp"  class="btn4">新規登録教科書</a>&ensp;&ensp;&ensp;&ensp;
				</li>
              <li><a href="/textbook/ShowMyTextbook" class="btn4">教科書情報変更・削除</a>&ensp;&ensp;&ensp;&ensp;
				</li>
              <li><a href ="/textbook/mem-info-change.jsp" class="btn4">会員情報変更</a>&ensp;&ensp;&ensp;&ensp;</li>
              <li><a href ="/textbook/taikai.jsp" class="btn4">退会</a>&ensp;&ensp;&ensp;&ensp;
				</li>
              <li><a href="/textbook/MembersServlet?action=logout"  class="btn4">ログアウト</a>&ensp;&ensp;&ensp;&ensp;
				</li>
            </ul>

</header>
<div class="wrapper">

<div class="main-grid">

<aside>
	<h2>教科書検索</h2>
	<br>
	<br>

	<form action="/textbook/MainPageServlet" method="post">
	検索したいタイトルを入力してください<br>
	<input type="text" name="searchname" class="m-form-text" >
	<input type="hidden" name="action" value="search">
	<input type="submit" value="検索" >
	</form>
	<br>
	<br>

	<form action="/textbook/MainPageServlet" method="post">
	検索したい著者名を入力してください<br>
	<input type="text" name="authorname" class="m-form-text" >
	<input type="hidden" name="action" value="searchauthor">
	<input type="submit" value="検索" >
	</form>
	<br>
	<br>

	<form action="/textbook/MainPageServlet" method="post">
	検索したい分類を選択してください<br>
	<div class="cp_ipselect cp_sl02">
	<select name="category" size="1" required>
		<option value="0">文学部系</option>
		<option value="1">教育学部系</option>
		<option value="2">法学部系</option>
		<option value="3">社会学部系</option>
		<option value="4">経済学部系</option>
		<option value="5">理学部系</option>
		<option value="6">医学部系</option>
		<option value="7">歯学部系</option>
		<option value="8">薬学部系</option>
		<option value="9">工学部系</option>
		<option value="10">農学部系</option></p></option>
		</select>
	</div>

	</form>

	<input type="hidden" name="action" value="searchcate">
	<input type="submit" value="検索" >


<form action="confirm-inquiry.jsp" method="post">
<div class="Form">
  <div class="Form-Item">
    <p class="Form-Item-Label">
    	<h2>お問い合わせフォーム</h2><br>
    	<a style="color:red"> ${inquiry_err_msg}</a>
    	<textarea name="inquiry" rows="4" cols="40" class="Form-Item-Textarea"></textarea><br><br>
	<input type="submit" value="送信" class="Form-Btn">
	</div>
 </div>
</form>

</aside>

<article>
<div class="cp_cssslider">
	<div class="cp_slidewrapper">
		<div class="cp_slide_item"><img src="img/教科書1.png"></div>
		<div class="cp_slide_item"><img src="img/教科書2.jpg"></div>
		<div class="cp_slide_item"><img src="img/教科書3.jpg"></div>
	</div>
</div>
	<h1>会員トップページ</h1>
	<h2>${membean.last_name} ${membean.first_name}様、いらっしゃいませ</h2>
<br><br>
	<a href="/textbook/cart.jsp" ><font color="blue">
	カート/購入ページへ</font></a>

	<br><br>
	<a href="/textbook/PurchaseHistory"><font color="blue">
	購入履歴ページへ</font></a>
	<br>
	<br>



	<h3>検索結果表示</h3>

	<br>
	<table class="type06">
	<tr>
    <th>タイトル</th>
    <th >著者名</th>
    <th >分類</th>
    <th >価格</th>
    <th >状態</th>
    <th >備考</th>
    <th >カートに追加</th>
  	</tr>

	<c:forEach items="${show}" var="Textbook">
	<tr><td>${Textbook.title}</td><td>${Textbook.author}</td>
	<td>${Textbook.categoryname}</td><td>${Textbook.price}</td>
	<td>${Textbook.status}</td><td>${Textbook.info}</td>
	<td>
	<br>

	<form action="/textbook/CartServlet?action=add" method="post">
	<input type="hidden" name="text-id" value="${Textbook.id}">
	<input type="hidden" name="putid2" value="${Textbook.userId}">
	<input type="submit" value="カートに追加"  class="btn btn--orange">
	</form></td></tr>

	</c:forEach>
	</table>
	<br><br>

	<h2>販売中教科書一覧</h2>
	<br>
	<table class="type06">
	<thead>
    <tr>
      <th>タイトル</th>
      <th>著者名</th>
      <th>分類</th>
      <th>価格</th>
      <th>状態</th>
      <th>備考</th>
      <th>カートに追加</th>
    </tr>
  </thead>

  <tbody>
  <c:forEach items="${showall}" var="Text">
  <tr>
      <td>${Text.title}</td>
      <td>${Text.author}</td>
      <td>${Text.categoryname}</td>
      <td>${Text.price}</td>
      <td>${Text.status}</td>
      <td>${Text.info}</td>
      <td>
      <form action="/textbook/CartServlet?action=addtext" method="post">
	<input type="hidden" name="textid" value="${Text.id}">
      <input type="hidden" name="putid" value="${Text.userId}">
	<input type="submit" value="カート"  class="btn btn--orange">
	</form>
	</td>
    </tr>
    </c:forEach>
  </tbody>
	</table>
</article>
</div>

<footer></footer>
</div>
</body>
</html>


