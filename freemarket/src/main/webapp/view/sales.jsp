<%@page contentType="text/html; charset=UTF-8"%>

<head>
	<title>サンプル</title>
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
					<li><a href="./userList.html">ユーザー一覧</a></li>
					<li><a href="./listingUserList.html">出品者一覧</a></li>
					<li><a href="./earning.html">売上確認</a></li>
					<li><a href="./contact.html">問い合わせ</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<div class="withdrawal">
		<h1>売上合計金額：金額</h1>
		<button type="submit" onclick="location.href='./menu.html'">戻る</button>
	</div>
	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>