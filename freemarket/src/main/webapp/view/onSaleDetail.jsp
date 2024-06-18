<%@page contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<title>商品の詳細</title>
	</head>

	<body class="login">
		<header>
			<div id="title">
				<h2>フリーマーケット</h2>
			</div>

			<table style="margin: auo; width: 800px;">
				<td><a href="./product_list.html">商品一覧</a></td>
				<td><a href="./user_info.html">ユーザー情報</a></td>
				<td><a href="./product_insert.html">商品登録</a></td>
			</table>
		</header>

	<tr>

		<img src="./img/image1.jpeg" width="400" height="400" alt="" />

			<div id="detail_description">
				<h1>商品名</h1>
				<h2>価格</h2>
				<h2>出品地域</h2>
				<p>商品説明</p>
				<h3>ユーザーの情報</h3>
				<button type="submit" onclick="location.href='./product_buy.html'">購入</button>
			</div>
		
	</tr>


		<footer class="footer">
			<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
		</footer>
	</body>

</html>