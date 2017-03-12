<%@page import="backend.core.AbstractGameServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tie" uri="WEB-INF/custom.tld"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String template = (String) pageContext.getRequest().getAttribute("template");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/base.css" type="text/css" rel="stylesheet" />
	<link href="css/<%=template %>.css" type="text/css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/mustache.js"></script>
	<script type="text/javascript" src="js/global.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/<%=template %>.js"></script>

	<title><tie:print value="title" /></title>
</head>
<body>
	
	<%
		template = "templates/" + template + ".jsp";
	%>
	
	
	<div class="app-wrapper">
		<div class="header cf ">
			<%
				String gameName = (String) pageContext.getRequest().getAttribute(AbstractGameServlet.gameName);
				if(gameName != null && !gameName.equals("")) {
			%>
				<div class="headline-container">
					<%=gameName %>
				</div>
			<%
				}
			%>
			<div class="button-container">
				<a class="logout-button global-button-1">
					<tie:prop key="common.logout" />
				</a>
			</div>
		</div>
		
		<!-- Main Content Begin -->
		<jsp:include page="<%=template  %>" />
		<!-- Mein Content End -->	
	</div>
</body>
</html>