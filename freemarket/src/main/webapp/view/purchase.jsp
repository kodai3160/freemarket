<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,bean.ProductionInfo" %>

<%
ProductionInfo production = (ProductionInfo) session.getAttribute("productInfo");
%>


<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>購入</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>

<body class="login">
	<%@ include file = "/common/header.jsp" %>
	<div class="buy">
		<div id="buy_picture">
			<img src="./img/image1.jpeg" width="400" height="400" alt="" />
		</div>
		<div id="buy_description">
			<h1>商品名：<%=production.getProduct()%></h1>
			<h2>料金：<%=production.getSelling_price()%></h2>
			<div>
				<button type="submit" onclick="location.href='<%=request.getContextPath()%>/purchaseConfirmation'">購入</button>
				<button type="submit" onclick="history.back()">戻る</button>
			</div>
		</div>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>