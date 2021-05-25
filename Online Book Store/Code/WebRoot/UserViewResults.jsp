<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
		<jsp:include page="UserMenu.jsp"></jsp:include>
		<h2>
			Search Results are:
		</h2>
		<jsp:include page="status.jsp"></jsp:include>
		<c:if test="${not empty bookinfo}">
			<c:forEach var="bookinfo" items="${bookinfo}">
				
	
				<table>

					<tr>
						<td>
							<img src="${bookinfo.image }" height="150" width="150">
						</td>
						<td>
						</td>
						<td>
							<div>
								<form name="f1" action="./WriteOpnion" method="post">
											
									Write Opinion here
									<textarea rows="10" cols="10" name="opinion"> </textarea>
									<input type="hidden" name="isbn" value="${bookinfo.isbn }">
									<input type="submit" name="submit" value="post">
								</form>
							</div>
						</td>
					</tr>

					<tr>
						<td>
							<font color="red" size="3">ISBN NO:</font>
						</td>
						<td>
							${bookinfo.isbn }
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
							<font color="red" size="3">Author :</font>
						</td>
						<td>
							${bookinfo.fname}
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
								href="./AddToCartAction?isbn=${bookinfo.isbn}&price=${bookinfo.price}">Add
								To Cart</a>
						</td>
						<td>
							<a href="./ViewEditorials?isbn=${bookinfo.isbn}">View
								Editorials</a>
						</td>
						</tr>
						</c:forEach>
		</c:if>
						<tr>
						
						<td>
						<h2>View Editorials here</h2>
						<table border="1" bgcolor="yellow" width="100%" align="right" height="50">
						<tr>
						<c:if test="${not empty eDtos}">
						<c:forEach var="dto" items="${eDtos}">
						
						
						<td>${dto.isbn}</td>
						<td>${dto.editorial }</td>
						</c:forEach>
						</c:if>
						<br/>
						</tr>
						</table>
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