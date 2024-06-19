<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.ProductionInfo"%>

<%
ProductionInfo production = (ProductionInfo) session.getAttribute("productInfo");
%>

<head>
<title>商品の詳細</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body class="login">
	<%@include file="/common/header.jsp"%>
	<%@include file="/common/userinfo.jsp"%>
	<div class="detail">
		<div id="detail_picture">
			<img src="./img/image1.jpeg" width="400" height="400" alt="" />
		</div>
		<div id="detail_description">
			<h1>
				商品名：<%=production.getProduct()%></h1>
			<h2>
				料金：<%=production.getSelling_price()%></h2>
			<p>
				商品詳細：<%=production.getItem_description()%></p>
			<h2>
				商品状態：<%=production.getItem_condition()%></h2>
			<h2>
				使用回数：<%=production.getUses_number()%></h2>
			<h2>
				色：<%=production.getColor()%></h2>
			<h2>
				サイズ：<%=production.getSize()%></h2>
			<button type="submit" onclick="location.href='<%=request.getContextPath()%>/purchase'">購入</button>
		</div>
	</div>

	<%@include file="/common/footer.jsp"%>
</body>

</html>