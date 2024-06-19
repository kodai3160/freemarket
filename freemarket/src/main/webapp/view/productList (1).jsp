<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,bean.ProductionInfo" %>

<%
ArrayList<ProductionInfo> productsList = (ArrayList<ProductionInfo>)request.getAttribute("products_list");
ProductionInfo productionInfo = new ProductionInfo();
%>

<html>
	<head>
		<title>商品一覧</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	
	<body>
		<%@ include file = "/common/header.jsp" %>
		<div>
			<form method="get" action="#" class="search_container">
				<input type="text" size="25" placeholder="キーワード検索">
				<input type="submit" value="&#xf002">
			</form>
		</div>
		<div>
		<%
		if((productsList != null)){
			for(int i = 0; i < productsList.size(); i++){ 
		%>
			<ul>
				<%
				for(int j = 0; j < 3;j++){ 
				%>
					<li><a href="<%=request.getContextPath()%>/productDetail"><%= productionInfo.getPicture() %> </a></li>
				<%
				} 
				%>
			</ul>
		<%
			}
		}
		%>
		</div>
		<%@ include file = "/common/footer.jsp" %>
	</body>
</html>
