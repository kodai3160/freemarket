


<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.MemberInfo"%>
<%
MemberInfo memberInfoObj = (MemberInfo) request.getAttribute("memberInfo");
%>

<head>
<title>ユーザー情報</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<%@include file="/common/header.jsp"%>
	<div class="user">
		<div>
			<h1>ユーザー情報</h1>
		</div>
		<div>
			<h2><%=memberInfoObj.getNickname()%>
				様
			</h2>
		</div>
		<div>
			<table style="width: 100%; margin: auot">
				<tr>
					<td><p style="text-align: center">出品中</p></td>
					<td><form method="post"
							action="<%=request.getContextPath()%>/onSaleList">
							<button type="submit">確認</button>
							<input type="hidden" name="member_id" value="<%= memberInfoObj.getMember_id() %>">
						</form></td>
				</tr>
				<tr>
					<td><p style="text-align: center">入金情報</p></td>
					<td><form method="post"
							action="<%=request.getContextPath()%>/deposit">
							<button type="submit">入金情報</button></form></td>
			</table>
		</div>
	</div>

	<%@include file="/common/footer.jsp"%>
</body>
</html>