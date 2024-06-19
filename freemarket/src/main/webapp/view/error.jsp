<%@page contentType="text/html; charset=UTF-8"%>

<%
String message = (String) request.getAttribute("message");
String cmd = (String) request.getAttribute("cmd");
%>

<html>
<head>
<title>Error</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div style="text-align: center">
		<p>●●エラー●●</p>
		<p style="color:red"><%=message%></p>
		<%
		if (cmd.equals("menu")) {
		%>
		<p><a href="<%=request.getContextPath()%>/view/menu.jsp">[メニューに戻る]</a></p>
		<%
		} else if (cmd.equals("logout")) {
		%>
		<p><a href="<%=request.getContextPath()%>/logout">[ログイン画面に戻る]</a></p>
		<%
		} else {
		%>
		<p><a href="<%=request.getContextPath()%>/list">[一覧表示に戻る]</a></p>
		<%
		}
		%>
	</div>
	<div style="margin-top: 460;">
		<%@include file="/common/footer.jsp"%>
	</div>
</body>
</html>