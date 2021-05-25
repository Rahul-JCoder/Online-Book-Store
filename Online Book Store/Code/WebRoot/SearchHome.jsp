<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SearchHome.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  

 <body  onload="Carousel()">
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="SubMenu.jsp"></jsp:include>
		<form action="./SearchAction" method="get" name="f3">
		<input type="hidden" name="path" value="SearchByTitle.jsp">
			<table align="center" height="250">
				<tr>
					<td>
						<h1>
							Search by Title:
						</h1>
						<br/>
				Enter Book title:	<input type="text" name="titlesearch">
				<br/>
				<br/>
				<input type="submit" name="submit"  src="images/button.jpeg" style="elevation: grad">
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
 

