<%@page contentType="text/html; charset=UTF-8" %>

<link rel ="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<header>
    <div id="title">
        <h2>フリーマーケット</h2>
    </div>
    <div class="menu">
        <nav class="stroke">
            <ul>
                <li><a href="<%=request.getContextPath()%>/productList">商品一覧</a></li>
				<li><a href="<%=request.getContextPath()%>/userInformation">ユーザー情報</a></li>
                <li><a href="<%=request.getContextPath()%>/productInsert">商品登録</a></li>
            </ul>
        </nav>
    </div>
</header>