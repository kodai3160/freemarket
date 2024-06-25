<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.ProductionInfo"%>

<%
ProductionInfo production = (ProductionInfo) request.getAttribute("productid");
%>

<head>
<title>商品の詳細</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body class="login">
	<%@include file="/common/header.jsp"%>
	<div class="detail">
		<div id="detail_picture">
			<img src="<%=production.getPicture()%>" height="400" width="400">
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
			<% if(production.getShipping_status_flag().equals("0")){ %>
			<h2>発送状況:未発送</h2>
			<% } %>
			<% if(production.getShipping_status_flag().equals("1")){ %>
			<h2>発送状況:発送済</h2>
			<% } %>
			<%
			if (!authority.equals("：管理者")) {
			%>
			<h2>
				発送状況変更
				<td style="text-align: left; width: 125px">
					<form method="post"
						action="<%=request.getContextPath()%>/shippingChange">
						<input type="hidden" name="product_id"
							value="<%=production.getProduct_id()%>"> <input
							type="hidden" name="shipping_status_flag" value="1">
						<button type="submit">発送済み</button>
					</form>

				</td>
				<td style="text-align: left; width: 125px">
					<form method="post"
						action="<%=request.getContextPath()%>/shippingChange">
						<input type="hidden" name="product_id"
							value="<%=production.getProduct_id()%>"> <input
							type="hidden" name="shipping_status_flag" value="0">
						<button type="submit">未発送</button>
					</form>

				</td>
			</h2>
			<h2>商品情報変更</h2>
			<form method="post" action="<%=request.getContextPath()%>/onSaleEdit">
				<input type="hidden" name="product_id"
					value="<%=production.getProduct_id()%>"> <input
					type="hidden" name="check" value="init">
				<button type="submit">変更</button>
			</form>
			<%
			}
			%>
		</div>
	</div>

	<%@ include file="/common/footer.jsp"%>
</body>

</html>