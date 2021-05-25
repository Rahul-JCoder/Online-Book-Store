<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.online.util.UtilConstants"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SearchByPrice.jsp' starting page</title>
    
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

if (emptyvalidation(minprice,"Please Enter a minimum price")==false) {minprice.focus(); return false;};
if (emptyvalidation(maxprice,"Please Enter a maximum price")==false) {maxprice.focus(); return false;};
}
}
</script>

  </head>
  
 <body >
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
		<form action="./SearchByPrice" method="get" name="f3" onsubmit="return formvalidation(this)">
		<input type="hidden" name="path" value="SearchResults.jsp">
			<table align="center" height="250">
				<tr>
					<td>
						<h1>
							Search by Price:
						</h1>
						<br/>
				Enter Min Price:<input type="text" name="minprice" value="">
				<br/>
				Enter Max Price:<input type="text" name="maxprice" value="">
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