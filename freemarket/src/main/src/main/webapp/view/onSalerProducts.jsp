<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList,bean.ProductionInfo" %>

<%
ArrayList<ProductionInfo> productsList = (ArrayList<ProductionInfo>)request.getAttribute("products_list");
%>

<html>
	<head>
		<title>出品者商品一覧</title>
		<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/style.css">
	</head>
	
	<body>
		<%@ include file = "/common/header.jsp" %>
		<div>
		<%
		if((productsList != null)){
			for(int i = 0; i < productsList.size(); i++){ 
				ProductionInfo productionInfo = productsList.get(i);
		%>
			<ul>
				<%
				for(int j = 0; j < 3;j++){ 
					
				%>
					<li><%= productionInfo.getPicture() %></li>
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