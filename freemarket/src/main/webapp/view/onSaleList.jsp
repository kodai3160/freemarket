<%@page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.ArrayList,bean.ProductionInfo,servlet.OnSaleListServlet"%>

<%
//OnSaleListServletでリクエストスコープに登録した書籍情報を取得
ArrayList<ProductionInfo> productsList = (ArrayList<ProductionInfo>) request.getAttribute("products_list");
%>

<html>
<head>
<meta charset="UTF-8">
<title>出品中の一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<%@include file="/common/header.jsp"%>
	<div class="listing_product_list">
		<div>
			<h1>出品中の商品一覧</h1>
		</div>
		<div>
			<table style="width: 100%;">
				<tr>
					<td><h2>画像</h2></td>
					<td><h2>商品名</h2></td>
					<td><h2>価格</h2></td>
					<td></td>
				</tr>


				<%
				//取得した商品情報をループ処理を利用し画面に表示
				if (productsList != null) {
					for (int i = 0; i < productsList.size(); i++) {
						ProductionInfo product = (ProductionInfo) productsList.get(i);
				%>


				<tr>
					<td><img src="<%=product.getPicture()%>" height="200" width="200"></td>
					<td><p><%=product.getProduct()%></p></td>
					<td><h2><%=product.getSelling_price()%></h2></td>
					<td>
						<form method="post"
							action="<%=request.getContextPath()%>/onSaleDetail"
							name="saler_form">
							<button type="submit">詳細</button>
							<input type="hidden" name="product_id"
								value="<%=product.getProduct_id()%>"> <input
								type="hidden" name="cmd" value="onSaleDetail">
						</form>
					</td>
				</tr>

				<%
				}
				}
				%>
			</table>
		</div>
	</div>

	<%@ include file="/common/footer.jsp"%>
</body>
</html>
