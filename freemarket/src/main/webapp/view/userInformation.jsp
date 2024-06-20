<%@page contentType="text/html; charset=UTF-8"%>
<%@page import = "bean.MemberInfo" %>
<%
MemberInfo memberInfoObj = (MemberInfo)request.getAttribute("memberInfo");
%>

<head>
<title>ユーザー情報</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>
<body class="login">
<%@include file="/common/header.jsp"%>
<div class="user">
	<div>
		<h1>
			ユーザー情報		
		</h1>
	</div>
	<div>
		<h2><%=memberInfoObj.getNickname() %>  様</h2>
	</div>
	<div>
		<table style="width: 100%; margin:auot">
			<tr>
				<td><p style="text-align:center">出品中</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/onSaleList'">確認</button></td>
			</tr>
			<tr>
				<td><p style="text-align:center">入金情報</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/deposit'">入金情報</button></td>
			</tr>
			<tr>
				<td><p style="text-align:center">購入履歴</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/purchaseHistory'">購入履歴</button></td>
			</tr>
			<tr>
				<td><p style="text-align:center">メッセージ</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/userMessage'">確認</button></td>
			</tr>
			<tr>
				<td><p style="text-align:center">ユーザー情報編集</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/userEdit'">編集</button></td>
			</tr>
			<tr>
				<td><p style="text-align:center">退会</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/withdrawal'">退会</button></td>
			</tr>
		</table>
	</div>
</div>

<%@include file="/common/footer.jsp"%>
</body>
</html>