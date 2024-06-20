<%@page contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html lang="ja">

<head>
	<meta charset="UTF-8">
	<title>会員登録</title>
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
					<li><a href="<%=request.getContextPath() %>/productList">商品一覧</a></li>
					<li><a href="<%=request.getContextPath() %>/userList">ユーザー情報</a></li>
					<li><a href="<%=request.getContextPath() %>/productInsert">商品登録</a></li>
				</ul>
			</nav>
		</div>
	</header>

	<div class="user" style="text-align: center;">
		<h2>会員登録</h2>
		
		<table style="margin: auto;">
			
			<tr>
				<td>
					<label for="email">メールアドレス:</label>
				</td>
				<td>
					<input type="text" id="email" name="email" placeholder="example@example.com" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">パスワード:</label>
				</td>
				<td>
					<input type="password" id="password" name="password" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name">生年月日:</label>
				</td>
				<td>

					<input type="date" id="date" name="calendar">
				</td>
			</tr>
			<tr>
				<td>

					<label for="phone">電話番号:</label>
				</td>
				<td>
					<input type="text" id="phone" name="phone" placeholder="012-3456-7890" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name" style="text-align: left;">姓:</label>
					<input type="text" id="family_name" name="surname" placeholder="山田" required>
				</td>
				<td>
					<label for="name" style="text-align: left;">名:</label>
					<input type="text" id="personal_name" name="name" placeholder="太郎" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="name" style="text-align: left;">姓(かな):</label>
					<input type="text" id="family_name_kana" name="kana_surname" placeholder="やまだ" required>
				</td>
				<td>
					<label for="name" style="text-align: left;">名(かな):</label>
					<input type="text" id="personal_name_kana" name="kana_name" placeholder="たろう" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="zipCode">郵便番号:</label>
				</td>
				<td>
					<input type="text" id="zipCode" name="zipCode" placeholder="〒123-4567" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="prefectures">都道府県:</label>
				</td>
				<td>
					<input type="text" id="prefectures" name="prefectures" placeholder="東京都" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="prefectures_kana">都道府県(かな):</label>
				</td>
				<td>
					<input type="text" id="prefectures_kana" name="kana_prefectures" placeholder="とうきょうと" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="city">市区町村:</label>
				</td>
				<td>
					<input type="text" id="city" name="municipality" placeholder="千代田区" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="city_kana">市区町村(かな):</label>
				</td>
				<td>
					<input type="text" id="city_kana" name="kana_municipality" placeholder="ちよだく" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="town">町名:</label>
				</td>
				<td>
					<input type="text" id="town" name="chou_name" placeholder="千代田" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="town_kana">町名(かな):</label>
				</td>
				<td>
					<input type="text" id="town_kana" name="kana_chou" placeholder="ちよだ" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="street">番地:</label>
				</td>
				<td>
					<input type="text" id="street" name="street_adress" placeholder="1-1-1" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="building">建物名:</label>
				</td>
				<td>
					<input type="text" id="building" name="building" placeholder="" required>
				</td>
			</tr>
			<tr>
				<td>
					<label for="building_kana">建物名(かな):</label>
				</td>
				<td>
					<input type="text" id="building_kana" name="building_kana" placeholder="" required>
				</td>
			</tr>
		</table>
		<form action="<%=request.getContextPath() %>/view/login.jsp">
		<button type="submit">登録</button>
		</form>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>