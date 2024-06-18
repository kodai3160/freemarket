<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="bean.LoginInfo"%>
<%
LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");

//権限の設定
String authority = null;
if (loginInfo.getLoginFlag().equals("0")) {
	authority = "会員";
} else if (loginInfo.getLoginFlag().equals("1")) {
	authority = "管理者";
}
%>

<div id="user_info">
	<ul>
		<li>名前:<%=loginInfo.getUserId()%></li>
		<li>権限:<%=authority%></li>
	</ul>
</div>