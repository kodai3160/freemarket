<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.ProductionInfo"%>

<%
ArrayList<ProductionInfo> productsList = (ArrayList<ProductionInfo>) request.getAttribute("products_list");
%>

<html>
<head>
<title>商品一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body>
	<%@ include file="/common/header.jsp"%>
	<div>
		<form method="get" action="#" class="search_container">
			<input type="text" size="25" placeholder="キーワード検索"> <input
				type="submit" value="検索">
		</form>
	</div>
	<div>
		<%
		int count = 0;
		if ((productsList != null)) {
			for (int i = 0; i < productsList.size(); i++) {
				ProductionInfo productionInfo = productsList.get(i);
				if (count == 0) {
		%>
		<ul>
			<%
			}
			count++;
			%>
			<%
			for (int j = 0; j < 1; j++) {
			%>
			<li>
				<form method="post"
					action="<%=request.getContextPath()%>/productDetail" class="list_form">
					<button type="submit"> <img src="<%=productionInfo.getPicture()%>" height="300" width="300"></button>
					<input type="hidden" name="product_id" value="<%=productionInfo.getProduct_id()%>">
				</form>
			</li>
			<%
			}
			if (count > 2) {
			count = 0;
			%>
		</ul>
		<%
		}
		%>
		<%
		}

		}
		%>
	</div>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>
