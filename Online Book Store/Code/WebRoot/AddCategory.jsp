<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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

		<title>My JSP 'AddCtaegory.jsp' starting page</title>

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

if (emptyvalidation(category,"Please Enter a Category name")==false) {category.focus(); return false;};
}
}
</script>

	</head>


	<body>
		<jsp:include page="Header.jsp"></jsp:include>
		<jsp:include page="AdminMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
		<form action="./AddCategoryAction" name="form1" method="get" onsubmit="return formvalidation(this)">
		<table align="center" >
		<tr>
		<th>
		<h3>Enter Category Name </h3>
		</th>
		<td>
		<input type="text" name="category" value="">
		</td>
		</tr>
		<br/>
		<tr align="center">
		<td><input type="submit" name="submit" value="submit">
		</td>
		</tr>
		</table>
			</form>
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


