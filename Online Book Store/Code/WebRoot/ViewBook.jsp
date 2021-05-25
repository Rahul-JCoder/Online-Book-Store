<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.online.bean.*"%>
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

		<title>My JSP 'UserViewResults.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>
<%int i=0; %>
	<body  onload="Carousel()">
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="AdminMenu.jsp"></jsp:include>
		<h2>
			Search Results are:
		</h2>
		<jsp:include page="status.jsp"></jsp:include>
		<c:if test="${not empty bookinfo}">
			<c:forEach var="bookinfo" items="${bookinfo}">
				<table>
        <tr>
					<td bgcolor="#F4F5F7"> <p><img alt="See Photo Here" id="previewField" src="books_images/${bookinfo.image }" height="150" width="150"></p></td>
						<td>
						</td>
						<td>
							<div>
								
							</div>
						</td>
					</tr>

					<tr>
						<td>
							<font color="red" size="3">ISBN NO:</font>
						</td>
						<td>
						
						 <a href="./UpdateBookAction?isbn=${bookinfo.isbn}">${bookinfo.isbn}</a>
						
						
							
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Title :</font>
						</td>
						<td>
							${bookinfo.title }
						</td>
					</tr>
					
					<tr>
						<td>
							<font color="red" size="3">Description :</font>
						</td>
						<td>
							${bookinfo.description }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Price :</font>
						</td>
						<td>
							${bookinfo.price }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Publisher</font>
						</td>
						<td>
							${bookinfo.publisher }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Publication Date</font>
						</td>
						<td>
							${bookinfo.publicationdate }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Edition</font>
						</td>
						<td>
							${bookinfo.edition }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Pages</font>
						</td>
						<td>
							${bookinfo.pages }
						</td>
					</tr>
					<tr>
						<td>
							<font color="red" size="3">Language</font>
						</td>
						<td>
							${bookinfo.language }
						</td>
					</tr>
					<tr>
						<td>
							<a
								href="./DeleteBookAction?isbn=${bookinfo.isbn}">DeleteBook</a>
						</td>
		
						
						</tr>
						</c:forEach>
		</c:if>
						</td>
						
						</tr>
						<c:if test="${empty eDtos}">
					
						</c:if>

					
				</table>
			
		<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	</body>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>