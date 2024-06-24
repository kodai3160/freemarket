<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.ProductionInfo"%>
<%
int sales = 0;
%>
<html>
<head>
<title>売上げ確認</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>

<body class="login">
	<%@include file="/common/header.jsp"%>

	<%
	//SalesServletでリクエストスコープに登録した商品情報を取得します。
	ArrayList<ProductionInfo> list = (ArrayList<ProductionInfo>) request.getAttribute("product_List");
	//取得した商品情報をループ処理を利用し画面に表示します。
	if (list != null) {
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			ProductionInfo product = list.get(i);
			total+=Integer.parseInt(product.getSelling_price());
		}
		sales = (int)(total*0.1);
	}
	%>
	<div class="withdrawal">
		<h1>売上合計金額：<%=sales %>円</h1>
		<button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/menu.jsp'">戻る</button>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>

</html>