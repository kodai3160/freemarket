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
<%@include file="/common/userInfo.jsp" %>
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
		<table style="width: 100%;">
			<tr>
				<td><p>出品中</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/onSaleList.jsp'">確認</button></td>
			</tr>
			<tr>
				<td><p>入金情報</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/deposit.jsp'">入金情報</button></td>
			</tr>
			<tr>
				<td><p>購入履歴</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/purchaseHistory.jsp'">購入履歴</button></td>
			</tr>
			<tr>
				<td><p>メッセージ</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/userMessage.jsp'">確認</button></td>
			</tr>
			<tr>
				<td><p>ユーザー情報編集</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/userEdit.jsp'">編集</button></td>
			</tr>
			<tr>
				<td><p>退会</p></td>
				<td><button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/withdrawal.jsp'">退会</button></td>
			</tr>
		</table>
	</div>
</div>

<%@include file="/common/footer.jsp"%>
</body>
</html>