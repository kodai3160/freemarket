<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.ProductionInfo"%>

<head>
<title>入金情報</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<%@include file="/common/header.jsp"%>
	<div class="product_buy_history">
		<div>
			<h1>入金情報</h1>
		</div>

		<div>
			<table style="width: 100%;">
				<tr>
					<td><h2>画像</h2></td>
					<td><h2>商品名</h2></td>
					<td><h2>価格</h2></td>
					<td><h2>入金状態</h2></td>
					<td><h2>入金状態変更</h2></td>
					<td>&nbsp</td>
				</tr>
			</table>
			<%
			//DepositServletでリクエストスコープに登録した商品情報を取得します。
			ArrayList<ProductionInfo> list = (ArrayList<ProductionInfo>) request.getAttribute("product_list");
			//取得した商品情報をループ処理を利用し画面に表示します。
			if (list != null) {
				for (int i = 0; i < list.size(); i++) {
					ProductionInfo product = list.get(i);
			%>
			<table style="width: 100%;">
				<tr>
					<td><img src="<%=product.getPicture()%>" height="200" width="200"></td>
					<td><p>
							商品名：<%=product.getProduct()%></p></td>
					<td><p>
							価格：<%=product.getSelling_price()%></p></td>
					<% if(product.getDeposit_status().equals("0")) { %>
					<td><p> 未入金</p></td>
					<% } %>
					<% if(product.getDeposit_status().equals("1")) { %>
					<td><p> 入金済</p></td>
					<% } %>
					<td style="text-align: left; width: 125px">
					<form method="post" action="<%=request.getContextPath()%>/depositChange" name="yes">
						<button type="submit">入金済み</button>
						<input type="hidden" name="product_id" value="<%=product.getProduct_id()%>">
						<input type="hidden" name="deposit_status" value="1">
					</form>
					</td>
					<td style="text-align: left; width: 125px">
					<form method="post" action="<%=request.getContextPath()%>/depositChange" name="no">
						<button type="submit">未入金</button>
						<input type="hidden" name="product_id" value="<%=product.getProduct_id()%>">
						<input type="hidden" name="deposit_status" value="0">
					</form>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<%
	}
	}
	%>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>
</html>