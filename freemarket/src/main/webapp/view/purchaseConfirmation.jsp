<%@page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.ArrayList,bean.ProductionInfo,bean.LoginInfo,servlet.PurchaseConfirmationServlet"%>
<%
ProductionInfo production = (ProductionInfo) session.getAttribute("productInfo");
%>


<html>

<head>
<meta charset="UTF-8">
<title>購入確認</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">

</head>

<body class="login">
	<%@ include file = "/common/header.jsp" %>
	<div class="buy_confirm">
		<div id="buy_confirm_picture">
			<img src="<%=production.getPicture()%>" height="400" width="400">
		</div>
		<div id="buy_confirm_description">
			<h1><%= production.getProduct() %></h1>
			<h2><%= production.getSelling_price() %></h2>
			<h2>この商品を購入しました。</h2>
		</div>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>
