<%@page contentType="text/html; charset=UTF-8"%>

<%
String product_id = (String) request.getAttribute("product_id");
%>


<html>
<head>
<title>商品情報編集</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<%@ include file="/common/header.jsp"%>

	<div class="listing_product_change">
		<form method="post" action="<%=request.getContextPath()%>/onSaleEdit" enctype="multipart/form-data">
			<table class="listing_product_change_table">
				<tr>
					<td>
						<p>商品名</p>
					</td>
					<td><input type="text" name="product"></td>
				</tr>
				<tr>
					<td>
						<p>価格</p>
					</td>
					<td><input type="text" name="selling_price"></td>
				</tr>
				<tr>
					<td>
						<p>出品地域</p>
					</td>
					<td><input type="text" name="origin_region"></td>
				</tr>
				<tr>
					<td>
						<p>商品説明</p>
					</td>
					<td><textarea name="item_description" rows="3" cols="45"></textarea></td>
				</tr>
				<tr>
					<td>
						<p>画像</p>
					</td>

					<td><input type="file" name="image"></td>
				</tr>
			</table>
			<input type="hidden" name="check" value="update">
			<input type="hidden" name="product_id" value="<%= product_id %>">
			<button type="submit">変更</button>
		</form>
	</div>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>