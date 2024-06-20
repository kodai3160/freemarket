<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.LoginInfo,bean.MemberInfo,dao.MemberInfoDAO"%>

<%
LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
String authority = "";
if(loginInfo!=null){
	if (loginInfo.getLoginFlag() == 0) {
		authority = "：会員";
	} else if (loginInfo.getLoginFlag() == 1) {
		authority = "：管理者";
	}
}else{
	authority = "";
}
%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<header>
	<div id="title">
		<h2>
			フリーマーケット<%=authority %></h2>
	</div>
	<div class="menu">
		<nav class="stroke">
			<%if(authority.equals("管理者")){ %>
				<ul>
					<li><a href="./product_List">商品一覧</a></li>
					<li><a href="./userList">ユーザー一覧</a></li>
					<li><a href="./onSalerList">出品者一覧</a></li>
					<li><a href="./sales">売上確認</a></li>
					<li><a href="./contact.html">問い合わせ</a></li>
				</ul>
			<%}else{ %>
				<ul>
					<li><a href="<%=request.getContextPath()%>/productList">商品一覧</a></li>
					<li><a href="<%=request.getContextPath()%>/userInformation">ユーザー情報</a></li>
					<li><a href="<%=request.getContextPath()%>/productInsert">商品登録</a></li>
				</ul>
			<%} %>
		</nav>
	</div>
</header>