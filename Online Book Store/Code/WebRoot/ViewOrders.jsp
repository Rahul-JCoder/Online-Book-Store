<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ViewOrders.jsp' starting page</title>
    
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
		<jsp:include page="AdminMenu.jsp"></jsp:include>

		<jsp:include page="status.jsp"></jsp:include>
	<table align="center" border="1">
	<tr bgcolor="lightblue">
	<th>Orderid</th>
	<th>userid</th>
	<th>Order date</th>
	<th>Total Amount</th>
	<th>Status</th>
	<th>ChangeStatus</th>
	</tr>
	<c:if test="${not empty dtos}">
	<c:forEach var="dtos" items="${dtos}">
	<tr>
	<td>${dtos.orderid }</td>
	<td>${dtos.userid }</td>
	<td>${dtos.orderdate }</td>
	<td>${dtos.price }</td>
	<td>${dtos.orderstatus }</td>
	<td><a href="./ConfirmOrder?id=${dtos.orderid }">Confirm</a><a href="./RejectOrder?id=${dtos.orderid }">/Reject</a></td>
	</tr>
	</c:forEach>
	</c:if>
	
	</table>

 </body>
	<br/>
	<br/>
	<br />
		<br />
		<br />
		<jsp:include page="Footer.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="css/scroll.css">
</html>
