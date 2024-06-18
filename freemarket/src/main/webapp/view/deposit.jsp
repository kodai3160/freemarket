<%@page contentType="text/html; charset=UTF-8"%>

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
				<td></td>
			</tr>
			<tr>
				<td><img src="./img/image1.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</p></td>
			</tr>
			<tr>
				<td><img src="./img/image2.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</p></td>
			</tr>
			<tr>
				<td><img src="./img/image3.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</h2></td>
			</tr>
			<tr>
				<td><img src="./img/image4.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</h2></td>
			</tr>
			<tr>
				<td><img src="./img/image5.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</h2></td>
			</tr>
			<tr>
				<td><img src="./img/image6.jpeg" width="200" height="200" alt="" /></td>
				<td><p>商品名</p></td>
				<td><p>価格</h2></td>
			</tr>
		</table>
	</div>
</div>

<footer class="footer">
  <p class="copyright">© 2024  フリーマーケット. All Rights Reserved.</p>
</footer>
</body>
</html>