<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.online.util.UtilConstants"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'index.jsp' starting page</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>
	<body onload="Carousel()">
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="HomeMenu.jsp"></jsp:include>
		<%
			if (request.getAttribute(UtilConstants._STATUS) != null) {
		%>
		<center>
			<strong><font color=red><%=request.getAttribute(UtilConstants._STATUS)%></font>
			</strong>


			<%
				}
			%>
		</center>

<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>






		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>
