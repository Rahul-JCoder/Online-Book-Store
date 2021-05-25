<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.online.util.UtilConstants"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'SearchByCategory.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
		<jsp:include page="Header.jsp"></jsp:include>
			<%String role= (String)session.getAttribute(UtilConstants._ROLE); 
		if(role.equalsIgnoreCase("user"))
		{%>
		
		<jsp:include page="UserMenu.jsp"></jsp:include>
		<%}else
		{
		 %>
		<jsp:include page="SubMenu.jsp"></jsp:include>
		<%} %>
		<form action="./SearchByCategory" method="get" name="f3">
		<input type="hidden" name="path" value="SearchResults.jsp">
			<table align="center" height="250">
				<tr>
					<td>
						<h1>
							Search by Category:
						</h1>
						<br />
						Select Book Category:
						<select name="query">
						<option>select one</option>
							<c:forEach var="dtos" items="${dtos}">
								<option value="${dtos.categoryid }">
									${dtos.categoryname}
								</option>

							</c:forEach>

						</select>

						<br />
						<br />
						<input type="submit" name="submit" src="images/button.jpeg"
							style="elevation: grad">
					</td>

				</tr>

			</table>
		</form>
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>