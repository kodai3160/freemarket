<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.ProductionInfo"%>

<%
ProductionInfo production = (ProductionInfo) request.getAttribute("productid");
%>

<head>
	<title>商品の詳細</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
</head>

<body class="login">
	<header>
		<div id="title">
			<h2>フリーマーケット</h2>
		</div>
		<div class="menu">
			<nav class="stroke">
				<ul>
					<li><a href="<%=request.getContextPath() %>/productList">商品一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/userInformation">ユーザー情報</a></li>
					<li><a href="<%=request.getContextPath() %>/view/productInsert.jsp">商品登録</a></li>
				</ul>
			</nav>
		</div>
	</header>


	<div class="detail">
		<div id="detail_picture">
			<img src="./img/image1.jpeg" width="400" height="400" alt="" />
		</div>
		<div id="detail_description">
			<h1>商品名：<%=production.getProduct()%></h1>
			<h2>料金：<%=production.getSelling_price()%></h2>
			<p>商品詳細：<%=production.getItem_description()%></p>
			<h2>商品状態：<%=production.getItem_condition()%></h2>
			<h2>使用回数：<%=production.getUses_number()%></h2>
			<h2>色：<%=production.getColor()%></h2>
			<h2>サイズ：<%=production.getSize()%></h2>
			<h2>発送状況 0:未発送 1:発送済み</h2>
			<h2><%=production.getShipping_status_flag()%></h2>
			<h2>発送状況変更
			<td style="text-align:left; width:125px">
				<a href="<%=request.getContextPath()%>/shippingChange?product_id=<%=production.getProduct_id() %>&shipping_status_flag=1">発送済み</a>
			</td>
			<td style="text-align:left; width:125px">
				<a href="<%=request.getContextPath()%>/shippingChange?product_id=<%=production.getProduct_id() %>&shipping_status_flag=0">未発送</a>
			</td>
			</h2>
			<button type="submit" onclick="location.href='./product_buy.html'">購入</button>
		</div>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>