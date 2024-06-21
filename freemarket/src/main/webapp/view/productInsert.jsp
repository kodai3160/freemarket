<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,servlet.ProductInsertServlet"%>

<html>

<head>
	<meta charset="UTF-8">
	<title>商品の登録</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
	
</head>

<body class="login">
	<%@ include file="/common/header.jsp"%>
	<div class="insert">
	<form action="<%=request.getContextPath()%>/productInsert" method="POST" enctype="multipart/form-data">
		<table class="insert_table">
			<tr>
				<td>
					<p>商品名</p>
				</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>
					<p>価格</p>
				</td>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<td>
					<p>カテゴリ</p>
				</td>
				<td><input type="text" name="category"></td>
			</tr>
			<tr>
				<td>
					<p>状態</p>
				</td>
				<td><input type="text" name="condition"></td>
			</tr>
			<tr>
				<td>
					<p>使用回数</p>
				</td>
				<td><input type="text" name="num"></td>
			</tr>
			<tr>
				<td>
					<p>色</p>
				</td>
				<td><input type="text" name="color"></td>
			</tr>
			<tr>
				<td>
					<p>サイズ</p>
				</td>
				<td><input type="text" name="size"></td>
			</tr>
			<tr>
				<td>
					<p>配送方法</p>
				</td>
				<td><input type="text" name="delivery"></td>
			</tr>
			<tr>
				<td>
					<p>発送までに予定日数</p>
				</td>
				<td><input type="text" name="delivery_days"></td>
			</tr>
			<tr>
				<td>
					<p>発送地域</p>
				</td>
				<td><input type="text" name="region"></td>
			</tr>
			<tr>
				<td>
					<p>写真</p>
				</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td>
					<p>商品説明</p>
				</td>
				<td><textarea name="description"></textarea></td>
			</tr>
		</table>
		<button type="submit">登録</button>
		<input type="hidden" name="check" value="insert">
	</form>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>