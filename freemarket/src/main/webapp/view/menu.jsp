<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.MemberInfo,servlet.LoginServlet,servlet.UserListServlet"%>

<html>
<head>
<title>管理者メニュー</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<boby>
<div id="title">
	<h2>フリーマーケット</h2>
</div>
<div class="menu">
	<nav class="stroke">
		<ul>
			<li><a href="<%=request.getContextPath()%>/onSalerList">出品者一覧</a></li>
			<li><a href="<%=request.getContextPath()%>/productList">商品一覧</a></li>
			<li><a href="<%=request.getContextPath()%>/userList">ユーザー一覧</a></li>
			<li><a href="<%=request.getContextPath()%>/sales">売上確認</a></li>
			<li><a href="<%=request.getContextPath()%>/inquiry">問い合わせ</a></li>
		</ul>
	</nav>
</div>
<%@include file="/common/footer.jsp"%> </boby>
</html>