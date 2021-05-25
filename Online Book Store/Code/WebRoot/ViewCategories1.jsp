<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

		<title>My JSP 'ViewCategories.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body >
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="UserMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
		<center><h3>
			     All Books Categories 		</h3></center>
		<br/>
		<table align="center" border="1">
			<tr>
				<th>
					Categoryid
				</th>
				<th>
					Category Name
				</th>
			</tr>
			<c:forEach var="dtos" items="${dtos}">
			<tr>
				
					<td>
					${dtos.categoryid }
					</td>
					<td>
					${dtos.categoryname }
					</td>
				
			</tr>
			</c:forEach>
		</table>
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />
		<br />

		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>



