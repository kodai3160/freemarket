<%@page contentType="text/html; charset=UTF-8"%>



<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<title>ユーザーメッセージ</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
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

	<div class="user_message">
		<h1>メッセージ</h1>
		<div id="your_container">

			<!-- チャットの外側部分① -->
			<div id="bms_messages_container">
				<!-- タイムライン部分③ -->
				<div id="bms_messages">

					<!--メッセージ１（左側）-->
					<div class="bms_message bms_left">
						<div class="bms_message_box">
							<div class="bms_message_content">
								<div class="bms_message_text">相手側のメッセージ</div>
							</div>
						</div>
					</div>
					<div class="bms_clear"></div>
					<!-- 回り込みを解除（スタイルはcssで充てる） -->

					<!--メッセージ２（右側）-->
					<div class="bms_message bms_right">
						<div class="bms_message_box">
							<div class="bms_message_content">
								<div class="bms_message_text">自分側のメッセージ</div>
							</div>
						</div>
					</div>
					<div class="bms_clear"></div>
					<!-- 回り込みを解除（スタイルはcssで充てる） -->
					<!--メッセージ１（左側）-->
					<div class="bms_message bms_left">
						<div class="bms_message_box">
							<div class="bms_message_content">
								<div class="bms_message_text">相手側のメッセージ</div>
							</div>
						</div>
					</div>
					<div class="bms_clear"></div>
					<!-- 回り込みを解除（スタイルはcssで充てる） -->

					<!--メッセージ２（右側）-->
					<div class="bms_message bms_right">
						<div class="bms_message_box">
							<div class="bms_message_content">
								<div class="bms_message_text">自分側のメッセージ</div>
							</div>
						</div>
					</div>
					<div class="bms_clear"></div>
					<!-- 回り込みを解除（スタイルはcssで充てる） -->

				</div>

				<!-- テキストボックス、送信ボタン④ -->
				<form action="<%=request.getContextPath()%>/userMessage"
					method="POST">
					<div id="bms_send">
						<textarea id="bms_send_message"></textarea>
						<div id="bms_send_btn">
							<button type="submit">送信</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>

</html>