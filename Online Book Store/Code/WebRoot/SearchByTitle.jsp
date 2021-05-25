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

		<title>My JSP 'SearchByTitle.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function emptyvalidation(entered, alertbox)
{

with (entered)
{
if (value==null || value=="")
{if (alertbox!="") {alert(alertbox);} return false;}
else {return true;}
}
} 

function formvalidation(thisform)
{
with (thisform)
{

if (emptyvalidation(query,"Please Enter a title name")==false) {query.focus(); return false;};
}
}
</script>

	</head>


	<body onload="Carousel()">
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
		<jsp:include page="status.jsp"></jsp:include>
		 <% if(request.getAttribute("count")!=null)
					  {%>
                           <center> <strong><font color="black"><%=request.getAttribute("count")%>items in the cart</font></strong>
                           
                          
                      <%}%></center> 
		<form action="./SearchAction" method="get" name="f3" onsubmit="return formvalidation(this)">
		<input type="hidden" name="path" value="SearchByTitle.jsp">
			<table align="center" height="250">
				<tr>
					<td>
						<h3>
							Search by Title
						</h3>
						<br/>
				Enter Book title:	<input type="text" name="query" value="">
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


