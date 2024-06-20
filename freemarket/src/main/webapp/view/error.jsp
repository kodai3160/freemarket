<%@page contentType="text/html; charset=UTF-8"%>

<%
String error = (String) request.getAttribute("error");
%>
<head>
	<title>エラー</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
</head>

<body class="login">
<%@include file="/common/header.jsp"%>
	<div class="withdrawal">
		<h1 style="color:red">エラー</h1>
		<h3><%=error %></h3>
		<button type="submit" onclick="location.href='<%=request.getContextPath()%>/view/login.jsp'">ログインに戻る</button>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>

</html>