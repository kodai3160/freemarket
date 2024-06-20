<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.ProductionInfo"%>

<head>
<title>入金情報</title>
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
                <li><a href="./product_list.html">商品一覧</a></li>
                <li><a href="./user_info.html">ユーザー情報</a></li>
                <li><a href="./product_insert.html">商品登録</a></li>
            </ul>
        </nav>
    </div>
</header>

<div class="product_buy_history">
	<div>
		<h1>
			入金情報	
		</h1>
		<h2>合計:金額</h2>
	</div>
	
	<div>
		<table style="width: 100%;">
			<tr>
				<td><h2>画像</h2></td>
				<td><h2>商品名</h2></td>
				<td><h2>価格</h2></td>
				<td><h2>入金状態 1:入金済み 2:未入金</h2></td>
				<td><h2>入金状態変更</h2></td>
				<td>&nbsp</td>
			</tr>
		</table>
			<%
			//DepositServletでリクエストスコープに登録した商品情報を取得します。
			ArrayList<ProductionInfo> list =(ArrayList<ProductionInfo>)request.getAttribute("product_list");
			//取得した商品情報をループ処理を利用し画面に表示します。
			if(list != null){
				for(int i=0;i<list.size();i++){
					ProductionInfo product = list.get(i);
				
			%>
			<table style="width: 100%;">
			<tr>
					<td><img src="./img/image1.jpeg" width="200" height="200" alt="" /></td>
					<td><p>商品名：<%=product.getProduct()%></p></td>
					<td><p>価格：<%=product.getSelling_price()%></p></td>
					<td><p>入金状態：<%=product.getDeposit_status()%></p></td>
					<td style="text-align:left; width:125px">
						<a href="<%=request.getContextPath()%>/depositChange?product_id=<%=product.getProduct_id() %>&deposit_status=1">入金済み</a>
					</td>
					<td style="text-align:left; width:125px">
						<a href="<%=request.getContextPath()%>/depositChange?product_id=<%=product.getProduct_id() %>&deposit_status=0">未入金</a>
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
  <p class="copyright">© 2024  フリーマーケット. All Rights Reserved.</p>
</footer>
</body>
</html>