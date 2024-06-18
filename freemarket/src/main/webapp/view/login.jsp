<%@page contentType="text/html; charset=UTF-8"%>


  <html lang="ja">
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
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

<div class="login-container">
  <form action="<%=request.getContextPath()%>/login" method="post">
    <div class="form-group">
      <label for="username">メールアドレス</label>
      <input type="text" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="password">パスワード</label>
      <input type="password" id="password" name="password" required>
    </div>
    <button type="submit">ログイン</button>
    <a href="signup.html"><p>会員登録</p></a>
  </form>
</div>

<footer class="footer">
  <p class="copyright">© 2024  フリーマーケット. All Rights Reserved.</p>
</footer>
</body>
</html>