<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.MemberInfo,servlet.UserListServlet"%>

<%
ArrayList<MemberInfo> memberList = (ArrayList<MemberInfo>) request.getAttribute("memberList");
%>

<html>
<head>
<title>ユーザー一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<header>
		<div id="title">
			<h2>ユーザー一覧</h2>
		</div>
		<div class="menu">
			<nav class="stroke">
				<ul>
					<li><a href="<%=request.getContextPath()%>/productList">商品一覧</a></li>
					<li><a href="<%=request.getContextPath()%>/userList">ユーザー一覧</a></li>
					<li><a href="<%=request.getContextPath()%>/onSalerList">出品者一覧</a></li>
					<li><a href="<%=request.getContextPath()%>/sales">売上確認</a></li>
					<li><a href="<%=request.getContextPath()%>/inquiry">問い合わせ</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<table>
		<tr>
			<th width="200">ID
			</td>
			<th width="200">氏名
			</td>
		</tr>
		<%
		if (memberList != null) {
			for (int i = 0; i < memberList.size(); i++) {
				MemberInfo memberInfo = (MemberInfo) memberList.get(i);
		%>

		<tr>
			<td><a
				href="<%=request.getContextPath()%>/userDetail?user_id=<%=memberInfo.getUser_id()%>&cmd=userDetail"><%=memberInfo.getUser_id()%></a></td>
			<td><%=memberInfo.getSurname()%><%=memberInfo.getName()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

	</div>
	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>
</html>