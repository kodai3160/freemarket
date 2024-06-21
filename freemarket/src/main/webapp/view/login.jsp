<%@page contentType="text/html; charset=UTF-8"%>
<%
String email = "";
String pass = "";
String message = (String) request.getAttribute("message");
Cookie[] userCookie = request.getCookies();
if (userCookie != null) {
	for (int i = 0; i < userCookie.length; i++) {
		if (userCookie[i].getName().equals("email")) {
			email = userCookie[i].getValue();
		}
		if (userCookie[i].getName().equals("password")) {
			pass = userCookie[i].getValue();
		}
	}
}
if (message == null) {
	message = "";
}
%>

<head>
<title>ログイン</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<header>
		<div id="title">
			<h2>フリーマーケット</h2>
		</div>
		<div style="color: red">
			<%=message%>
		</div>
		<div class="login-container">
			<form action="<%=request.getContextPath()%>/login" method="post">
				<div class="form-group">
					<label for="username">メールアドレス</label> <input type="text" id="email"
						name="email" value="<%=email%>" required>
				</div>
				<div class="form-group">
					<label for="password">パスワード</label> <input type="password"
						id="password" name="password" value="<%=pass%>" required>
				</div>
				<button type="submit">ログイン</button>
			</form>
			<form method="post"
				action="<%=request.getContextPath()%>/membership"
				name="membership_form">
				<a href="#" onclick="document.membership_form.submit()">会員登録</a>
				<input type="hidden" name="check" value="init">
			</form>
		</div>

		<%@include file="/common/footer.jsp"%>
</body>
</html>