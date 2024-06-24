<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,bean.MemberInfo"%>

<%
//UserDetailServletでリクエストスコープに登録したユーザー情報を取得
MemberInfo memberInfo = (MemberInfo) request.getAttribute("memberInfo");
%>

<html>
<title>ユーザー詳細</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">

</head>
<body>
	<%@ include file="/common/header.jsp"%>
	<div class="user">
		<table>
			<tbody>
				<tr>
					<th>会員ID</th>
					<td><%=memberInfo.getMember_id()%></td>
				</tr>
				<tr>
					<th>姓</th>
					<td><%=memberInfo.getSurname()%></td>
				</tr>
				<tr>
					<th>姓（かな）</th>
					<td><%=memberInfo.getKana_surname()%></td>
				</tr>
				<tr>
					<th>名</th>
					<td><%=memberInfo.getName()%></td>
				</tr>
				<tr>
					<th>名（かな）</th>
					<td><%=memberInfo.getKana_name()%></td>
				</tr>
				<tr>
					<th>ニックネーム</th>
					<td><%=memberInfo.getNickname()%></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><%=memberInfo.getTel()%></td>
				</tr>
				<tr>
					<th>年齢</th>
					<td><%=memberInfo.getAge()%></td>
				</tr>
				<tr>
					<th>生年月日</th>
					<td><%=memberInfo.getBirth_date()%></td>
				</tr>
				<tr>
					<th>都道府県</th>
					<td><%=memberInfo.getPrefectures()%></td>
				</tr>
				<tr>
					<th>都道府県(かな）</th>
					<td><%=memberInfo.getKana_prefectures()%></td>

				</tr>
				<tr>
					<th>市町村</th>
					<td><%=memberInfo.getMunicipality()%></td>

				</tr>
				<tr>
					<th>市町村（かな）</th>
					<td><%=memberInfo.getKana_municipality()%></td>

				</tr>
				<tr>
					<th>番地</th>
					<td><%=memberInfo.getStreet_address()%></td>
				</tr>
				<tr>
					<th>建物名</th>
					<td><%=memberInfo.getBuilding_name()%></td>
			</tbody>
		</table>
	</div>
	<div>
		<form method="post" action="<%=request.getContextPath()%>/onSaleList">
			<button type="submit">出品一覧表示</button>
			<input type="hidden" name="member_id"
				value="<%=memberInfo.getMember_id()%>">
		</form>
	</div>
	<footer class="footer">
		<p class="copyright">© 2024 フリーマーケット. All Rights Reserved.</p>
	</footer>
</body>
</html>

