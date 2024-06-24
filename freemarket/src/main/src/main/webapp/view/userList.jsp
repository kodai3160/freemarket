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
	<div class="user">
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
				<td class="user_id"><%=memberInfo.getUser_id()%></td>
				<td><%=memberInfo.getSurname()%><%=memberInfo.getName()%></td>
				<td style="width: 100px;">
					<form method="post"
						action="<%=request.getContextPath()%>/userDetail">
						<input type="hidden" name="user_id"
							value="<%=memberInfo.getUser_id()%>"> <input
							type="hidden" name="cmd" value="userDetail">
						<button type="submit">詳細</button>
					</form>
				</td>
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