<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.ProductionInfo,servlet.OnSaleListServlet"%>

<%
//OnSaleListServletでリクエストスコープに登録した書籍情報を取得
ArrayList<ProductionInfo> productsList = (ArrayList<ProductionInfo>) request.getAttribute("products_list"); 
%>

<html>
<head>
<meta charset="UTF-8">
<title>出品中の一覧</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
<header>
    <div id="title">
        <h2>フリーマーケット</h2>
    </div>
    <div class="menu">
        <nav class="stroke">
            <ul>
                <li><a href="<%=request.getContextPath()%>/productList">商品一覧</a></li>
                <li><a href="<%=request.getContextPath()%>/userInformation">ユーザー情報</a></li>
                <li><a href="<%=request.getContextPath()%>/view/productInsert.jsp">商品登録</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="listing_product_list">
	<div>
		<h1>
			出品中の商品一覧		
		</h1>
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
				<td><img src="./img/image1.jpeg" width="200" height="200" alt="" /></td>
				<td><p><%=product.getProduct()%></p></td>
				<td><h2><%=product.getSelling_price()%></h2></td>
				<td><a
				href="<%=request.getContextPath()%>/onSaleDetail?product_id=<%=product.getProduct_id()%>&cmd=onSaleDetail">詳細</a></td>
			</tr>
			
			<%
					}
					}
					%>
		</table>
	</div>
</div>

<footer class="footer">
  <p class="copyright">© 2024  フリーマーケット. All Rights Reserved.</p>
</footer>
</body>
</html>
