<%@page contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.ArrayList,bean.MemberInfo,servlet.UserListServlet"%>

<%
ArrayList<MemberInfo> memberList = (ArrayList<MemberInfo>) request.getAttribute("memberList");
%>

<html>
<head>
<title>ユーザー一覧</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="login">
	<%@include file="/common/header.jsp"%>

	<table>
		<tr>
			<th width="200">ID
			</td>
			<th width="200">氏名
			</td>
		</tr>
		<%
		if (memberList != null) {
			for (int i = 0; i < memberList.size(); i++) {
				MemberInfo memberInfo = (MemberInfo) memberList.get(i);
		%>

		<tr>
			<td><a
				href="<%=request.getContextPath()%>/userDetail?user_id=<%=memberInfo.getUser_id()%>&cmd=userDetail"><%=memberInfo.getUser_id()%></a></td>
			<td><%=memberInfo.getSurname()%><%=memberInfo.getName()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>

	</div>
	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>

</body>
</html>