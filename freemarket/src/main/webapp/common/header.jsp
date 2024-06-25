<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.LoginInfo,bean.MemberInfo,dao.MemberInfoDAO"%>

<%
LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
String authority = "";
if (loginInfo != null) {
	if (loginInfo.getLoginFlag() == 0) {
		authority = "：会員";
	} else if (loginInfo.getLoginFlag() == 1) {
		authority = "：管理者";
	}
} else {
	authority = "";
}
%>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<header>
	<div id="title">
		<h2>
			FURI-CAN<%=authority%></h2>
	</div>
	<div class="menu">
		<nav class="stroke">
			<%
			if (authority.equals("：管理者")) {
			%>
			<ul>
				<li><form method="post"
						action="<%=request.getContextPath()%>/productList"
						name="product_list_form">
						<a href="#" onclick="document.product_list_form.submit()">商品一覧</a>
					</form></li>
				<li><form method="post"
						action="<%=request.getContextPath()%>/userList"
						name="user_list_form">
						<a href="#" onclick="document.user_list_form.submit()">ユーザー一覧</a>
					</form></li>
				<li><form method="post"
						action="<%=request.getContextPath()%>/onSalerList"
						name="saler_form">
						<a href="#" onclick="document.saler_form.submit()">出品者一覧</a>
					</form></li>
				<li><form method="post"
						action="<%=request.getContextPath()%>/sales" name="sales_form">
						<a href="#" onclick="document.sales_form.submit()">売上確認</a>
					</form></li>
				<!-- <li><a href="./contact.html">問い合わせ</a></li> -->
			</ul>
			<%
			} else {
			%>
			<ul>
				<li><form method="post"
						action="<%=request.getContextPath()%>/productList"
						name="product_list_form">
						<a href="#" onclick="document.product_list_form.submit()">商品一覧
						</a>
					</form></li>
				<li>
					<form method="post"
						action="<%=request.getContextPath()%>/userInformation"
						name="userInformation_form">
						<a href="#" onclick="document.userInformation_form.submit()">ユーザー情報</a>
					</form>
				</li>
				<li>
					<form method="post"
						action="<%=request.getContextPath()%>/productInsert"
						name="product_insert_form">
						<input type="hidden" name="check" value="init"> <a
							href="#" onclick="document.product_insert_form.submit()">商品登録</a>
					</form>
				</li>
			</ul>
			<%
			}
			%>
		</nav>
	</div>
</header>